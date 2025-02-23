package app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.Entity.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
	
	//buscar entre ano x e y
	public List<Turma> findByAnoBetween(int ano1, int ano2);
	
	//buscar por semestre e ano 
	public List<Turma> findBySemestreAndAno(String semestre, int ano);
	
	//buscar por nome e turno
	public List<Turma> findByNomeAndTurno(String nome, String turno);
	
	//buscar pelo nome do curso
	public List<Turma> findByCursoNome(String nome);
}
