import java.util.ArrayList;
import java.util.List;

public class Cadastro {

    private List<Funcionario> funcionarios;

    public Cadastro() {
        funcionarios = new ArrayList<>();
    }

    public boolean cadastraFuncionario(Funcionario f) {
        return funcionarios.add(f);
    }

    public void imprimeFuncionarios() {
        for (int i = 0; i < funcionarios.size(); i++) {
            System.out.println(i + ": " + funcionarios.get(i).getNome());
        }
    }

    public int getNumeroFuncionarios() {
        return funcionarios.size();
    }

    public Funcionario getFuncionario(int indice) {
        return funcionarios.get(indice);
    }


}