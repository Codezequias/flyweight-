package padroesestruturais.flyweight;

public class CasosDeTeste {

    private static int testes = 0;

    private static void verificar(boolean condicao, String descricao) {
        if (!condicao) {
            throw new AssertionError("FALHOU: " + descricao);
        }
        testes++;
        System.out.println("PASSOU: " + descricao);
    }

    private static void verificarErro(Runnable acao, String descricao) {
        try {
            acao.run();
            throw new AssertionError("FALHOU: " + descricao);
        } catch (IllegalArgumentException erro) {
            testes++;
            System.out.println("PASSOU: " + descricao);
        }
    }

    public static void main(String[] args) {
        Empresa empresa = new Empresa();

        Funcionario ana = empresa.contratarFuncionario("Ana", 101, "Financeiro", "Controle de pagamentos");
        verificar(ana.getNome().equals("Ana") && ana.getMatricula() == 101, "Cadastro de funcionário");

        Funcionario bruno = empresa.contratarFuncionario("Bruno", 102, "Financeiro", "Controle de pagamentos");
        verificar(ana.getSetor() == bruno.getSetor(), "Compartilhamento do mesmo setor");

        Funcionario carla = empresa.contratarFuncionario("Carla", 103, "Tecnologia", "Suporte aos sistemas");
        verificar(ana.getSetor() != carla.getSetor(), "Setores diferentes usam objetos diferentes");

        verificar(empresa.quantidadeFuncionarios() == 3 && empresa.quantidadeSetores() == 2, "Quantidade de funcionários e setores");

        verificar(bruno.apresentar().contains("Financeiro"), "Exibição dos dados do funcionário");

        verificarErro(() -> empresa.contratarFuncionario("", 104, "RH", "Gestão de pessoas"), "Nome inválido");

        verificarErro(() -> empresa.contratarFuncionario("Daniel", -1, "RH", "Gestão de pessoas"), "Matrícula inválida");

        verificarErro(() -> empresa.contratarFuncionario("Daniel", 101, "RH", "Gestão de pessoas"), "Matrícula duplicada");

        verificarErro(() -> empresa.contratarFuncionario("Daniel", 104, "Financeiro", "Outra descrição"), "Setor com descrição diferente");

        verificar(empresa.quantidadeFuncionarios() == 3 && empresa.quantidadeSetores() == 2, "Cadastros inválidos não alteram a empresa");

        System.out.println("Total: " + testes + " testes passaram.");
    }
}
