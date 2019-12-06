package ba.gov.br.projetoPiloto.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import ba.gov.br.projetoPiloto.model.Teste;

public interface TesteRepository extends JpaRepository<Teste, Long>{
	
	public Teste findOneById(Long Id);
	
}
