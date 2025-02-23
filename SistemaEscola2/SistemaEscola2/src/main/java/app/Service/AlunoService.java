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
		Aluno alun = this.alunoRepository.findByCpf(aluno.getCpf());
		if(alun != null) {
			throw new RuntimeException("CPF ja cadastrado " + aluno.getCpf());
		}
		else if(aluno.getTelefone() == null) {
			aluno.setCadastroCompleto(false);
		}else {
			aluno.setCadastroCompleto(true);
		}
		
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
	
	public List<Aluno> findByNomeStartingWithIgnoreCase(String nome){
		List<Aluno> aluno = this.alunoRepository.findByNomeStartingWithIgnoreCase(nome);
		return aluno;
	}
	
	public List<Aluno> findByTurmaNome(String nomeTurma) {
        return alunoRepository.findByTurmaNome(nomeTurma);
    }
	
	 public List<Aluno> findByTelefoneContains(String telefone) {
	        return alunoRepository.findByTelefoneContains(telefone);
	    }
	
}
