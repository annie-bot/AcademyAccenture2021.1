package exceptions;

public class LimiteAtingidoException extends Exception {

	public LimiteAtingidoException() {
		super("Não é possível inserir pessoa. Limite atingido!");
	}
	
}
