package app.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	@Pattern(regexp = "^(\\S+\\s+\\S+.*)$", message = "Nome deve ter pelo menos duas palavras.")
	@NotNull
	private String Nome;
	private String Semestre;
	private int Ano;
	private String Turno;
	
	@ManyToMany
	private List<Professor> professor;
	
	@ManyToOne
	private Curso curso;
	
	//lombok nao ta funcionando
	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getSemestre() {
		return Semestre;
	}
	public void setSemestre(String semestre) {
		Semestre = semestre;
	}
	public int getAno() {
		return Ano;
	}
	public void setAno(int ano) {
		Ano = ano;
	}
	public String getTurno() {
		return Turno;
	}
	public void setTurno(String turno) {
		Turno = turno;
	}
	public Turma(long id, String nome, String semestre, int ano, String turno) {
		super();
		Id = id;
		Nome = nome;
		Semestre = semestre;
		Ano = ano;
		Turno = turno;
	}
	public Turma() {
		super();
	}
	
	
	
	
}
