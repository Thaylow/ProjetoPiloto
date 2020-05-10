package ba.gov.br.projetoPiloto.controller;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ba.gov.br.projetoPiloto.entidade.Teste;
import ba.gov.br.projetoPiloto.exception.MensagemException;
import ba.gov.br.projetoPiloto.service.TesteService;

@RestController
@RequestMapping("/teste")
public class TesteController {

	@Autowired
	TesteService service;

	@CrossOrigin
	@GetMapping(value = "/{id}",  produces = { MediaType.APPLICATION_JSON_VALUE })
	public Teste obter(@PathVariable("id") Long id) {
		
		Teste teste =this.service.findOneById(id);
		
		if (teste == null) {
			throw new MensagemException("Teste não encontrado.");
		}

		return teste;
	}
	

	@CrossOrigin
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Teste> listarTodosTeste() {

		return this.service.listar();

	}

	
	@GetMapping(value="/salvar", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Teste> salvar(){

		Teste teste = new Teste();
		teste.setDescricao("Testando Método POST");
		
		teste = service.salvar(teste);
		
		return this.service.listar();
		
	}
	
	
	@GetMapping(value="/editar/{id}" ,produces = { MediaType.APPLICATION_JSON_VALUE })
	public Teste editar(@PathVariable("id") Long id) {

		Teste teste = new Teste();
		teste = this.service.findOneById(id);
		
		if(teste != null) {
			teste.setDescricao("Alterando a descrição da categoria " + id);
			service.salvar(teste);
			teste = this.service.findOneById(id);
		} else {
			throw new MensagemException("Teste não encontrado.");
		}
		
		return teste;

	}
	
	@GetMapping(value = "delete/{id}",produces = { MediaType.APPLICATION_JSON_VALUE })
	@Transactional
    public List<Teste>  delete(@PathVariable("id") Long id)  {
		
		service.excluir(id);
		
		
		return this.service.listar();
    }
	
}
