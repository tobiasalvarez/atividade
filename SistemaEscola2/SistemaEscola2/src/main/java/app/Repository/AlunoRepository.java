package app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.Entity.Aluno;


public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    // Metodo para buscar pelo começo do nome
	//O IgnoreCase torna a busca insensível a maiúsculas/minúsculas.
    public List<Aluno> findByNomeStartingWithIgnoreCase(String nome);

    // Metodo para buscar aluno por qualquer parte do telefone
    public List<Aluno> findByTelefoneContains(String telefone);

    // Metodo para buscar ALUNO pelo nome da turma 
    public List<Aluno> findByTurmaNome(String nomeTurma);
    
    //buscar pelo cpf
    public Aluno findByCpf(String cpf);

}
