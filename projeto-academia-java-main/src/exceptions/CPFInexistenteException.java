package exceptions;

public class CPFInexistenteException extends Exception {
	
	public CPFInexistenteException() {
		super("Pessoa não cadastrada.");
	}
}
