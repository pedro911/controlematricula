package funcionario;

import javax.annotation.Resource;  
import javax.faces.application.FacesMessage;  
import javax.faces.component.UIComponent;  
import javax.faces.component.UIInput;  
import javax.faces.context.FacesContext;  
import javax.faces.validator.Validator;  
import javax.faces.validator.ValidatorException;  

public class ValidarLogin implements Validator{
		
	@Resource  
	private static MBFuncionario MBFuncionario = new MBFuncionario();
	private Funcionario funcionario;
	
    public void setFuncionarioDao(UsuarioDao usuarioDao) {  
        this.usuarioDao = usuarioDao;  
    }  
    
    public void validate(FacesContext context, UIComponent toValidate, Object value) throws ValidatorException {  
        Usuario login = new Usuario();  
  
        login.setLogin((String) value);  
       //para verificar se o dao esta vindo nulo...  
        if(usuarioDao!=null){  
            System.out.println("ele nao eh nulo!");  
  
        }else{  
            System.out.println("ele EH nulo!");  
        }  
  
  
    if (usuarioDao.getUsuarioByNomeUsuario(login)!=null) {  
        ((UIInput)toValidate).setValid(false);  
  
        FacesMessage message = new FacesMessage("Por favor escolha outro login, pois este já existe.");  
        context.addMessage(toValidate.getClientId(context), message);  
    }  
    } 

}
