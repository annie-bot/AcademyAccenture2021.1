package negocio;

public class Pessoa {

    private String nome;
    private String cpf;
    private int idade;

    public Pessoa() {
        super();
        this.nome = null;
        this.cpf = null;
        this.idade = 0;
    }

    public Pessoa(String nome, String cpf, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        String out = "";
        out += "Nome do aluno: " + nome + "\n";
        out += "CPF: " + cpf + "\n";
        out += "Idade: " + idade + "\n"; 
        return out;
    }


}
