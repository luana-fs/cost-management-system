import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Menu {

    public static Funcionario selecionarFuncionario(Cadastro cadastro) {
        Scanner scanner = new Scanner(System.in);
        int indiceFuncionarioSelecionado;

        System.out.println("Funcionários Disponíveis:");
        cadastro.imprimeFuncionarios();

        do {
            System.out.print("Digite o índice do Funcionário para fazer login (0 a "
                    + (cadastro.getNumeroFuncionarios() - 1) + "): ");
            indiceFuncionarioSelecionado = scanner.nextInt();
            scanner.nextLine();
        } while (indiceFuncionarioSelecionado < 0 || indiceFuncionarioSelecionado >= cadastro.getNumeroFuncionarios());

        return cadastro.getFuncionario(indiceFuncionarioSelecionado);
    }

    public static void exibirMenu() {
        System.out.println ("\n");
        System.out.println("=====================================");
        System.out.println("Menu de Opções: ");
        System.out.println("[1] Registrar Novo Custo");
        System.out.println("[2] Mostrar Estatísticas");
        System.out.println("[3] Pesquisar Custo");
        System.out.println("[4] Visualizar Dados Pessoais");
        System.out.println("[5] Visualizar Custos do Mês");
        System.out.println("[6] Visualizar Custos dos Últimos 3 Meses");
        System.out.println("[7] Top 3 Funcionários com Maiores Registros");
        System.out.println("[0] Sair do Sistema");
        System.out.println("=====================================");
        System.out.print("Digite uma opção: ");
    }

    public static void menuPesquisa() {
        System.out.println ("\n");
        System.out.println("=====================================");
        System.out.println("Menu de Pesquisa: ");
        System.out.println("[1] Pesquisar por Descrição");
        System.out.println("[2] Pesquisar por Categoria");
        System.out.println("[3] Pesquisar por Data");
        System.out.println("[4] Pesquisar por Departamento");
        System.out.println("[0] Voltar ao menu principal");
        System.out.println("=====================================");
    }


}