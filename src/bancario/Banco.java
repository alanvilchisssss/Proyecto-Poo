package bancario;

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
                System.out.println("Numero de cuenta: "+contador+"\tFecha De Nacimiento:"+variable.getfechaDeNacimiento()+"\tNombre:"+variable.getnombre()+" "+variable.getapellidos()+"\t Dirección:"+variable.getdireccion()+"\t Telefono:"+variable.getelefono()+"\n Correo: "+variable.getcorreo());
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
                System.out.println("Numero de cuenta: "+contador+"\tFecha De Nacimiento:"+variable.getfechaDeNacimiento()+"\tNombre:"+variable.getnombre()+" "+variable.getapellidos()+"\t Dirección:"+variable.getdireccion()+"\t Telefono:"+variable.getelefono()+"\n Correo: "+variable.getcorreo());
                contador++;

                CuentaDeAhorro cuenta = variable.getCuentaAhorro();
                System.out.println("\tCuenta de ahorro: \tSaldo:"+cuenta.getSaldo());
                if(variable.getCuentaInversion() != null){
                    System.out.println("\tCuenta de inversion: \tDinero invertido:"+variable.getCuentaInversion().getDineroInvertido());
                    System.out.println("\tRendimiento: "+variable.getCuentaInversion().getRendimiento()+"\tPlazo de inversion: "+variable.getCuentaInversion().getPlazo());
                }
            }
        }
    }

    public static void ImprimirRegistrosDeLasInversiones(ArrayList<Cliente> ListaCliente){
        int contador=1;
        if(ListaCliente.isEmpty()){
            System.out.println("La lista de clientes está vacía");
        }else{
            for(Cliente variable: ListaCliente){
                System.out.println("Numero de cuenta: "+contador+"\tFecha De Nacimiento:"+variable.getfechaDeNacimiento()+"\tNombre:"+variable.getnombre()+" "+variable.getapellidos()+"\t Dirección:"+variable.getdireccion()+"\t Telefono:"+variable.getelefono()+"\n Correo: "+variable.getcorreo());
                contador++;

                if(variable.getCuentaInversion() != null){
                    variable.imprimirRegistros();
                    System.out.println();
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
            System.out.println("Numero de cuenta: "+index+"\tFecha De Nacimiento:"+ListaCliente.get(index-1).getfechaDeNacimiento()+"\tNombre:"+ListaCliente.get(index-1).getnombre()+" "+ListaCliente.get(index-1).getapellidos()+"\t Dirección:"+ListaCliente.get(index-1).getdireccion()+"\t Telefono:"+ListaCliente.get(index-1).getelefono()+"\n Correo: "+ListaCliente.get(index-1).getcorreo());
            System.out.println("Cuentas de ahorro(básicas):");

            System.out.println("\tCuenta de ahorro: \tSaldo:"+ListaCliente.get(index-1).getCuentaAhorro().getSaldo());
            if(ListaCliente.get(index-1).getCuentaInversion() != null){
                System.out.println("\tCuenta de inversion: \tDinero invertido:"+ListaCliente.get(index-1).getCuentaInversion().getDineroInvertido());
                System.out.println("\tRendimiento: "+ListaCliente.get(index-1).getCuentaInversion().getRendimiento()+"\tPlazo de inversion: "+ListaCliente.get(index-1).getCuentaInversion().getPlazo());
            }
        }
    }
    public static void ModificarAlgunDato(ArrayList<Cliente> ListaCliente, Scanner scanner){
        int opcion=0;
        System.out.println("Ingrese el índice del cliente que desea sus datos:");
        ImprimirClientes(ListaCliente);
        int index=scanner.nextInt();
        scanner.nextLine();
            System.out.println("¿Qué desea modificar?");
            System.out.println("1. Fecha de nacimiento");
            System.out.println("2. nombres iniciales");
            System.out.println("3. apellidos");
            System.out.println("4. Dirección");
            System.out.println("5. telefono");
            System.out.println("6. Correo");
            System.out.println("7. Salir");
            opcion=scanner.nextInt();
            scanner.nextLine();
            switch(opcion){
                case 1->{
                    System.out.println("Ingrese el nuevo dato:");
                    String Corrección=scanner.nextLine();
                    scanner.nextLine();
                    ListaCliente.get(index-1).setfechaDeNacimiento(Corrección);
                }case 2->{
                    System.out.println("Ingrese el nuevo dato:");
                    String Corrección=scanner.nextLine();
                    scanner.nextLine();
                    ListaCliente.get(index-1).setnombre(Corrección);
                    
                }case 3->{
                    System.out.println("Ingrese el nuevo dato:");
                    String Corrección=scanner.nextLine();
                    scanner.nextLine();
                    ListaCliente.get(index-1).setapellidos(Corrección);                    
                }case 4->{
                    System.out.println("Ingrese el nuevo dato:");
                    String Corrección=scanner.nextLine();
                    scanner.nextLine();
                    ListaCliente.get(index-1).setdireccion(Corrección);
                }case 5->{
                    System.out.println("Ingrese el nuevo dato:");
                    String Corrección=scanner.nextLine();
                    scanner.nextLine();
                    ListaCliente.get(index-1).settelefono(Corrección);
                }case 6->{
                    System.out.println("Ingrese el nuevo dato:");
                    String Corrección=scanner.nextLine();
                    scanner.nextLine();
                    ListaCliente.get(index-1).setcorreo(Corrección);
                }case 7->{
                    System.out.println("...saliendo");
                }
                default->System.out.println("Error.");
            }
        }
}
