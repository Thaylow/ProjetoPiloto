package ba.gov.br.projetoPiloto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ba.gov.br.projetoPiloto.entidade.Teste;

@Service
public interface TesteService {

	public Teste findOneById(Long id);
		
	public List<Teste> listar();


    public Teste salvar(Teste teste);
    
    public void excluir(Long id) ;

}