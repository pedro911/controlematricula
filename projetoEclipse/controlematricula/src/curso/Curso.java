package curso;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the curso database table.
 * 
 */
@Entity
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcurso;

	@Column(name="concurso_idconcurso")
	private int concursoIdConcurso;

    
	@Column(name="dt_fim")
	private Date dtFim;

    
	@Column(name="dt_inicio")
	private Date dtInicio;

	private String ementa;

	private String nome;

	@Column(name="qtd_alunos")
	private int qtdAlunos;

	private double valor;

    public Curso() {
    }

	public int getIdCurso() {
		return this.idcurso;
	}

	public void setIdCurso(int idCurso) {
		this.idcurso = idCurso;
	}

	public int getConcursoIdConcurso() {
		return this.concursoIdConcurso;
	}

	public void setConcursoIdConcurso(int concursoIdConcurso) {
		this.concursoIdConcurso = concursoIdConcurso;
	}

	public Date getDtFim() {
		return this.dtFim;
	}

	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}

	public Date getDtInicio() {
		return this.dtInicio;
	}

	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}

	public String getEmenta() {
		return this.ementa;
	}

	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtdAlunos() {
		return this.qtdAlunos;
	}

	public void setQtdAlunos(int qtdAlunos) {
		this.qtdAlunos = qtdAlunos;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}