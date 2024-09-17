import java.util.ArrayList;
import java.util.Scanner;
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
        int contador=1;
            if(ListaCliente.isEmpty()){
                System.out.println("La lista de clientes está vacía");
            }else{
            for(Cliente variable: ListaCliente){
                System.out.println("usuario "+contador+"\tnumero de cuenta: "+variable.getnumeroDecuenta()+"\tFecha De Nacimiento:"+variable.getfechaDeNacimiento()+"\tNombre:"+variable.getnombre()+" "+variable.getapellidos()+"\t Dirección:"+variable.getdireccion()+"\t Telefono:"+variable.getelefono()+"\n Correo: "+variable.getcorreo());
                contador++;
            }
        }
    }
    public static void ImprimirClienteYCuentaConAtributos(ArrayList<Cliente> ListaCliente){
        int contador=1;
        if(ListaCliente.isEmpty()){
            System.out.println("La lista de clientes está vacía");
        }else{
            for(Cliente variable: ListaCliente){
                System.out.println("usuario "+contador+"\tnumero de cuenta: "+variable.getnumeroDecuenta()+"\tFecha De Nacimiento:"+variable.getfechaDeNacimiento()+"\tNombre:"+variable.getnombre()+" "+variable.getapellidos()+"\t Dirección:"+variable.getdireccion()+"\t Telefono:"+variable.getelefono()+"\n Correo: "+variable.getcorreo());
                contador++;
                for(CuentaDeAhorro cuenta: variable.getCuenta()){
                    System.out.println("\tNumero de cuenta: "+cuenta.getnumeroDecuenta()+"\tSaldo:"+cuenta.getSaldo());
                }
            }
            
        }
    }
    public static void ImprimirSoloCliente(ArrayList<Cliente> ListaCliente, Scanner scanner){
        if(ListaCliente.isEmpty()){
            System.out.println("La lista de clientes está vacía");
        }else{
            System.out.println("Ingrese el índice del cliente que desea sus datos:");
            int index=scanner.nextInt();
            scanner.nextLine();
            System.out.println("usuario "+index+"\tnumero de cuenta: "+ListaCliente.get(index-1).getnumeroDecuenta()+"\tFecha De Nacimiento:"+ListaCliente.get(index-1).getfechaDeNacimiento()+"\tNombre:"+ListaCliente.get(index-1).getnombre()+" "+ListaCliente.get(index-1).getapellidos()+"\t Dirección:"+ListaCliente.get(index-1).getdireccion()+"\t Telefono:"+ListaCliente.get(index-1).getelefono()+"\n Correo: "+ListaCliente.get(index-1).getcorreo());
            for(CuentaDeAhorro cuenta: ListaCliente.get(index-1).getCuenta()){
                System.out.println("\tNumero de cuenta: "+cuenta.getnumeroDecuenta()+"\tSaldo:"+cuenta.getSaldo());
            }
        }
    }
}
