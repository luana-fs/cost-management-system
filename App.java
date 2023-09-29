import java.util.Scanner;
import java.util.Locale;

public class App {

  private static Funcionario funcionarioLogado;

  public static void main(String[] args) {

  Departamento[] departamentos = new Departamento[6];

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
  
    private void cadastrarNovoFuncionario() {
        System.out.println("=====================================");
        System.out.println("Cadastrar um funcionario");
	    System.out.print("Digite seu numero de matricula: ");
        int matricula = entrada.nextInt();
        System.out.print("Informe seu nome: ");
        String nome = entrada.nextLine();
	    System.out.print("Informe seu departamento: ");
        String departamento = entrada.nextLine();
        Funcionario f = new Funcionario(matricula, nome, departamento );
        if(cadastro.cadastraFuncionario(f))
            System.out.println("Funcionario cadastrado com sucesso.");
        else
            System.out.println("Erro: Funcionario não cadastrado.");
    }

    private static boolean startupMenu() {
        Scanner entrada = new Scanner(System.in);
        int opcao = 0;
        System.out.println("=====================================");
        System.out.print("Olá! Seja bem vindo ao sistema de controle de custos da empresa!");
        System.out.println("Selecione a forma de acesso:");
        while(opcao != 1 && opcao != 2) {
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
                    // CadastrarNovoFuncionario();
                    break;
                default: System.out.println("Selecione uma opção valida!");
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
        System.out.println("[0] Sair do sistema");
        System.out.println("=====================================");
    }

    public static void executar() {
        Scanner entrada = new Scanner(System.in);
        entrada.useLocale(Locale.ENGLISH);
        boolean logado = false;
        int opcao = 0;

        while (logado == false) {
            logado = startupMenu();
        }

        do {
            menu();
            System.out.print("Insira a opção desejada:");
            opcao = entrada.nextInt();
            entrada.nextLine();
            switch (opcao) {
                case 0: opcao = 0;
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
                default:
                    System.out.println("Selecione uma opção valida!");
            }
        } while (opcao != 0);
    }
}
