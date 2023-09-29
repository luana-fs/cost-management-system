public class Funcionario {

	private int matricula;

	private String nome;

	private String departamento;

	public Funcionario(int matricula, String nome, String departamento)
	{
		this.matricula = matricula;
		this.nome = nome;
		this.departamento = departamento;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome
	}

	public String getDepartamento(String departamento) {
		return departamento;
	}

	public void setDepartamento() {
		this.departamento = departamento
	}

}
