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
        System.out.println("[2] Registrar novo colaborador");
        System.out.println("[3] Pesquisar registros de custo");
        System.out.println("=====================================");
    }

    public static void executar() {
        Scanner entrada = new Scanner(System.in);
        entrada.useLocale(Locale.ENGLISH);

        int opcao = 0;
        do {
            menu();
            System.out.print("Escolha uma opção válida!");
            System.out.print("Digite a opção escolhida:")
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
