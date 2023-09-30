import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.*;

public class App {
    private static Funcionario funcionarioLogado;
    private static Departamento[] departamentos = new Departamento[6];
    private static RegistroDeCusto registroDeCusto = new RegistroDeCusto();
    private static Cadastro cadastro = new Cadastro();
    private static ListaDepartamentos listaDep = new ListaDepartamentos();

    public static void main(String[] args) {

        // Cadastro cadastro = new Cadastro();

        RegistroDeCusto r1 = new RegistroDeCusto(100.0, "Impressora", "2023-02-04", "Suprimentos",
                "Engenharia");
        RegistroDeCusto r2 = new RegistroDeCusto(200.0, "Computador", "2022-09-20", "Manutenção",
                "Engenharia");
        RegistroDeCusto r3 = new RegistroDeCusto(500.0, "Material de limpeza", "2023-08-27", "Manutenção",
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
       // Menu.exibirMenu();
        executar();
        int opcao;
        /*do {
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
        } while (opcao != 0);*/

        scanner.close();
    }

    public static void populaDep() {

        Departamento rh = new Departamento("RH");
        Departamento compras = new Departamento("Compras");
        Departamento vendas = new Departamento("Vendas");
        Departamento expedicao = new Departamento("Expedição");
        Departamento engenharia = new Departamento("Engenharia");
        Departamento producao = new Departamento("Produção");

        listaDep.add(rh);
        listaDep.add(compras);
        listaDep.add(vendas);
        listaDep.add(expedicao);
        listaDep.add(engenharia);
        listaDep.add(producao);
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
        listaDep.listarDepartamentos();
    }


    private static void cadastrarNovoFuncionario() {
      //  Cadastro cadastro = new Cadastro();
        Scanner entrada = new Scanner(System.in);
        System.out.println("=====================================");
        System.out.println("Cadastrar um funcionario");
        System.out.print("Digite seu numero de matricula: ");
        int matricula = entrada.nextInt();
        System.out.print("Informe seu nome: ");
        String nome = entrada.nextLine();
        System.out.print("Informe seu departamento: ");
        String departamento = entrada.nextLine();
        Funcionario f = new Funcionario(matricula, nome, departamento);
        if (cadastro.cadastraFuncionario(f))
            System.out.println("Funcionario cadastrado com sucesso.");
        else
            System.out.println("Erro: Funcionario não cadastrado.");
    }

    private static boolean startupMenu() {
        try (Scanner entrada = new Scanner(System.in)) {
            int opcao = 0;
            System.out.println("=====================================");
            System.out.print("Olá! Seja bem vindo ao sistema de controle de custos da empresa!");
            System.out.println("Selecione a forma de acesso:");
            while (opcao != 1 && opcao != 2) {
                System.out.println("[1] Funcionário");
                System.out.println("[2] Administrador");
                System.out.println("=====================================");
                opcao = entrada.nextInt();
                //entrada.nextLine();
                switch (opcao) {
                    case 1:
                        // AcessarComoFuncionario();
                        break;
                    case 2:
                        cadastrarNovoFuncionario();
                        break;
                    default:
                        System.out.println("Selecione uma opção valida!");
                }
            }
        }
        return true;
    }

    private static void menu() {
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

    public static void executar() {
        Menu.exibirMenu();

        Scanner entrada = new Scanner(System.in);
        int opcao = entrada.nextInt();
        do {
            menu();
            System.out.print("Digite uma opção válida:");
            entrada.nextLine();
            switch (opcao) {
                case 0:
                    opcao = 0;
                    break;
                case 1:
                    RegistrarNovoCusto();
                    menu();
                    opcao = entrada.nextInt();
                    //.nextLine();
                    break;
                case 2:
                    menuPesquisa();
                    menu();
                    opcao = entrada.nextInt();
                   // entrada.nextLine();
                    break;
                case 3:
                    // VerDadosFuncionarioLogado();
                    menuPesquisa();
                    menu();
                    opcao = entrada.nextInt();
                    entrada.nextLine();
                    break;
                case 4:
                    // VerCustosMes();
                    menu();
                    opcao = entrada.nextInt();
                    entrada.nextLine();
                    break;
                case 5:
                    // VerCustosTresMeses();
                    menu();
                    opcao = entrada.nextInt();
                    entrada.nextLine();
                    break;
                case 6:
                    // RankingFuncionarios();
                    menu();
                    opcao = entrada.nextInt();
                    entrada.nextLine();
                    break;
                case 7:
                    // diaComMaisCustos();
                    menu();
                    opcao = entrada.nextInt();
                    entrada.nextLine();
                    break;
                case 8:
                    registroDeCusto.percentualCustoPorDep();
                   // menu();
                   // opcao = entrada.nextInt();
                   // entrada.nextLine();
                    break;

                default:
                    System.out.println("Selecione uma opção válida, por favor!");
            }
        } while (opcao != 0);
    }

    private static void menuPesquisa() {
        Scanner entrada = new Scanner(System.in);
        String opcao="0";
        System.out.println("=====================================");
        System.out.println("Menu de Pesquisa: ");
        System.out.println("[1] Pesquisar por Descrição");
        System.out.println("[2] Pesquisar por Categoria");
        System.out.println("[3] Pesquisar por Data");
        System.out.println("[4] Pesquisar por Departamento");
        System.out.println("[0] Voltar ao menu principal");
        System.out.println("=====================================");
        opcao = entrada.nextLine();
        executarPesquisa(opcao);
    }
    private static void executarPesquisa(String opcao) {
        Scanner entrada = new Scanner(System.in);
        entrada.useLocale(Locale.ENGLISH);
        List<RegistroDeCusto> resultadoDescricao = null;
        List<RegistroDeCusto> resultadoCategoria=null;
        switch (opcao) {
            case "0":
                break;
            case "1":
                System.out.print("Digite a descrição que deseja pesquisar: ");
                String descricao = entrada.nextLine();
                resultadoDescricao = registroDeCusto.pesquisaDescricao(descricao);
                if (resultadoDescricao != null) {
                    System.out.println("Resultado da pesquisa:\n" + resultadoDescricao.toString());
                } else {
                    System.out.println("Nenhum resultado encontrado.");
                }
                break;
            case "2":
                System.out.print("Digite a categoria que deseja pesquisar: ");
                String categoria = entrada.nextLine();
                 resultadoCategoria = registroDeCusto.pesquisarCategoria(categoria);
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
    public static String diaComMaisCustos(RegistroDeCusto[] registros) {
        Map<String, Integer> contagemPorDia = new HashMap<>();

        for (RegistroDeCusto registro : registros) {
            String data = registro.getData();
            if (contagemPorDia.containsKey(data)) {
                contagemPorDia.put(data, contagemPorDia.get(data)+1);
            } else {
                contagemPorDia.put(data,1);
            }
        }

        String diaComMaisCustos = null;
        int maxCustos = 0;

        for (Map.Entry<String, Integer> entry : contagemPorDia.entrySet()) {
            if (entry.getValue() > maxCustos) {
                maxCustos = entry.getValue();
                diaComMaisCustos = entry.getKey();
            }
        }

        return diaComMaisCustos;
    }
    public int encontrarMesComMaiorCusto(double[] registroDeCusto) {
        int mesComMaiorCusto = 0;
        if (registroDeCusto.length == 0) {
            mesComMaiorCusto = 0;
            double maiorCusto = registroDeCusto[0];
            for (int i = 1; i < registroDeCusto.length; i++) {
                if (registroDeCusto[i] > maiorCusto) {
                    maiorCusto = registroDeCusto[i];
                    mesComMaiorCusto = i;
                }


                maiorCusto = registroDeCusto[i];
                mesComMaiorCusto = i;

                maiorCusto = registroDeCusto[i];

                // return mesComMaiorCusto;
            }
        } return mesComMaiorCusto;
    }
    public static void RegistrarNovoCusto(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o valor do custo: ");
        double valor = entrada.nextDouble();
        entrada.nextLine();
        System.out.println("Digite a descrição do custo: ");
        String descricao = entrada.nextLine();
        System.out.println("Digite a data do custo: ");
        String data = entrada.nextLine();
        System.out.println("Digite a categoria do custo: ");
        String categoria = entrada.nextLine();
        System.out.println("Digite o departamento do custo, sendo Rh, Produção, Engenharia, Expedição, Compras e Venda: ");
        String dep = entrada.nextLine();
        RegistroDeCusto regi = new RegistroDeCusto(valor,descricao, data,  categoria, dep);
        registroDeCusto.adicionarRegistroDeCusto(regi);
    }
}



