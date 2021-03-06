package concurso;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the concurso database table.
 * 
 */
@Entity
public class Concurso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idconcurso;

	private String nome;

    public Concurso() {
    }

	public int getIdconcurso() {
		return this.idconcurso;
	}

	public void setIdconcurso(int idconcurso) {
		this.idconcurso = idconcurso;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}