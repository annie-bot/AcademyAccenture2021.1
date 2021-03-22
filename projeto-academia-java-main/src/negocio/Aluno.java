package negocio;

public class Aluno extends Pessoa {

    private Curso curso;

    public Aluno() {
        super();
        this.curso = null;
    }
    
    public Aluno(String nome, String cpf, int idade, Curso curso) {
        super(nome, cpf, idade);
        this.curso = curso;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        String out = "";
        out += super.toString();
        out += "Curso: " + curso.getNome() + "\n";
        out += "Código do curso: " + curso.getCodigo() + "\n"; 
        return out;
    }
}

