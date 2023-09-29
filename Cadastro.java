import java.util.ArrayList;

public class Cadastro {

    private static ArrayList<Funcionario> funcionarios;

    public Cadastro() {funcionarios = new ArrayList<Funcionario>(10);}

    public static boolean cadastraFuncionario(Funcionario f) { return funcionarios.add(f);}

    
}