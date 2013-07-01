package funcionario;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="MBFuncionario")
@SessionScoped
public class MBFuncionario {
		
	private static MBFuncionario MBFuncionario = new MBFuncionario();
	private Funcionario funcionario;
	private int pagina=1;
	private Integer idSelecionado;
	
	public MBFuncionario(){
		funcionario = new Funcionario();
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

	public void cadastrarFuncionario() {
		//String retorno="Funcionario cadastrado com sucesso";
		FuncionarioDAOImpl daoFuncionario = new FuncionarioDAOImpl();
		daoFuncionario.save(funcionario);
		//return retorno;
	}

	//public String apagarFuncionario() throws ClassNotFoundException, SQLException {
	public void apagarFuncionario() throws ClassNotFoundException, SQLException{
		// pega o parametro passado no link
		Integer id = Integer.parseInt((String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idfuncionario"));
		//String retorno ="";
		FuncionarioDAOImpl daoFuncionario = new FuncionarioDAOImpl();
		funcionario = retornarFuncionario(id);
		daoFuncionario.remove(funcionario);
		//return retorno;
	}

	public String editarFuncionario() throws ClassNotFoundException, SQLException{
		// pega o parametro passado no link
		Integer id = Integer.parseInt((String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idfuncionario"));
		String retorno ="Usuário alterado com sucesso";
		//funcionario = retornarFuncionario(id);

		FuncionarioDAOImpl daoFuncionario = new FuncionarioDAOImpl();
		daoFuncionario.save(funcionario);			

		return retorno;
	}
	public Funcionario retornarFuncionario(int id) throws ClassNotFoundException, SQLException{

		FuncionarioDAOImpl daoFuncionario = new FuncionarioDAOImpl();
		funcionario = daoFuncionario.getById(Funcionario.class, id);
		return funcionario;
		
	}
	public Funcionario retornarFuncionario() throws ClassNotFoundException, SQLException{

		Integer id = Integer.parseInt((String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idfuncionario"));
		FuncionarioDAOImpl daoFuncionario = new FuncionarioDAOImpl();
		funcionario =  daoFuncionario.getById(Funcionario.class, id);
		return funcionario ;
		//return FuncionarioDAOImpl.getInstance().retornarFuncionario(matricula);
	}
	public List<Funcionario> getFuncionarios() throws ClassNotFoundException, SQLException{
		List<Funcionario> lista = new ArrayList<Funcionario>();
		FuncionarioDAOImpl daoFuncionario = new FuncionarioDAOImpl();
		lista = daoFuncionario.getAll(Funcionario.class);
		return lista;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	// MÉTODOS DE NAVEGAÇÃO...

	public String novo() {
		funcionario = new Funcionario();
		return "CadastroFuncionario.xhtml";
	}
	public String editar() {
		try {
			retornarFuncionario();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "CadastroFuncionario.xhtml";
	}

	public String salvar() {
		cadastrarFuncionario();
		return "ListagemFuncionario.xhtml";
	}
		
	public String funcionarios() throws ClassNotFoundException, SQLException {
		getFuncionarios();
		return "ListagemFuncionario.xhtml";
	}

}
