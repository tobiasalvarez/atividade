package app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.Entity.Professor;
import app.Service.ProfessorService;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Professor professor){
	 try {
		 String message = this.professorService.save(professor);
		 return new ResponseEntity<>(message, HttpStatus.CREATED);
	} catch (Exception e) {
		String erro = e.getMessage();
		System.out.println(erro);
		return new ResponseEntity<>("Deu erro... Nao salvo!", HttpStatus.BAD_REQUEST);
		}	
	 
	}
	
	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<String> delete(@PathVariable long Id){
		 try {
				String message = this.professorService.delete(Id);
				return new ResponseEntity<>(message, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>("Deu erro... Nao deletado!", HttpStatus.BAD_REQUEST);
			}
		
	}
	
	@GetMapping("/findById/{Id}")
	public ResponseEntity<Professor> findById(@PathVariable long Id){
		 try {
				Professor professor = this.professorService.findById(Id);
				return new ResponseEntity<>(professor, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Professor>> findAll(){
		try {
			List<Professor> lista = this.professorService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PutMapping("/update/{Id}")
	public ResponseEntity<String> update(@RequestBody Professor professor,@PathVariable long Id){
		try {
			String message = this.professorService.update(professor, Id);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity<>("Deu erro... Nao salvo!", HttpStatus.BAD_REQUEST);
		}
}


	  @GetMapping("/findByEmailNotContaining")
	    public ResponseEntity<List<Professor>> findByEmailNotContaining() {
		 try {
			List<Professor> lista = this.professorService.findByEmailNotContaining();
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	
}
	  
	  @GetMapping("/findByNomeStartingWithOrEspecialidadeStartingWith")
	    public ResponseEntity<List<Professor>>findByNomeStartingWithOrEspecialidadeStartingWith(@RequestParam String nome, @RequestParam String especialidade) {
		  try {
			  List<Professor> prof = this.professorService.findByNomeStartingWithOrEspecialidadeStartingWith(nome, especialidade);
			  return new ResponseEntity<>(prof, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	    }

	  
	  
}