package app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import app.Entity.Turma;
import app.Service.TurmaService;


@RestController
@RequestMapping("/api/turma")
public class TurmaController {
	
	@Autowired
	private TurmaService turmaService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Turma turma){
	 try {
		 String message = this.turmaService.save(turma);
		 return new ResponseEntity<>(message, HttpStatus.CREATED);
	} catch (Exception e) {
		System.out.println(e.getMessage());
		return new ResponseEntity<>("Deu erro... Nao salvo!", HttpStatus.BAD_REQUEST);
		}	
	 
	}
	
	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<String> delete(@PathVariable long Id){
		 try {
				String message = this.turmaService.delete(Id);
				return new ResponseEntity<>(message, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>("Deu erro... Nao deletado!", HttpStatus.BAD_REQUEST);
			}
		
	}
	
	@GetMapping("/findById/{Id}")
	public ResponseEntity<Turma> findById(@PathVariable long Id){
		 try {
				Turma turma = this.turmaService.findById(Id);
				return new ResponseEntity<>(turma, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Turma>> findAll(){
		try {
			List<Turma> lista = this.turmaService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PutMapping("/update/{Id}")
	public ResponseEntity<String> update(@RequestBody Turma turma,@PathVariable long Id){
		try {
			String message = this.turmaService.update(turma, Id);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Deu erro... Nao salvo!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findByAnoBetween")
	public ResponseEntity<List<Turma>> findByAnoBetween(@RequestParam int ano1, @RequestParam int ano2){
		try {
			List<Turma> lista = this.turmaService.findByAnoBetween(ano1, ano2);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findBySemestreAndAno")
	public ResponseEntity<List<Turma>> findBySemestreAndAno(@RequestParam String semestre, @RequestParam int ano){
		try {
			List<Turma> lista = this.turmaService.findBySemestreAndAno(semestre, ano);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findByNomeAndTurno")
	public ResponseEntity<List<Turma>> findByNomeAndTurno(@RequestParam String nome, @RequestParam String turno){
		try {
			List<Turma> turma = this.turmaService.findByNomeAndTurno(nome, turno);
			return new ResponseEntity<>(turma, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findByCursoNome")
	public ResponseEntity<List<Turma>> findByCursoNome(@RequestParam String curso){
		try {
			List<Turma> turma = this.turmaService.findByCursoNome(curso);
			return new ResponseEntity<>(turma, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}
