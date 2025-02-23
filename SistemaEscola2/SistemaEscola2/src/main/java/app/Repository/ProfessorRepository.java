package app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.Entity.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    
//procura pelo email exato    
	
	public Professor findByEmail (String email);
		
	// Metodo  para buscar professor que não contenha @gmail.com
	//O parametro emailDomain será o valor que você quer que não apareça no email
	public List<Professor> findByEmailNotContaining(String emailDomain);
	
    public List<Professor> findByNomeStartingWithOrEspecialidadeStartingWith (String nome, String especialidade);

    
    
}