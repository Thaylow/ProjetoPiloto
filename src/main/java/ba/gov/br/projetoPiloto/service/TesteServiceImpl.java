package ba.gov.br.projetoPiloto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ba.gov.br.projetoPiloto.entidade.Teste;
import ba.gov.br.projetoPiloto.repository.TesteRepository;

@Service
public class TesteServiceImpl implements TesteService {

	@Autowired
	private TesteRepository repository;
	
	public Teste findOneById(Long id) {
		
		Teste teste = this.repository.findOneById(id);
		
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