package padroesestruturais.flyweight;

public class Funcionario {

    private final String nome;
    private final int matricula;
    private final Setor setor;

    public Funcionario(String nome, int matricula, Setor setor) {
        this.nome = nome;
        this.matricula = matricula;
        this.setor = setor;
    }

    public String getNome() {
        return nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public Setor getSetor() {
        return setor;
    }

    public String apresentar() {
        return nome + " (" + matricula + ") - " + setor.getNome() + ": " + setor.getDescricao();
    }
}
