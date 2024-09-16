import java.util.ArrayList;
public class Banco {
    private static String nombre="Puma Dolores";
    private ArrayList<Cliente> listaClientes;
    public Banco(){
        this.listaClientes=new ArrayList<>();
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
        listaClientes.add(cliente);
    }
    public static void ImprimirClientes(ArrayList<Cliente> ListaCliente) {
        for(Cliente variable: ListaCliente){
            System.out.println("numero de cuenta: "+variable.getnumeroDecuenta()+"\tFecha De Nacimiento:"+variable.getfechaDeNacimiento()+"\tNombre:"+variable.getnombre()+" "+variable.getapellidos()+"\t Dirección:"+variable.getdireccion()+"\t Telefono:"+variable.getelefono()+"\t Correo: "+variable.getcorreo());
        }
    }
}
