package exceptions;

public class CPFInvalidoException extends Exception {

    public CPFInvalidoException() {
        super("CPF inválido: O CPF precisa conter 11 números");
    }
    
}
