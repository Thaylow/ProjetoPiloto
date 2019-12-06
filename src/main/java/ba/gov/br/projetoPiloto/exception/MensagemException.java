package ba.gov.br.projetoPiloto.exception;

public class MensagemException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MensagemException(String mensagem) {
		super(mensagem);
	}
	
	public MensagemException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}	

}

