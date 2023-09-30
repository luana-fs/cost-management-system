import java.util.ArrayList;

public class ListaDepartamentos {
    private ArrayList<Departamento> listaDepartamentos;

    public ListaDepartamentos() {
        listaDepartamentos = new ArrayList<>();
    }

    public void add(Departamento d) {
        listaDepartamentos.add(d);
    }

    public void listarDepartamentos() {
        for (Departamento d : listaDepartamentos) {
            System.out.println(d.getNome());
        }
    }
}