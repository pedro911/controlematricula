package aluno;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="MBAluno")
@SessionScoped
public class MBAluno {
		
	private static MBAluno MBAluno = new MBAluno();
	private Aluno aluno;
	private int pagina=1;
	private Integer idSelecionado;
	
	public MBAluno(){
		aluno = new Aluno();
	}
	
	public Integer getIdSelecionado() {
		return idSelecionado;
	}

	public void setIdSelecionado(Integer idSelecionado) {
		System.out.println("SET idSelecionado = "+idSelecionado);

		this.idSelecionado = idSelecionado;
	}
		
	public int getPagina() {
		return pagina;
	}

	public void setPagina(int pagina) {
		this.pagina = pagina;
	}

	public String cadastrarAluno() {
		String retorno="Aluno cadastrado com sucesso";
		AlunoDAOImpl daoAluno = new AlunoDAOImpl();
		daoAluno.save(aluno);
		return retorno;
	}

	//public String apagarAluno() throws ClassNotFoundException, SQLException {
	public void apagarAluno() throws ClassNotFoundException, SQLException{
		// pega o parametro passado no link
		Integer id = Integer.parseInt((String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idaluno"));
		//String retorno ="";
		AlunoDAOImpl daoAluno = new AlunoDAOImpl();
		aluno = retornarAluno(id);
		daoAluno.remove(aluno);
		//return retorno;
	}

	public String editarAluno() throws ClassNotFoundException, SQLException{
		// pega o parametro passado no link
		Integer id = Integer.parseInt((String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idaluno"));
		String retorno ="Usuário alterado com sucesso";
		//aluno = retornarAluno(id);

		AlunoDAOImpl daoAluno = new AlunoDAOImpl();
		daoAluno.save(aluno);			

		return retorno;
	}
	public Aluno retornarAluno(int id) throws ClassNotFoundException, SQLException{

		AlunoDAOImpl daoAluno = new AlunoDAOImpl();
		aluno = daoAluno.getById(Aluno.class, id);
		return aluno;
		
	}
	public Aluno retornarAluno() throws ClassNotFoundException, SQLException{

		Integer id = Integer.parseInt((String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idaluno"));
		AlunoDAOImpl daoAluno = new AlunoDAOImpl();
		aluno =  daoAluno.getById(Aluno.class, id);
		return aluno ;
		//return AlunoDAOImpl.getInstance().retornarAluno(matricula);
	}
	public List<Aluno> getAlunos() throws ClassNotFoundException, SQLException{
		List<Aluno> lista = new ArrayList<Aluno>();
		AlunoDAOImpl daoAluno = new AlunoDAOImpl();
		lista = daoAluno.getAll(Aluno.class);
		return lista;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	// MÉTODOS DE NAVEGAÇÃO...

	public String novo() {
		aluno = new Aluno();
		return "CadastroAluno.xhtml";
	}
	public String editar() {
		try {
			retornarAluno();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "CadastroAluno.xhtml";
	}

	public String salvar() {
		cadastrarAluno();
		return "ListagemAluno.xhtml";
	}
		
	public String alunos() throws ClassNotFoundException, SQLException {
		getAlunos();
		return "ListagemAluno.xhtml";
	}

}
