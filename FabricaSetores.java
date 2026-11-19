package padroesestruturais.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FabricaSetores {

    private final Map<String, Setor> setores = new HashMap<>();

    public Setor obterSetor(String nome, String descricao) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do setor inválido");
        }
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição do setor inválida");
        }
        Setor setor = setores.get(nome);
        if (setor == null) {
            setor = new Setor(nome, descricao);
            setores.put(nome, setor);
        } else if (!setor.getDescricao().equals(descricao)) {
            throw new IllegalArgumentException("Setor já cadastrado com outra descrição");
        }
        return setor;
    }

    public int quantidadeSetores() {
        return setores.size();
    }
}
