package app.Entity;

import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
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
	private long Id;
	@Pattern(regexp = "^(\\S+\\s+\\S+.*)$", message = "Nome deve ter pelo menos duas palavras.")
	private String Nome;
	@CPF(message = ("CPF invalido"))
	private String CPF;
	@Email(message = ("Email invalido!"))
	private String Email;
	@Column(nullable = true)
	@Pattern(regexp = "^(\\S+\\s+\\S+.*)?$", message = "Especialidade deve ter pelo menos duas palavras.")
	private String Especialidade;
	
	@ManyToMany
	private List<Turma> turma;
	
	
	
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
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getEspecialidade() {
		return Especialidade;
	}
	public void setEspecialidade(String especalidade) {
		Especialidade = especalidade;
	}
	public Professor(long id, String nome, String cPF, String email, String especalidade) {
		super();
		Id = id;
		Nome = nome;
		CPF = cPF;
		Email = email;
		Especialidade = especalidade;
	}
	public Professor() {
		super();
	}
	
	
	
}
