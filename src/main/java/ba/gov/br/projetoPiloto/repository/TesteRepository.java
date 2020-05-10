package ba.gov.br.projetoPiloto.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import ba.gov.br.projetoPiloto.entidade.Teste;

public interface TesteRepository extends JpaRepository<Teste, Long>{
	
	public Teste findOneById(Long Id);

	public void deleteById(Long id);
	
}
