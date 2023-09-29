import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class RegistroDeCusto {

	private double valor;
	private String descricao;
	private String data;
	private String categoria;
	private String departamento;

	private List<RegistroDeCusto> registrosDeCusto = new ArrayList<>();

	public RegistroDeCusto(double valor, String descricao, String data, String categoria, String departamento) {
		this.valor = valor;
		this.descricao = descricao;
		this.data = (data != null) ? data : new Date().toString();
		this.categoria = categoria;
		this.departamento = departamento;
	}

	public void adicionarRegistroDeCusto(RegistroDeCusto registro) {
		registrosDeCusto.add(registro);
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

	public List<RegistroDeCusto> pesquisaDescricao(String descricao) {
		int i;
		List<RegistroDeCusto> resultados = new ArrayList<>();
		for (i = 0; i < registrosDeCusto.size(); i++) {
			RegistroDeCusto reg = registrosDeCusto.get(i);
			if (reg.getDescricao().equalsIgnoreCase(descricao)) {
				resultados.add(reg);

			}
		}
		return resultados;
	}

	public List<RegistroDeCusto> pesquisarCategoria(String categoria) {
		int i;
		List<RegistroDeCusto> resultados = new ArrayList<>();
		for (i = 0; i < registrosDeCusto.size(); i++) {
			RegistroDeCusto reg = registrosDeCusto.get(i);
			if (reg.getCategoria().equalsIgnoreCase(categoria)) {
				resultados.add(reg);
			}
		}
		return resultados;
	}

	public List<RegistroDeCusto> pesquisarData(String data) {
		int i;
		List<RegistroDeCusto> resultados = new ArrayList<>();
		for (i = 0; i < registrosDeCusto.size(); i++) {
			RegistroDeCusto reg = registrosDeCusto.get(i);
			if (reg.getData().equals(data)) {
				resultados.add(reg);
			}
		}
		return resultados;
	}

	public List<RegistroDeCusto> pesquisarDepartamento(String departamento) {
		int i;
		List<RegistroDeCusto> resultados = new ArrayList<>();
		for (i = 0; i < registrosDeCusto.size(); i++) {
			RegistroDeCusto reg = registrosDeCusto.get(i);
			if (reg.getDepartamento().equals(departamento)) {
				resultados.add(reg);
			}
		}
		return resultados;
	}

	// if(registrosDeCusto.get(i).getDescricao().equalsIgnoreCase(descricao)){
	// reg = registrosDeCusto.get(i);
	// }
	// }
	// return reg;

}