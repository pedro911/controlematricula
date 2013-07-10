package concurso;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import curso.Curso;
import curso.CursoDAOImpl;

@ManagedBean(name="MBConcurso")
@SessionScoped
public class MBConcurso {
		
	private static MBConcurso MBConcurso = new MBConcurso();
	private Concurso concurso;
	private int pagina=1;
	private Integer idSelecionado;
	private List<SelectItem> listaConcursos = new ArrayList<SelectItem>();
	
	
	
	public MBConcurso(){
		concurso = new Concurso();
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

	public String cadastrarConcurso() {
		String retorno="Concurso cadastrado com sucesso";
		ConcursoDAOImpl daoConcurso = new ConcursoDAOImpl();
		daoConcurso.save(concurso);
		return retorno;
	}

	//public String apagarConcurso() throws ClassNotFoundException, SQLException {
	public void apagarConcurso() throws ClassNotFoundException, SQLException{
		// pega o parametro passado no link
		Integer id = Integer.parseInt((String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idconcurso"));
		//String retorno ="";
		ConcursoDAOImpl daoConcurso = new ConcursoDAOImpl();
		concurso = retornarConcurso(id);
		daoConcurso.remove(concurso);
		//return retorno;
	}

	public String editarConcurso() throws ClassNotFoundException, SQLException{
		// pega o parametro passado no link
		Integer id = Integer.parseInt((String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idconcurso"));
		String retorno ="Concurso alterado com sucesso";
		//concurso = retornarConcurso(id);

		ConcursoDAOImpl daoConcurso = new ConcursoDAOImpl();
		daoConcurso.save(concurso);			

		return retorno;
	}
	public Concurso retornarConcurso(int id) throws ClassNotFoundException, SQLException{

		ConcursoDAOImpl daoConcurso = new ConcursoDAOImpl();
		concurso = daoConcurso.getById(Concurso.class, id);
		return concurso;
		
	}
	public Concurso retornarConcurso() throws ClassNotFoundException, SQLException{

		Integer id = Integer.parseInt((String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idconcurso"));
		ConcursoDAOImpl daoConcurso = new ConcursoDAOImpl();
		concurso =  daoConcurso.getById(Concurso.class, id);
		return concurso ;
		//return ConcursoDAOImpl.getInstance().retornarConcurso(matricula);
	}
	public List<Concurso> getConcursos() throws ClassNotFoundException, SQLException{
		List<Concurso> lista = new ArrayList<Concurso>();
		ConcursoDAOImpl daoConcurso = new ConcursoDAOImpl();
		lista = daoConcurso.getAll(Concurso.class);
		return lista;
	}

	public Concurso getConcurso() {
		return concurso;
	}

	public void setConcurso(Concurso concurso) {
		this.concurso = concurso;
	}
	
	public List<SelectItem> getListaConcursos() {
		List<Concurso> lista = new ArrayList<Concurso>();
		ConcursoDAOImpl daoConcurso = new ConcursoDAOImpl();
		lista = daoConcurso.getAll(Concurso.class);
			List<SelectItem> list = new ArrayList<SelectItem>();  
	    for(int index = 0; index <lista.size(); index++) {  
	        list.add(new SelectItem(lista.get(index).getIdconcurso(),lista.get(index).getNome()));  
	    }
	    listaConcursos = list;
	    return listaConcursos;		
	}

	public void setListaConcursos(List<SelectItem> listaConcursos) {
		this.listaConcursos = listaConcursos;
	}

	// MÉTODOS DE NAVEGAÇÃO...

	public String novo() {
		concurso = new Concurso();
		return "CadastroConcurso.xhtml";
	}
	public String editar() {
		try {
			retornarConcurso();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "CadastroConcurso.xhtml";
	}

	public String salvar() {
		cadastrarConcurso();
		return "ListagemConcurso.xhtml";
	}
		
	public String concursos() throws ClassNotFoundException, SQLException {
		getConcursos();
		return "ListagemConcurso.xhtml";
	}

}
