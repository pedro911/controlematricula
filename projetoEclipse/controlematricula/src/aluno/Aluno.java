package aluno;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the aluno database table.
 * 
 */
@Entity
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idaluno;

	private String email;

	private String nome;

    public Aluno() {
    }

	public int getIdaluno() {
		return this.idaluno;
	}

	public void setIdaluno(int idaluno) {
		this.idaluno = idaluno;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}