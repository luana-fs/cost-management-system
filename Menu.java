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
        System.out.println("=====================================");
        System.out.println("Menu de opcoes: ");
        System.out.println("[1] Registrar novo custo");
        System.out.println("[2] Pesquisar custo");
        System.out.println("[3] Visualizar dados pessoais");
        System.out.println("[4] Visualizar custos do mês");
        System.out.println("[5] Vizualizar custos dos últimos 3 meses");
        System.out.println("[6] Top 3 funcionários com maiores registros");
        System.out.println("[7] Dia com o maior custo");
        System.out.println("[8] Percentual de custo por departamento");
        System.out.println("[0] Sair do sistema");
        System.out.println("=====================================");
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