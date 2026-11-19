package padroesestruturais.flyweight;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private final FabricaSetores fabrica = new FabricaSetores();
    private final List<Funcionario> funcionarios = new ArrayList<>();

    public Funcionario contratarFuncionario(String nome, int matricula, String nomeSetor, String descricaoSetor) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do funcionário inválido");
        }
        if (matricula <= 0) {
            throw new IllegalArgumentException("Matrícula inválida");
        }
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getMatricula() == matricula) {
                throw new IllegalArgumentException("Matrícula já cadastrada");
            }
        }
        Setor setor = fabrica.obterSetor(nomeSetor, descricaoSetor);
        Funcionario funcionario = new Funcionario(nome, matricula, setor);
        funcionarios.add(funcionario);
        return funcionario;
    }

    public int quantidadeFuncionarios() {
        return funcionarios.size();
    }

    public int quantidadeSetores() {
        return fabrica.quantidadeSetores();
    }
}
