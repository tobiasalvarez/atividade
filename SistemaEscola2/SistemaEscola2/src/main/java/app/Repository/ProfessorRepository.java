package app.Repository;

import java.util.Optional;

import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.Entity.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

 // procura pelo começo do nome ou 
    List findByNomeStartingWithOrEspecialidadeStartingWith(String nome, String especialidade);
    
 // procura por email que NAO TENHA @gmail    
    @Query("SELECT p FROM Professor p WHERE p.email NOT LIKE %@gmail.com")
    List findProfessoresSemEmailGmail();
    
//procura pelo email exato    
    Optional<Professor> findByEmail(String email);
}
