package app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.Entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}