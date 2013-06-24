package matricula;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the matricula database table.
 * 
 */
@Embeddable
public class MatriculaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="aluno_idaluno")
	private int alunoIdaluno;

	@Column(name="curso_idcurso")
	private int cursoIdcurso;

    public MatriculaPK() {
    }
	public int getAlunoIdaluno() {
		return this.alunoIdaluno;
	}
	public void setAlunoIdaluno(int alunoIdaluno) {
		this.alunoIdaluno = alunoIdaluno;
	}
	public int getCursoIdcurso() {
		return this.cursoIdcurso;
	}
	public void setCursoIdcurso(int cursoIdcurso) {
		this.cursoIdcurso = cursoIdcurso;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MatriculaPK)) {
			return false;
		}
		MatriculaPK castOther = (MatriculaPK)other;
		return 
			(this.alunoIdaluno == castOther.alunoIdaluno)
			&& (this.cursoIdcurso == castOther.cursoIdcurso);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.alunoIdaluno;
		hash = hash * prime + this.cursoIdcurso;
		
		return hash;
    }
}