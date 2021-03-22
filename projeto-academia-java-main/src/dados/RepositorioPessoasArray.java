package dados;

import exceptions.CPFInexistenteException;
import exceptions.CPFInvalidoException;
import exceptions.LimiteAtingidoException;
import negocio.Aluno;
import negocio.Pessoa;
import negocio.Professor;
import negocio.RepositorioPessoas;

public class RepositorioPessoasArray implements RepositorioPessoas {
	
	private Pessoa[] pessoas;
    private int indice;
	
	public RepositorioPessoasArray(int tamanho) {
        this.pessoas = new Pessoa[tamanho];
		this.indice = 0;
	}
	
	public void inserir(Pessoa pessoa) throws LimiteAtingidoException {
		if (indice == this.pessoas.length) {
            throw new LimiteAtingidoException();
        }

        this.pessoas[indice] = pessoa;
		indice++;
	}
	
	public Pessoa procurar(String cpf) throws CPFInexistenteException, CPFInvalidoException {
		String cpfCorrigido = corrigirCpf(cpf);
		
        for (int i = 0; i < indice; i++) {
			if (pessoas[i].getCpf().equals(cpfCorrigido)) {
				return pessoas[i];
			}
		}

		throw new CPFInexistenteException();
	}
	
	public void remover(String cpf) throws CPFInexistenteException, CPFInvalidoException {
		boolean pessoaEncontrada = false;
        String cpfCorrigido = corrigirCpf(cpf);
        
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null && pessoas[i].getCpf().equals(cpfCorrigido)) {
                pessoaEncontrada = true;
            	pessoas[i] = pessoas[indice - 1];
                pessoas[indice - 1] = null; 
                indice--;
            } 
        }
        if (!pessoaEncontrada) {
			throw new CPFInexistenteException();
		}
    }
	
	private String corrigirCpf(String cpf) throws CPFInvalidoException {
        String cpfCorrigido = cpf.replaceAll("[./-]", "");
        cpfCorrigido = cpfCorrigido.replaceAll("\\s+","");

        if (cpfCorrigido.length() != 11) {
            throw new CPFInvalidoException();
        }
        
        return cpfCorrigido;
    }
	
	@Override
    public String toString() {
        String out = "";

        out+="\n---------------- Lista de Pessoas ----------------\n ";
        
        for (Pessoa pessoa : pessoas) {
            if (pessoa != null) {
                out += "\n====================================\n";
                if (pessoa instanceof Aluno) {
                    Aluno al = (Aluno)pessoa;
                    out += al.toString();
                } else if (pessoa instanceof Professor) {
                    Professor pf = (Professor)pessoa;
                    out += pf.toString();
                }
                
                out += "====================================\n";
            }
        } 
        
        return out;
	}

}