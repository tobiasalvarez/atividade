package app.Entity;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Aluno {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank(message = "O nome e obrigatorio!!")
	private String nome;
	@CPF(message = "O CPF e obrigatorio")
	private String cpf;
	private String telefone;
	private boolean cadastroCompleto;
	
	@ManyToOne
	@JoinColumn(name = "turma_id") //Para buscar alunos pelo nome da turma
	@JsonIgnoreProperties("alunos")
	private Turma turma;
	
	
}
