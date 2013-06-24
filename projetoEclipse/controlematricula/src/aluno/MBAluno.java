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
	public MBAluno(){
		aluno = new Aluno();
	}

	public String cadastrarAluno() {
		String retorno="Usu�rio cadastrado com sucesso";
		AlunoDAOImpl daoAluno = new AlunoDAOImpl();
		daoAluno.save(aluno);
		return retorno;
	}

	public String apagarAluno() throws ClassNotFoundException, SQLException {
		// pega o parametro passado no link
		Integer id = Integer.parseInt((String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id"));
		String retorno ="";
		AlunoDAOImpl daoAluno = new AlunoDAOImpl();
		daoAluno.remove(aluno);
		return retorno;
	}

	public String editarAluno() throws ClassNotFoundException, SQLException{
		// pega o parametro passado no link
		Integer id = Integer.parseInt((String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id"));
		String retorno ="Usu�rio alterado com sucesso";
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

		Integer id = Integer.parseInt((String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id"));
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

	// M�TODOS DE NAVEGA��O...

	public String novo() {
		aluno = new Aluno();
		return "inserirAluno.jsp";
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
		return "inserirAluno.jsp";
	}

	public String salvar() {
		cadastrarAluno();
		return "ListagemAluno.jsp";
	}

}