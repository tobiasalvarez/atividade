package app.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.Entity.Professor;
import app.Repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository professorRepository;
	

	public String save(Professor professor) {
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
	/*
	public List<Professor> buscarProfessoresPorNomeOuEspecialidade(String nome, String especialidade) {
        return (List<Professor>) professorRepository.findByNomeStartingWithOrEspecialidadeStartingWith(nome, especialidade);
    }

	 public Optional<Professor> buscarProfessorPorEmail(String email) {
	        return professorRepository.findByEmail(email);
	    }*/
}
