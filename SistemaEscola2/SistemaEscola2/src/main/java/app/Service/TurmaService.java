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
		return "Turma salva com sucesso!!";	
	}
	
	public String delete(long Id) {
		this.turmaRepository.deleteById(Id);
		return "Turma deletada com sucesso!!";
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
		return "Turma atualizado com sucesso!!!";
	}
	
	public List<Turma> findByAnoBetween (int ano1, int ano2){
		List<Turma> lista = this.turmaRepository.findByAnoBetween(ano1, ano2);
		return lista;
	}
	
	public List<Turma> findBySemestreAndAno(String semestre, int ano){
		List<Turma> lista = this.turmaRepository.findBySemestreAndAno(semestre, ano);
		return lista;
	}
	
	public List<Turma> findByNomeAndTurno(String nome, String turno){
		List<Turma> turma = this.turmaRepository.findByNomeAndTurno(nome, turno);
		return turma;
	}
	
	public List<Turma> findByCursoNome(String nome){
		List<Turma> turma = this.turmaRepository.findByCursoNome(nome);
		return turma;
	}
	
}
