package dados;

import java.util.ArrayList;
import java.util.List;

import exceptions.CPFInexistenteException;
import exceptions.CPFInvalidoException;
import negocio.Aluno;
import negocio.Pessoa;
import negocio.Professor;
import negocio.RepositorioPessoas;

public class RepositorioPessoasLista implements RepositorioPessoas {
	
	private List<Pessoa> pessoas; 
	
    public RepositorioPessoasLista() {
        this.pessoas = new ArrayList<Pessoa>();
    }

    @Override
	public void inserir(Pessoa pessoa) {
		pessoas.add(pessoa);
	}
	
    @Override
	public Pessoa procurar(String cpf) throws CPFInexistenteException, CPFInvalidoException {
		String cpfCorrigido = corrigirCpf(cpf);

		for (Pessoa pessoa : pessoas) {
			if (pessoa.getCpf().equals(cpfCorrigido)) {
				return pessoa;
			}
		}
		
        throw new CPFInexistenteException();
	}
	
    @Override
	public void remover(String cpf) throws CPFInexistenteException, CPFInvalidoException {
		Pessoa p = procurar(cpf);
		pessoas.remove(p);
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

        out += "\n---------------- Lista de Pessoas ----------------\n ";
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
