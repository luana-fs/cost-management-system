import java.util.Scanner;
import java.util.List;
import java.util.Locale;

public class App {

    private static Funcionario funcionarioLogado;
    private static RegistroDeCusto registroDeCusto;
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        Departamento[] departamentos = new Departamento[6];
        registroDeCusto = new RegistroDeCusto(14.99, "notebook", "22/08/23", "saasas", "Compras");

        RegistroDeCusto r1 = new RegistroDeCusto(100.0, "Material de Escritório", "2023-02-04", "Suprimentos",
                "Engenharia");
        RegistroDeCusto r2 = new RegistroDeCusto(200.0, "Manutenção de Equipamento", "2022-09-20", "Manutenção",
                "Engenharia");
        RegistroDeCusto r3 = new RegistroDeCusto(500.0, "Manutenção de Equipamento", "2023-08-27", "Manutenção",
                "Engenharia");

        registroDeCusto.adicionarRegistroDeCusto(r1);
        registroDeCusto.adicionarRegistroDeCusto(r2);
        registroDeCusto.adicionarRegistroDeCusto(r3);

        // Estanciando os departamentos
        Departamento rh = new Departamento("RH");
        Departamento compras = new Departamento("Compras");
        Departamento vendas = new Departamento("Vendas");
        Departamento expedicao = new Departamento("Expedição");
        Departamento engenharia = new Departamento("Engenharia");
        Departamento producao = new Departamento("Produção");

        // Populando o array
        App.insereDep(departamentos, rh);
        App.insereDep(departamentos, compras);
        App.insereDep(departamentos, vendas);
        App.insereDep(departamentos, expedicao);
        App.insereDep(departamentos, engenharia);
        App.insereDep(departamentos, producao);

        App.imprimeDep(departamentos);

        menu();
        executar();

        // // Exemplo de novo cadastro de custo
        // RegistroDeCusto reg1 = new RegistroDeCusto(3559.80, "Notebook", "26/09/2023",
        // "Eletrônicos", "Compras");
        // System.out.println(reg1.toString());

    }

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

    private static void cadastrarNovoFuncionario() {
        System.out.println("=====================================");
        System.out.println("Cadastrar um funcionario");
        System.out.print("Digite seu numero de matricula: ");
        int matricula = entrada.nextInt();
        System.out.print("Informe seu nome: ");
        String nome = entrada.nextLine();
        System.out.print("Informe seu departamento: ");
        String departamento = entrada.nextLine();
        Funcionario f = new Funcionario(matricula, nome, departamento);
        if (Cadastro.cadastraFuncionario(f))
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
                entrada.nextLine();
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
        System.out.println("[2] Mostrar estatísticas");
        System.out.println("[3] Pesquisar custo");
        System.out.println("[4] Visualizar dados pessoais");
        System.out.println("[5] Visualizar custos do mês");
        System.out.println("[6] Vizualizar custos dos últimos 3 meses");
        System.out.println("[7] Top 3 funcionários com maiores registros");
        System.out.println("[8] Dia com o maior custo";)
        System.out.println("[0] Sair do sistema");
        System.out.println("=====================================");
    }

    public static void executar() {
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
                    // RegistrarNovoCusto();
                    menu();
                    opcao = entrada.nextInt();
                    entrada.nextLine();
                    break;
                case 2:
                    // MostrarEstatisticas();
                    menu();
                    opcao = entrada.nextInt();
                    entrada.nextLine();
                    break;
                case 3:
                    // PesquisarCusto();
                    menu();
                    opcao = entrada.nextInt();
                    entrada.nextLine();
                    break;
                case 4:
                    // VerDadosFuncionarioLogado();
                    menu();
                    opcao = entrada.nextInt();
                    entrada.nextLine();
                    break;
                case 5:
                    // VerCustosMes();
                    menu();
                    opcao = entrada.nextInt();
                    entrada.nextLine();
                    break;
                case 6:
                    // VerCustosTresMeses();
                    menu();
                    opcao = entrada.nextInt();
                    entrada.nextLine();
                    break;
                case 7:
                    // RankingFuncionarios();
                    menu();
                    opcao = entrada.nextInt();
                    entrada.nextLine();
                    break;
                case 8:
                    // diaComMaisCustos();
                    menu();
                    opcao = entrada.nextInt();
                    entrada.nextLine();
                    break;
                default:
                    System.out.println("Selecione uma opção válida, por favor!");
            }
        } while (opcao != 0);
    }

    private static void menuPesquisa() {
        System.out.println("=====================================");
        System.out.println("Menu de Pesquisa: ");
        System.out.println("[1] Pesquisar por Descrição");
        System.out.println("[2] Pesquisar por Categoria");
        System.out.println("[3] Pesquisar por Data");
        System.out.println("[4] Pesquisar por Departamento");
        System.out.println("[0] Voltar ao menu principal");
        System.out.println("=====================================");
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
                List<RegistroDeCusto> resultadoDepartamento = registroDeCusto.pesquisarDepartamento(departamento);
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
    public void percentualCustoPorDep(){
         int percentualRh;
        int percentualCompra;
        int percentualVenda;
        int percentualExpedicao;
        int percentualEngenharia;
        int percentualProducao;
        int contRh;
        int contCompra;
        int contVenda;
        int contExpedicao;
        int contEngenharia;
        int contProducao;
        for(int i=0; i<departamentos.length; i++){
            if(departamentos[i].getNome == "RH"){
                contRh += 1;
            }
            if(departamentos[i].getNome == "Compra"){
                contCompra += 1;
            }
            if(departamentos[i].getNome == "Venda"){
                contVenda += 1;
            }
            if(departamentos[i].getNome == "Expedição"){
                contExpedicao += 1;
            }
            if(departamentos[i].getNome == "Engenharia"){
                contEngenharia += 1;
            }
            if(departamentos[i].getNome == "Produção"){
                contProducao += 1;
            }
        }
        percentualRh = (contRh*departamentos.length)/100; 
        percentualCompra = (contCompra*departamentos.length)/100;
        percentualVenda = (contVenda*departamentos.length)/100;
        percentualExpedicao = (contExpedicao*departamentos.length)/100;
        percentualProducao = (contProducao*departamentos.length)/100;
        percentualEngenharia = (contEngenharia*departamentos.length)/100;

      System.out.println("RH: "+ percentualRh +"% "+"Compra: "+percentualCompra+"% "+"Venda: "+percentualVenda+"% "+"Expedição: "+percentualExpedicao+"% "+"Engenharia: "+percentualEngenharia+"% "+"Produção: "+percentualProducao+"% ");

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

}
