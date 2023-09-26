import java.util.Scanner;
import java.util.Locale;

public class App {

    private static Funcionario funcionarioLogado;
   

    public static void main(String[] args) {

        Departamento[] departamentos = new Departamento[6];
        
     
        
        // Estanciando os departamentos
        Departamento rh = new Departamento("RH");
        Departamento compras = new Departamento("Compras");
        Departamento vendas = new Departamento("Vendas");
        Departamento expedicao = new Departamento("Expedição");
        Departamento engenharia = new Departamento("Engenharia");
        Departamento producao = new Departamento("Produção");

        // Populando o array
        departamentos[0] = rh;
        departamentos[1] = compras;
        departamentos[2] = vendas;
        departamentos[3] = expedicao;
        departamentos[4] = engenharia;
        departamentos[5] = producao;
        
        menu();
        executar();

    }

    private static void menu() {
        System.out.println("=====================================");
        System.out.println("Menu de opcoes: ");
        System.out.println("[0] Sair do sistema");
        System.out.println("[1] Acessar");
        System.out.println("[2] Cadastrar novo funcionario");
        System.out.println("=====================================");
    }

    public static void executar() {
        Scanner entrada = new Scanner(System.in);
        entrada.useLocale(Locale.ENGLISH);

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
                    // AcessarComoFuncionario();
                    break;
                case 2:
                    // CadastrarNovoFuncionario();
                    break;
                default:
                    System.out.println("Selecione uma opção valida!");
            }
        } while (opcao != 0);
    }
}
