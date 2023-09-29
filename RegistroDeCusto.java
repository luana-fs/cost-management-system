import java.util.Date;
import java.util.List;
import java.util.ArrayList;

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

    public RegistroDeCusto pesquisaDescricao(String descricao){ 
        int i;
		RegistroDeCusto reg = null;
        for(i=0; i< registrosDeCusto.size();i++){
			if(registrosDeCusto.get(i).getDescricao().equalsIgnoreCase(descricao)){
        		reg = registrosDeCusto.get(i);
			}
		}
		return reg;
	}
}
