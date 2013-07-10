package curso;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import concurso.Concurso;

import aluno.Aluno;
import aluno.AlunoDAOImpl;

@ManagedBean(name="MBCurso")
@SessionScoped
public class MBCurso {
		
	private static MBCurso MBCurso = new MBCurso();
	private Curso curso;
	private int pagina=1;
	private Integer idSelecionado;
	private List<SelectItem> listaCursos = new ArrayList<SelectItem>();
	private int concursoSelecionado;
	
	
	public int getConcursoSelecionado() {
		return concursoSelecionado;
	}

	public void setConcursoSelecionado(int concursoSelecionado) {
		this.concursoSelecionado = concursoSelecionado;
	}

	public MBCurso(){
		curso = new Curso();
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

	public String cadastrarCurso() {
		String retorno="Curso cadastrado com sucesso";
		CursoDAOImpl daoCurso = new CursoDAOImpl();
		curso.setConcursoIdConcurso(concursoSelecionado);
		daoCurso.save(curso);
		return retorno;
	}

	//public String apagarCurso() throws ClassNotFoundException, SQLException {
	public void apagarCurso() throws ClassNotFoundException, SQLException{
		// pega o parametro passado no link
		Integer id = Integer.parseInt((String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idcurso"));
		//String retorno ="";
		CursoDAOImpl daoCurso = new CursoDAOImpl();
		curso = retornarCurso(id);
		daoCurso.remove(curso);
		//return retorno;
	}

	public String editarCurso() throws ClassNotFoundException, SQLException{
		// pega o parametro passado no link
		Integer id = Integer.parseInt((String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idcurso"));
		String retorno ="Curso alterado com sucesso";
		//curso = retornarCurso(id);

		CursoDAOImpl daoCurso = new CursoDAOImpl();
		daoCurso.save(curso);			

		return retorno;
	}
	public Curso retornarCurso(int id) throws ClassNotFoundException, SQLException{

		CursoDAOImpl daoCurso = new CursoDAOImpl();
		curso = daoCurso.getById(Curso.class, id);
		return curso;
		
	}
	public Curso retornarCurso() throws ClassNotFoundException, SQLException{

		Integer id = Integer.parseInt((String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idcurso"));
		CursoDAOImpl daoCurso = new CursoDAOImpl();
		curso =  daoCurso.getById(Curso.class, id);
		return curso ;
		//return CursoDAOImpl.getInstance().retornarCurso(matricula);
	}
	public List<Curso> getCursos() throws ClassNotFoundException, SQLException{
		List<Curso> lista = new ArrayList<Curso>();
		CursoDAOImpl daoCurso = new CursoDAOImpl();
		lista = daoCurso.getAll(Curso.class);
		return lista;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public List<SelectItem> getListaCursos() {
		List<Curso> lista = new ArrayList<Curso>();
		CursoDAOImpl daoCurso = new CursoDAOImpl();
		lista = daoCurso.getAll(Curso.class);
		List<SelectItem> list = new ArrayList<SelectItem>();  
	    for(int index = 0; index <lista.size(); index++) {  
	        list.add(new SelectItem(lista.get(index).getIdCurso(),lista.get(index).getNome()));  
	    }
	    listaCursos = list;
	    return listaCursos;		
	}

	public void setListaCursos(List<SelectItem> listaCursos) {
		this.listaCursos = listaCursos;
	}

	// MÉTODOS DE NAVEGAÇÃO...

	public String novo() {
		curso = new Curso();
		return "CadastroCurso.xhtml";
	}
	public String editar() {
		try {
			retornarCurso();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "CadastroCurso.xhtml";
	}

	public String salvar() {
		cadastrarCurso();
		return "ListagemCurso.xhtml";
	}
		
	public String cursos() throws ClassNotFoundException, SQLException {
		getCursos();
		return "ListagemCurso.xhtml";
	}

}
