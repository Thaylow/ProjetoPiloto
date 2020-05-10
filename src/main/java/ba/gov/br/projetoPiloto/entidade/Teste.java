package ba.gov.br.projetoPiloto.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "TABLE_TESTE")
@SequenceGenerator(name = "TABLE_TESTE_SEQ", sequenceName = "TABLE_TESTE_SEQ", allocationSize = 1)
public class Teste {
	
	@Id
	@Column(name="TABLE_TESTE_ID")
	@JsonInclude(value=Include.NON_NULL)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TABLE_TESTE_SEQ")
	private Long id;
	
	@Column(name="TABLE_TESTE_DESCRICAO")
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
