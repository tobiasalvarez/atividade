package app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.Entity.Professor;
import app.Repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository professorRepository;
	

	public String save(Professor professor) {
		
		//Regra 01 excecoes
		Professor prof = this.professorRepository.findByEmail(professor.getEmail());
		if (prof != null) {
			throw new RuntimeException("Email ja cadastrado "+ prof.getEmail());
		}else if (professor.getEmail() != null && professor.getEmail().endsWith("@outlook.com")) {
			throw new RuntimeException("Dominio de email nao permitido...");
		}
		
		this.professorRepository.save(professor);
		return "Professor salvo com sucesso!!";	
	}
	
	
	public String delete(long Id) {
		this.professorRepository.deleteById(Id);
		return "Professor deletado com sucesso!!";
	}
	
	public Professor findById(long Id) {
		Professor professor = this.professorRepository.findById(Id).get();
		return professor;
	}
	
	public List<Professor> findAll(){
		List<Professor> list = this.professorRepository.findAll();
		return list;
	}
	
	public String update(Professor professor, long Id) {
		professor.setId(Id);
		this.professorRepository.save(professor);
		return "Professor atualizado com sucesso!!!";
	}
	
	 public List<Professor> buscarProfSemGmail1() {
		 List<Professor> lista = this.professorRepository.findByEmailNotContaining("@gmail.com");
	     return lista;
	    }
	 
	 public List<Professor> findByNomeStartingWithOrEspecialidadeStartingWith(String nome, String especialidade) {
	        return professorRepository.findByNomeStartingWithOrEspecialidadeStartingWith(nome, especialidade);
	    }

	 public List<Professor> findByEmailNotContaining() {
	        return professorRepository.findByEmailNotContaining("@gmail.com");
	    }
	 
	 
}
