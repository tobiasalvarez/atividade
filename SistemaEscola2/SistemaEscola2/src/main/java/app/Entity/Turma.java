package app.Entity;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
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
	private String nome;
	private String semestre;
	private int ano;
	private String turno;
	
	@ManyToMany
	@JoinTable(name = "professor_turma")
	@JsonIgnoreProperties("turmas")
	@NotEmpty(message = "nao e possivel existir sem um professor")
	private List<Professor> professores;
	
	@OneToMany(mappedBy = "turma")
	private List<Aluno> alunos;
	
	@ManyToOne 
	@NotNull(message = "o curso e obrigatorio para criar uma turma")
	//@JoinTable(name = "curso_turma")
	private Curso curso;
	
	//lombok nao ta funcionando
	
	
	
	
	
	
}
