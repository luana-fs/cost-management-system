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
		departamentos[0] = rh;
		departamentos[1] = compras;
		departamentos[2] = vendas;
		departamentos[3] = expedicao;
		departamentos[4] = engenharia ;
		departamentos[5] = producao;
		





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
}
