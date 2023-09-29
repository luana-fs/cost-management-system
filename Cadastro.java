import java.util.ArrayList;

public class Cadastro {

    private ArrayList<Funcionario> funcionarios;

    public Cadastro() {funcionarios = new ArrayList<Funcionario>(10);}

    public boolean cadastraFuncionario(Funcionario f) { return funcionarios.add(f);}

    
}