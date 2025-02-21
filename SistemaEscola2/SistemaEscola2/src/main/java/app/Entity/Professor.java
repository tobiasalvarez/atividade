package app.Entity;

import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
public class Professor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank(message = "O nome e obrigatorio!!")
	@Pattern(regexp = "^(\\S+\\s+\\S+.*)$", message = "Nome deve ter pelo menos duas palavras.")
	private String nome;
	@CPF(message = ("CPF invalido"))
	private String cpf;
	@Email(message = ("Email invalido!"))
	private String email;
	@Column(nullable = true)
	@Pattern(regexp = "^(\\S+\\s+\\S+.*)?$", message = "Especialidade deve ter pelo menos duas palavras.")
	private String especialidade;
	
	@ManyToMany(mappedBy = "professores")
	@JsonIgnoreProperties("professores")
	//@JoinTable(name = "turma_professor")
	//@NotEmpty(message = "nao e possivel sem uma turma associada.")
	private List<Turma> turmas;
	
	
	
	
}
