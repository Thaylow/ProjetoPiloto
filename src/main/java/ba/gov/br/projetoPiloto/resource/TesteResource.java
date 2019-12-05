package ba.gov.br.projetoPiloto.resource;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

		List<Teste> listaTeste = this.service.listarTodosTeste();

		CacheControl cacheControl = CacheControl.maxAge(1, TimeUnit.MINUTES);

		return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(listaTeste);

	}
	
}
