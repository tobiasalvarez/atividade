package app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.Entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}