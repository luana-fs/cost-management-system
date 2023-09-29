import java.util.Date;

public class RegistroDeCusto {

	private double valor;
	private String descricao;
	private String data;
	private String categoria;
	private String departamento;

	public RegistroDeCusto(double valor, String descricao, String data, String categoria, String departamento) {
		this.valor = valor;
		this.descricao = descricao;
		this.data = (data != null) ? data : new Date().toString();
		this.categoria = categoria;
		this.departamento = departamento;
	}

	public double getValor() {
		return this.valor;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public String getData() {
		return this.data;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public String toString() {
		return "Produto: " + this.getDescricao() + "\n"
				+ "Valor: R$" + this.getValor() + "\n"
				+ "Data: " + this.getData() + "\n"
				+ "Categoria do custo: " + this.getCategoria() + "\n"
				+ "Departamento: " + this.getDepartamento() + "\n";
	}

}
