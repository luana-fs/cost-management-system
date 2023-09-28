public class Departamento
{
    private String nome;

    public Departamento(String nome)
    {
        this.nome = nome;
    }
    
    public String getNome()
    {
        return this.nome;
    }

    @Override
    public String toString() {
        return "Departamento [nome=" + nome + "]";
}
