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
    public RegistroDeCusto(){

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
        RegistroDeCusto reg=null;
        List<RegistroDeCusto> resultados = new ArrayList<>();
        for (i = 0; i < registrosDeCusto.size(); i++) {
            if (registrosDeCusto.get(i).getDescricao().equalsIgnoreCase(descricao)) {
                reg = registrosDeCusto.get(i);
                resultados.add(reg);

            }
        }
        if(reg!=null) {
            return resultados;
        }else{
            return  null;
        }
    }

    public List<RegistroDeCusto> pesquisarCategoria(String categoria) {
        int i;
        RegistroDeCusto reg=null;
        List<RegistroDeCusto> resultados = new ArrayList<>();
        for (i = 0; i < registrosDeCusto.size(); i++) {
            if (registrosDeCusto.get(i).getCategoria().equalsIgnoreCase(categoria)) {
                reg = registrosDeCusto.get(i);
                resultados.add(reg);
            }
        }
        if(reg!=null) {
            return resultados;
        }else{
            return  null;
        }
    }

    public List<RegistroDeCusto> pesquisarData(String data) {
        int i;
        RegistroDeCusto reg=null;
        List<RegistroDeCusto> resultados = new ArrayList<>();
        for (i = 0; i < registrosDeCusto.size(); i++) {
            if (registrosDeCusto.get(i).getData().equals(data)) {
                reg = registrosDeCusto.get(i);
                resultados.add(reg);
            }
        }
        if(reg!=null) {
            return resultados;
        }else{
            return  null;
        }
    }

    public List<RegistroDeCusto> pesquisarDepartamento(String departamento) {
        int i;
        RegistroDeCusto reg=null;
        List<RegistroDeCusto> resultados = new ArrayList<>();
        for (i = 0; i < registrosDeCusto.size(); i++) {
            if (registrosDeCusto.get(i).getDepartamento().equals(departamento)) {
                reg = registrosDeCusto.get(i);
                resultados.add(reg);
            }
        }
        if(reg!=null) {
            return resultados;
        }else{
            return  null;
        }
    }

    public void percentualCustoPorDep(){
        int percentualRh;
        int percentualCompra;
        int percentualVenda;
        int percentualExpedicao;
        int percentualEngenharia;
        int percentualProducao;
        int contRh =0;
        int contCompra =0;
        int contVenda =0;
        int contExpedicao =0;
        int contEngenharia =0;
        int contProducao =0;
        for(int i=0; i<registrosDeCusto.size(); i++){
            if(registrosDeCusto.get(i).getDepartamento().equals("RH")){
                contRh += 1;
            }
            if(registrosDeCusto.get(i).getDepartamento().equals("Compra")){
                contCompra += 1;
            }
            if(registrosDeCusto.get(i).getDepartamento().equals("Venda")){
                contVenda += 1;
            }
            if(registrosDeCusto.get(i).getDepartamento().equals("Expedição")){
                contExpedicao += 1;
            }
            if(registrosDeCusto.get(i).getDepartamento().equals("Engenharia")){
                contEngenharia += 1;
            }
            if(registrosDeCusto.get(i).getDepartamento().equals("Produção")){
                contProducao += 1;
            }
        }
        percentualRh = (3*registrosDeCusto.size())/100;
        percentualCompra = (contCompra*registrosDeCusto.size())/100;
        percentualVenda = (contVenda*registrosDeCusto.size())/100;
        percentualExpedicao = (contExpedicao*registrosDeCusto.size())/100;
        percentualProducao = (contProducao*registrosDeCusto.size())/100;
        percentualEngenharia = (contEngenharia*registrosDeCusto.size())/100;

        System.out.println("RH: "+ percentualRh +"% "+"Compra: "+percentualCompra+"% "+"Venda: "+percentualVenda+"% "+"Expedição: "+percentualExpedicao+"% "+"Engenharia: "+percentualEngenharia+"% "+"Produção: "+percentualProducao+"% ");

    }
}