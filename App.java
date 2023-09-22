import java.util.Scanner;
import java.util.Locale;

public class App {

	private static Funcionario funcionarioLogado;
	private Scanner entrada;

    public App() {
        entrada = new Scanner(System.in);
        entrada.useLocale(Locale.ENGLISH);
        enxame = new Enxame();
    }

    public void executar() {
        int opcao = 0;
        do {
            menu();
            System.out.print("Insira a opção desejada:");
            opcao = entrada.nextInt();
            entrada.nextLine();
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    AcessarComoFuncionario();
                    break;
                case 2:
                    CadastrarNovoFuncionario();
                    break;
                default:
                    System.out.println("Selecione uma opção valida!");
            }
        } while (opcao !=0);
    }
    private void menu() {
        System.out.println("=====================================");
        System.out.println("Menu de opcoes: ");
        System.out.println("[0] Sair do sistema");
        System.out.println("[1] Acessar");
        System.out.println("[2] Cadastrar novo funcionario");
        System.out.println("=====================================");
    }

}
