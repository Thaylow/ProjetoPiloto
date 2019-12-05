package ba.gov.br.projetoPiloto.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ba.gov.br.projetoPiloto.model.Teste;

public interface TesteRepository extends JpaRepository<Teste, Long>{
	
	public Teste findOneById(Long Id);
	
	@Query(value=" SELECT * FROM PR_CAIXAENTRADA WHERE CXEN_DEST_CEIN_ID = :cein AND CXEN_DEST_USUA_ID IS NULL AND CXEN_DEST_DATAHORA IS NULL ", nativeQuery = true)
	public List<Teste> obterDisponiveisPorSetor(@Param("cein") String cein);

	@Query(value=" SELECT * FROM PR_CAIXAENTRADA WHERE CXEN_DEST_CEIN_ID = :cein AND CXEN_DEST_USUA_ID IS NULL AND CXEN_DEST_DATAHORA IS NOT NULL ", nativeQuery = true)
	public List<Teste> obterRecebidosPorSetor(@Param("cein") String cein);
	
	@Query(value=" SELECT * FROM PR_CAIXAENTRADA WHERE CXEN_DEST_CEIN_ID = :cein AND CXEN_DEST_USUA_ID = :usuario AND CXEN_DEST_DATAHORA IS NULL ", nativeQuery = true)
	public List<Teste> obterDisponiveisPessoal(@Param("cein") String cein , @Param("usuario") String usuario);

	@Query(value=" SELECT * FROM PR_CAIXAENTRADA WHERE CXEN_DEST_CEIN_ID = :cein AND CXEN_DEST_USUA_ID = :usuario AND CXEN_DEST_DATAHORA IS NOT NULL ", nativeQuery = true)
	public List<Teste> obterRecebidosPessoal(@Param("cein") String cein , @Param("usuario") String usuario);	
}
