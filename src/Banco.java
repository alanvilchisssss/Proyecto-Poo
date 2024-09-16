import java.util.ArrayList;
public class Banco {
    private static String nombre="Puma Dolores";
    private Cliente cliente;
    private ArrayList<Cliente> listaClientes;
    public Banco(){
    }
    //getters:
    public String getnombre(){
        return nombre;
    }
    public ArrayList<Cliente> getList(){
        return listaClientes;
    }
    //setters:
    public void AgregarCliente(Cliente cliente){
        this.listaClientes.add(cliente);
    }
}
