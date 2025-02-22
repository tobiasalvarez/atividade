package app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.Entity.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
/*
 // procura pelo começo do nome ou 
    public List findByNomeStartingWithOrEspecialidadeStartingWith(String nome, String especialidade);
    
 // procura por email que NAO TENHA @gmail    
    @Query("SELECT p FROM Professor p WHERE p.email NOT LIKE %@gmail.com")
    public List findProfessoresSemEmailGmail();
    
//procura pelo email exato    
    public Optional<Professor> findByEmail(String email);*/
	
	public Professor findByEmail (String email);
}
