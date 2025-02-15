package app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.Entity.Turma;
import app.Repository.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository turmaRepository;
	

	public String save(Turma turma) {
		this.turmaRepository.save(turma);
		return "Professor salvo com sucesso!!";	
	}
	
	public String delete(long Id) {
		this.turmaRepository.deleteById(Id);
		return "Professor deletado com sucesso!!";
	}
	
	public Turma findById(long Id) {
		Turma turma = this.turmaRepository.findById(Id).get();
		return turma;
	}
	
	public List<Turma> findAll(){
		List<Turma> list = this.turmaRepository.findAll();
		return list;
	}
	
	public String update(Turma turma, long Id) {
		turma.setId(Id);
		this.turmaRepository.save(turma);
		return "Professor atualizado com sucesso!!!";
	}
	
}
