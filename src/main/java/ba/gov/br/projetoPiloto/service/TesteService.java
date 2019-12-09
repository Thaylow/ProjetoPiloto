package ba.gov.br.projetoPiloto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ba.gov.br.projetoPiloto.exception.MensagemException;
import ba.gov.br.projetoPiloto.model.Teste;
import ba.gov.br.projetoPiloto.repository.TesteRepository;

@Service
public class TesteService {

	@Autowired
	private TesteRepository repository;
	
	public Teste findOneById(Long id) {
		
		Teste teste = this.repository.findOneById(id);
		
		if (teste == null) {
			throw new MensagemException("Teste não encontrado.");
		}

		return teste;
	}
	

	public List<Teste> listar() {
		
		List<Teste> listaTeste = this.repository.findAll();
		return listaTeste;
	}


    public Teste salvar(Teste teste) {
	    	
    		this.repository.save(teste);
	    	
			return teste;
    }
    
    public void excluir(Long id) {
    	
    	this.repository.deleteById(id);
    	
    }    

}