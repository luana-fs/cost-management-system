import java.util.Scanner;
import java.util.Locale;

public class App {

  private static Funcionario funcionarioLogado;
  private static RegistroDeCusto registroDeCusto;

  public static void main(String[] args) {

  Departamento[] departamentos = new Departamento[6];
  registroDeCusto = new RegistroDeCusto(); 

  //Estanciando os departamentos
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

	//Populando o array
	System.out.println("O departamento foi cadastrdo com sucesso? " + App.insereDep(departamentos, rh));
	System.out.println("O departamento foi cadastrdo com sucesso? " + App.insereDep(departamentos, compras));
	System.out.println("O departamento foi cadastrdo com sucesso? " + App.insereDep(departamentos, vendas));
	System.out.println("O departamento foi cadastrdo com sucesso? " + App.insereDep(departamentos, expedicao));
	System.out.println("O departamento foi cadastrdo com sucesso? " + App.insereDep(departamentos, engenharia));
	System.out.println("O departamento foi cadastrdo com sucesso? " + App.insereDep(departamentos, producao));
		
	App.imprimeDep(departamentos);
	
	}

	public static boolean insereDep(Departamento[] dep, Departamento d)
	{
		for(int i = 0; i<dep.length;i++)
		{
			if(dep[i]==null)
			{
				dep[i] = d;
				return true;
			}
		}
		return false;
	}

	public static void imprimeDep(Departamento[] dep)
    {
        int contador = 1;
        for(int i = 0; i<dep.length;i++)
		{
			System.out.println(contador + ": " + dep[i]);
            contador++;
		}
        menu();
        executar();

        // Exemplo de novo cadastro de custo
        RegistroDeCusto reg1 = new RegistroDeCusto(3559.80, "Notebook", "26/09/2023", "Eletrônicos", "Compras");
        System.out.println(reg1.toString());

    }

    private static void menu() {
        System.out.println("=====================================");
        System.out.println("Menu de opcoes: ");
        System.out.println("[0] Sair do sistema");
        System.out.println("[1] Acessar");
        System.out.println("[2] Cadastrar novo funcionario");
        System.out.println("[3] Pesquisar registros de custo");
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
                case 3:
                    menuPesquisa();
                    int opcaoPesquisa = entrada.nextLine();
                    executarPesquisa(opcaoPesquisa);
                    break;
                default:
                    System.out.println("Selecione uma opção valida!");
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
                RegistroDeCusto resultadoDescricao = registroDeCusto.pesquisaDescricao(descricao);
                if (resultadoDescricao != null) {
                    System.out.println("Resultado da pesquisa:\n" + resultadoDescricao.toString());
                } else {
                    System.out.println("Nenhum resultado encontrado.");
                }
                break;
            case "2":
                System.out.print("Digite a categoria que deseja pesquisar: ");
                String categoria = entrada.nextLine();
                RegistroDeCusto resultadoCategoria = registroDeCusto.pesquisarCategoria(categoria);
                if (resultadoCategoria != null) {
                    System.out.println("Resultado da pesquisa:\n" + resultadoCategoria.toString());
                } else {
                    System.out.println("Nenhum resultado encontrado.");
                }
                break;
            case "3":
                System.out.print("Digite a data que deseja pesquisar: ");
                String data = entrada.nextLine();
                RegistroDeCusto resultadoData = registroDeCusto.pesquisarData(data);
                if (resultadoData != null) {
                    System.out.println("Resultado da pesquisa:\n" + resultadoData.toString());
                } else {
                    System.out.println("Nenhum resultado encontrado.");
                }
                break;
            case "4":
                System.out.print("Digite o departamento o departamento: ");
                String departamento = entrada.nextLine();
                RegistroDeCusto resultadoDepartamento = registroDeCusto.pesquisarDepartamento(departamento);
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
