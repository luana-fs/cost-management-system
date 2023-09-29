import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class App {

    private static Funcionario funcionarioLogado;
    private static Departamento[] departamentos = new Departamento[6];
    private static RegistroDeCusto registroDeCusto;

    public static void main(String[] args) {

        Cadastro cadastro = new Cadastro();
        RegistroDeCusto r1 = new RegistroDeCusto(100.0, "Material de Escritório", "2023-02-04", "Suprimentos",
                "Engenharia");
        RegistroDeCusto r2 = new RegistroDeCusto(200.0, "Manutenção de Equipamento", "2022-09-20", "Manutenção",
                "Engenharia");
        RegistroDeCusto r3 = new RegistroDeCusto(500.0, "Manutenção de Equipamento", "2023-08-27", "Manutenção",
                "Engenharia");

        registroDeCusto.adicionarRegistroDeCusto(r1);
        registroDeCusto.adicionarRegistroDeCusto(r2);
        registroDeCusto.adicionarRegistroDeCusto(r3);

        // Preenche Funcionários
        cadastro.cadastraFuncionario(new Funcionario(1, "Joao", "RH"));
        cadastro.cadastraFuncionario(new Funcionario(2, "Lucca", "Compras"));
        cadastro.cadastraFuncionario(new Funcionario(3, "Alberto", "Vendas"));

        // Funcionários disponíveis
        System.out.println("Funcionários Disponíveis:");
        cadastro.imprimeFuncionarios();

        // Escolha de Usuario
        Scanner scanner = new Scanner(System.in);
        int indiceFuncionarioSelecionado;

        do {
            System.out.print("Digite o índice do Funcionário para fazer login (0 a "
                    + (cadastro.getNumeroFuncionarios() - 1) + "): ");
            indiceFuncionarioSelecionado = scanner.nextInt();
            scanner.nextLine(); // Consumir o caractere de nova linha
        } while (indiceFuncionarioSelecionado < 0 || indiceFuncionarioSelecionado >= cadastro.getNumeroFuncionarios());

        funcionarioLogado = cadastro.getFuncionario(indiceFuncionarioSelecionado);
        System.out.println("Logado como: " + funcionarioLogado.getNome());

        // Menu
        Menu.exibirMenu();
        int opcao;
        do {
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    // Lógica para Registrar Novo Custo
                    break;
                case 2:
                    // Lógica para Mostrar Estatísticas
                    break;
                case 3:
                    Menu.menuPesquisa();

                    break;
                // Adicione mais casos para as outras opções do menu
                case 0:
                    System.out.println("Saindo do Sistema.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    Menu.exibirMenu();
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }

    public static void populaDep() {

        Departamento rh = new Departamento("RH");
        Departamento compras = new Departamento("Compras");
        Departamento vendas = new Departamento("Vendas");
        Departamento expedicao = new Departamento("Expedição");
        Departamento engenharia = new Departamento("Engenharia");
        Departamento producao = new Departamento("Produção");
    }

    // Populando o array
    public static boolean insereDep(Departamento[] dep, Departamento d) {
        for (int i = 0; i < dep.length; i++) {
            if (dep[i] == null) {
                dep[i] = d;
                return true;
            }
        }
        return false;
    }

    public static void imprimeDep(Departamento[] dep) {
        int contador = 1;
        for (int i = 0; i < dep.length; i++) {
            System.out.println(contador + ": " + dep[i]);
            contador++;
        }
    }

    private static void executarPesquisa(String opcao) {
        Scanner entrada = new Scanner(System.in);
        entrada.useLocale(Locale.ENGLISH);

        switch (opcao) {
            case "0":
                break;
            case "1":
                System.out.print("Digite a descrição que deseja pesquisar: ");
                String descricao = entrada.nextLine();
                List<RegistroDeCusto> resultadoDescricao = registroDeCusto.pesquisaDescricao(descricao);
                if (resultadoDescricao != null) {
                    System.out.println("Resultado da pesquisa:\n" + resultadoDescricao.toString());
                } else {
                    System.out.println("Nenhum resultado encontrado.");
                }
                break;
            case "2":
                System.out.print("Digite a categoria que deseja pesquisar: ");
                String categoria = entrada.nextLine();
                List<RegistroDeCusto> resultadoCategoria = registroDeCusto.pesquisarCategoria(categoria);
                if (resultadoCategoria != null) {
                    System.out.println("Resultado da pesquisa:\n" + resultadoCategoria.toString());
                } else {
                    System.out.println("Nenhum resultado encontrado.");
                }
                break;
            case "3":
                System.out.print("Digite a data que deseja pesquisar: ");
                String data = entrada.nextLine();
                List<RegistroDeCusto> resultadoData = registroDeCusto.pesquisarData(data);
                if (resultadoData != null) {
                    System.out.println("Resultado da pesquisa:\n" + resultadoData.toString());
                } else {
                    System.out.println("Nenhum resultado encontrado.");
                }
                break;
            case "4":
                System.out.print("Digite o departamento o departamento: ");
                String departamento = entrada.nextLine();
                List<RegistroDeCusto> resultadoDepartamento = (List<RegistroDeCusto>) registroDeCusto.pesquisarDepartamento(departamento);
                if (resultadoDepartamento != null) {
                    System.out.println("Resultado da pesquisa:\n" + resultadoDepartamento.toString());
                } else {
                    System.out.println("Nenhum resultado encontrado.");
                }
                break;
            default:
                System.out.println("Selecione uma opção válida.");
        }
    }
}
