package app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.Entity.Curso;
import app.Repository.CursoRepository;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	
	public String save(Curso curso) {
		this.cursoRepository.save(curso);
		return "Curso salvo com sucesso!";
	}
	
	public String delete(long id) {
		this.cursoRepository.deleteById(id);
		return "Curso deletado com sucesso!";
	}
	
	public Curso findById(long id) {
		
		Curso curso = this.cursoRepository.findById(id).get();
		
		return curso;
	}
	
	public String update(long id, Curso curso) {
		curso.setId(id);
		this.cursoRepository.save(curso);
		return "Curso foi atualizado com sucesso!";
	}
	
	public List<Curso> findALL(){
		List<Curso> list = this.cursoRepository.findAll();
		return list;
	}

	
	
	
}
