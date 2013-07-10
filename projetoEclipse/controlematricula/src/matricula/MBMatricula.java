package matricula;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Size;

import curso.Curso;
import curso.MBCurso;
import funcionario.Funcionario;
import funcionario.MBFuncionario;

import aluno.Aluno;
import aluno.MBAluno;

@ManagedBean(name="MBMatricula")
@SessionScoped
public class MBMatricula {
		
	private static MBMatricula MBMatricula = new MBMatricula();
	private Matricula matricula;
	private int pagina=1;
	private Integer idSelecionado;
	private int idalunoSelecionado;
	private int idcursoSelecionado;
	private int idfuncionarioSelecionado;
	private Aluno aluno;
	private Curso curso;
	private Funcionario funcionario;
	//setar o id para aluno,curso e funcionario do banco para depois listar...
	
	

	public int getIdalunoSelecionado() {
		return idalunoSelecionado;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public void setIdalunoSelecionado(int idalunoSelecionado) {
		this.idalunoSelecionado = idalunoSelecionado;
	}

	public int getIdcursoSelecionado() {
		return idcursoSelecionado;
	}

	public void setIdcursoSelecionado(int idcursoSelecionado) {
		this.idcursoSelecionado = idcursoSelecionado;
	}

	public int getIdfuncionarioSelecionado() {
		return idfuncionarioSelecionado;
	}

	public void setIdfuncionarioSelecionado(int idfuncionarioSelecionado) {
		this.idfuncionarioSelecionado = idfuncionarioSelecionado;
	}

	public MBMatricula(){
		matricula = new Matricula();
	}
	
	public Integer getIdSelecionado() {
		return idSelecionado;
	}

	public void setIdSelecionado(Integer idSelecionado) {
		this.idSelecionado = idSelecionado;
	}
		
	public int getPagina() {
		return pagina;
	}

	public void setPagina(int pagina) {
		this.pagina = pagina;
	}

	public void cadastrarMatricula() {
		//String retorno="Matricula cadastrado com sucesso";
		MatriculaDAOImpl daoMatricula = new MatriculaDAOImpl();
		matricula.setId(new MatriculaPK(idalunoSelecionado,idcursoSelecionado));
		matricula.setFuncionarioIdfuncionario(idfuncionarioSelecionado);
		daoMatricula.save(matricula);
		//return retorno;
	}

	//public String apagarMatricula() throws ClassNotFoundException, SQLException {
	public void apagarMatricula() throws ClassNotFoundException, SQLException{
		// pega o parametro passado no link
		Integer id = Integer.parseInt((String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idmatricula"));
		//String retorno ="";
		MatriculaDAOImpl daoMatricula = new MatriculaDAOImpl();
		matricula = retornarMatricula(id);
		daoMatricula.remove(matricula);
		//return retorno;
	}

	public String editarMatricula() throws ClassNotFoundException, SQLException{
		// pega o parametro passado no link
		Integer id = Integer.parseInt((String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idmatricula"));
		String retorno ="Usu�rio alterado com sucesso";
		//matricula = retornarMatricula(id);

		MatriculaDAOImpl daoMatricula = new MatriculaDAOImpl();
		daoMatricula.save(matricula);			

		return retorno;
	}
	public Matricula retornarMatricula(int id) throws ClassNotFoundException, SQLException{

		MatriculaDAOImpl daoMatricula = new MatriculaDAOImpl();
		matricula = daoMatricula.getById(Matricula.class, id);
		return matricula;
		
	}
	public Matricula retornarMatricula() throws ClassNotFoundException, SQLException{

		Integer id = Integer.parseInt((String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idmatricula"));
		MatriculaDAOImpl daoMatricula = new MatriculaDAOImpl();
		matricula =  daoMatricula.getById(Matricula.class, id);
		return matricula ;
		//return MatriculaDAOImpl.getInstance().retornarMatricula(matricula);
	}
	public List<Matricula> getMatriculas() throws ClassNotFoundException, SQLException{
		List<Matricula> lista = new ArrayList<Matricula>();
		MatriculaDAOImpl daoMatricula = new MatriculaDAOImpl();
		lista = daoMatricula.getAll(Matricula.class);
		MBAluno mbAluno = new MBAluno();
		MBCurso mbCurso = new MBCurso();
		MBFuncionario mbFuncionario = new MBFuncionario();				
		for (int index=0;index<lista.size();index++){
			aluno.setIdaluno(lista.get(index).getId().getAlunoIdaluno());
			curso.setConcursoIdConcurso(lista.get(index).getId().getCursoIdcurso());
			funcionario.setIdfuncionario(lista.get(index).getFuncionarioIdfuncionario());
		}
		aluno = mbAluno.retornarAluno(aluno.getIdaluno());
		curso = mbCurso.retornarCurso(curso.getIdCurso());
		funcionario = mbFuncionario.retornarFuncionario(funcionario.getIdfuncionario());
		return lista;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	// M�TODOS DE NAVEGA��O...

	public String novo() {
		matricula = new Matricula();
		return "CadastroMatricula.xhtml";
	}
	public String editar() {
		try {
			retornarMatricula();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "CadastroMatricula.xhtml";
	}
	public String salvar() {
		cadastrarMatricula();
		return "ListagemMatricula.xhtml";
	}
		
	public String matriculas() throws ClassNotFoundException, SQLException {
		getMatriculas();
		return "ListagemMatricula.xhtml";
	}

}
