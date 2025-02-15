package app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.Entity.Professor;
public interface ProfessorRepository extends JpaRepository<Professor, Long>{

}
