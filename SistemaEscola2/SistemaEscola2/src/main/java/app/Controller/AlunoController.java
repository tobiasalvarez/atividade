package app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.Entity.Aluno;
import app.Service.AlunoService;

@RestController
@RequestMapping("/api/aluno")
@CrossOrigin("*")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Aluno aluno){
		try {
			
			String mensagem = this.alunoService.save(aluno);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
			
		} catch (Exception e) {
			String erro = e.getMessage();
			System.out.println(erro);
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			
		}
	}
		
		
	  @DeleteMapping("/delete/{id}")
	  public ResponseEntity<String> delete(@PathVariable long id){
		  try {
			  
			  String mensagem = this.alunoService.delete(id);
			  return new ResponseEntity<>(mensagem, HttpStatus.OK);
			  
			  
		} catch (Exception e) {
		
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
				
		}
	  }
		  
		  @GetMapping("/finById/{id}")
		  public ResponseEntity<Aluno> findById(@PathVariable long id){
			  try {
				
				  Aluno aluno = this.alunoService.findById(id);
				  return new ResponseEntity<>(aluno, HttpStatus.OK);
				  
			} catch (Exception e) {
		
					return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
		  }
		
		@PutMapping("/update/{id}")
		public ResponseEntity<String> update(@PathVariable long id, @RequestBody Aluno aluno){
			try {
				
				String mensagem = this.alunoService.update(id, aluno);
				return new ResponseEntity<>(mensagem, HttpStatus.OK);
				
			} catch (Exception e) {
				
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
				
			}
		}
		
		@GetMapping("/findAll")
		public ResponseEntity<List<Aluno>> findAll(){
			try {
				List<Aluno> lista = this.alunoService.findAll();
				return new ResponseEntity<>(lista, HttpStatus.OK);
			} catch (Exception e) {
			
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
		}
		
		@GetMapping("/findByNomeStartingWithIgnoreCase")
		public ResponseEntity<List<Aluno>> findByNomeStartingWithIgnoreCase(String nome){
			try {
				List<Aluno> lista = this.alunoService.findByNomeStartingWithIgnoreCase(nome);
				return new ResponseEntity<>(lista, HttpStatus.OK);
			} catch (Exception e) {
			
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
		}
		
		 @GetMapping("/buscarAlunosPorTurma")
		    public ResponseEntity<List<Aluno>> buscarAlunosPorTurma(@RequestParam String nomeTurma) {
		       try {
				
		    	   List<Aluno> alunos = alunoService.findByTurmaNome(nomeTurma);
		    	   return new ResponseEntity<>(alunos, HttpStatus.OK);
		    	   
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
	}
		 
		 @GetMapping("/findByTelefoneContains")
		 public ResponseEntity<List<Aluno>> findByTelefoneContains(@RequestParam String telefone) {
		       try {
				List<Aluno> alunos = alunoService.findByTelefoneContains(telefone);
				return new ResponseEntity<>(alunos, HttpStatus.OK);
				
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		
			}
}
}
