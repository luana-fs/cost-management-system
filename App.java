public class App {

	private static Funcionario funcionarioLogado;

	public static void main(String args[])
	{
		Departamento[] departamentos = new Departamento[6];

	//Estanciando os departamentos
		Departamento rh = new Departamento("RH");
		Departamento compras = new Departamento("Compras");
		Departamento vendas = new Departamento("Vendas");
		Departamento expedicao = new Departamento("Expedição");
		Departamento engenharia = new Departamento("Engenharia");
		Departamento producao = new Departamento("Produção");

	//Populando o array
	System.out.println("O departamento foi cadastrdo com sucesso? " + App.insereDep(departamentos, rh));
	System.out.println("O departamento foi cadastrdo com sucesso? " + App.insereDep(departamentos, compras));
	System.out.println("O departamento foi cadastrdo com sucesso? " + App.insereDep(departamentos, vendas));
	System.out.println("O departamento foi cadastrdo com sucesso? " + App.insereDep(departamentos, expedicao));
	System.out.println("O departamento foi cadastrdo com sucesso? " + App.insereDep(departamentos, engenharia));
	System.out.println("O departamento foi cadastrdo com sucesso? " + App.insereDep(departamentos, producao));
		

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
}
