package app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.Entity.Aluno;
import app.Repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public String save(Aluno aluno) {
		this.alunoRepository.save(aluno);
		return "Aluno salvo com sucesso!";
	}
	
	public String delete(long Id) {
		this.alunoRepository.deleteById(Id);
		return "Aluno deletado com sucesso!";
	}
	
	public Aluno findById(long Id) {
		Aluno aluno = this.alunoRepository.findById(Id).get();
		return aluno;
	}
	
	public String update(long id, Aluno aluno) {
		aluno.setId(id);
		this.alunoRepository.save(aluno);
		return "Aluno atualizado com sucesso!!!";
	}
	
	public List<Aluno> findAll(){
		List<Aluno> list = this.alunoRepository.findAll();
		
		return list;
	}

	
	
}
