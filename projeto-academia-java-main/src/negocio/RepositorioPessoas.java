package negocio;

import exceptions.CPFInexistenteException;
import exceptions.CPFInvalidoException;
import exceptions.LimiteAtingidoException;

public interface RepositorioPessoas {

	void inserir(Pessoa pessoa) throws LimiteAtingidoException;
	Pessoa procurar(String numCPF) throws CPFInexistenteException, CPFInvalidoException;
	void remover(String numCPF) throws CPFInexistenteException, CPFInvalidoException;
	
}