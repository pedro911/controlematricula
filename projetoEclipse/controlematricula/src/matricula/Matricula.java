package matricula;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the matricula database table.
 * 
 */
@Entity
public class Matricula implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MatriculaPK id;

	@Column(name="funcionario_idfuncionario")
	private int funcionarioIdfuncionario;

	private double valor;

    public Matricula() {
    }

	public MatriculaPK getId() {
		return this.id;
	}

	public void setId(MatriculaPK id) {
		this.id = id;
	}
	
	public int getFuncionarioIdfuncionario() {
		return this.funcionarioIdfuncionario;
	}

	public void setFuncionarioIdfuncionario(int funcionarioIdfuncionario) {
		this.funcionarioIdfuncionario = funcionarioIdfuncionario;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}