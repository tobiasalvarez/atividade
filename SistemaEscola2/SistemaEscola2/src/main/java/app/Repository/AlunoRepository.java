package app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.Entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    // Metodo para buscar pelo começo do nome 	-TESTAR!!!!!!!
	//O IgnoreCase torna a busca insensível a maiúsculas/minúsculas.
    public List<Aluno> findByNomeStartingWithIgnoreCase(String nome);
    
    
    // Metodo para buscar pelo tefeloe -TESTAR!!!!!!
    public List<Aluno> findByTelefoneContaining(String telefone);
    
    // Metodo para buscar ALUNO pelo nome da turma - TESTAR!!!!!!
    public List<Aluno> findByTurmaNome(String nomeTurma);
}
