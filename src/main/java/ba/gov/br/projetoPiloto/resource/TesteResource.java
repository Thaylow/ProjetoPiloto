package ba.gov.br.projetoPiloto.resource;


import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ba.gov.br.projetoPiloto.model.Teste;
import ba.gov.br.projetoPiloto.service.TesteService;

@RestController
@RequestMapping("/teste")
public class TesteResource {

	@Autowired
	TesteService service;

	@CrossOrigin
	@GetMapping(value = "/{id}",  produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Teste> obter(@PathVariable("id") Long id) {

		Teste teste = this.service.findOneById(id);

		return ResponseEntity.status(HttpStatus.OK).body(teste);
	}
	

	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Teste>> listarTodosTeste() {
		
		//  GET
		//http://localhost:8080/ProjetoPiloto-0.0.1-SNAPSHOT/teste/

		List<Teste> listaTeste = this.service.listar();

		CacheControl cacheControl = CacheControl.maxAge(1, TimeUnit.MINUTES);

		return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(listaTeste);

	}

	
	@RequestMapping(value="/salvar", method=RequestMethod.POST)
	public ResponseEntity<List<Teste>> salvar(){

		//  POST
		//http://localhost:8080/ProjetoPiloto-0.0.1-SNAPSHOT/teste/salvar
		
		Teste teste = new Teste();
		teste.setDescricao("Testando Método POST");
		
		teste = service.salvar(teste);
		
		List<Teste> listaTestes = this.service.listar();
		
		return ResponseEntity.ok(listaTestes);
		
	}
	
	@DeleteMapping(value = "delete/{id}")
	@Transactional
    public ResponseEntity<List<Teste>>  delete(@PathVariable("id") Long id)  {
		
		service.excluir(id);
		
		List<Teste> listaTestes = this.service.listar();
		
		return ResponseEntity.ok(listaTestes);
    }
	
}
