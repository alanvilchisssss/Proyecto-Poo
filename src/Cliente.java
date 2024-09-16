import java.util.Scanner;
public class Cliente {
    static int clientesCreados=0;
    private int numeroDeCuenta;
    private String fechaDeNacimiento;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String correo;

    //LinkedList<Double>[] tarjetas;
    //Constructor
    public Cliente(int numeroDeCuenta, String fechaDeNacimiento, String nombre, String apellido, String Direccion, String telefono, String correo){
        this.numeroDeCuenta=numeroDeCuenta;
        this.fechaDeNacimiento=fechaDeNacimiento;
        this.nombre=nombre;
        this.apellido=apellido;
        this.direccion=Direccion;
        this.telefono=telefono;
        this.correo=correo;
    }
    //Getters:
    public int getnumeroDecuenta(){
        return numeroDeCuenta;
    }
    public String getfechaDeNacimiento(){
        return fechaDeNacimiento;
    }
    public String getnombre(){
        return nombre;
    }
    public String getapellidos(){
        return apellido;
    }
    public String getdireccion(){
        return direccion;
    }
    public String getelefono(){
        return telefono;
    }
    public String getcorreo(){
        return correo;
    }
    //setters:
    public void setnumeroDecuenta(int numeroDeCuenta){
        if(numeroDeCuenta>0){
            this.numeroDeCuenta=numeroDeCuenta;
        }else{
            System.out.println("Dato no válido.");
        }
    }
    public void setfechaDeNacimiento(String Fecha){
        if(Fecha.length()==10){
        this.fechaDeNacimiento=Fecha;
        }else if(Fecha.isBlank()||Fecha.length()<10){
            System.out.println("Intente Otra vez");
        }
    }
    public void setnombre(String nombre){
        this.nombre=nombre;
    }
    public void setapellidos(String Apellidos){
        this.apellido=Apellidos;
    }
    public void setdireccion(String Direccion){
        this.direccion=Direccion;
    }
    public void settelefono(String telefono){
        this.telefono=telefono;
    }
    public void setcorreo(String correo){
        this.correo=correo;
    }
    //métodos del cliente.
    public static Cliente CrearNuevoUsuario(int numeroDeCuenta, String fechaDeNacimiento, String nombre, String apellido, String Direccion, String telefono, String correo){
        Cliente cliente=new Cliente(numeroDeCuenta, fechaDeNacimiento, nombre, apellido, Direccion, telefono, correo);
        clientesCreados++;
        return cliente;
    }
    public static void IngreseDeDatos(Scanner scanner,Banco banco){
        //do{
            System.out.println("Ingrese el numero de cuenta del cliente:");
            int num=scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese la fecha de nacimiento con el siguiente formato: 15/07/2005 (dd/mm/aaaa)");
            String fecha=scanner.nextLine();
            scanner.nextLine();
            System.out.println("Ingrese el nombre(s) del usuario:");
            String nombres=scanner.nextLine();
            scanner.nextLine();
            System.out.println("Ingrese los apellidos del usuario:");
            String apellidos=scanner.nextLine();
            scanner.nextLine();
            System.out.println("Ingrese la Dirección del usuario:");
            String direccion=scanner.nextLine();
            scanner.nextLine();
            System.out.println("Ingrese el teléfono:");
            String telefonos=scanner.nextLine();
            scanner.nextLine();
            System.out.println("Ingrese el correo:");
            String correo=scanner.nextLine();
            scanner.nextLine();
        //}while(num,fecha,nombres,apellidos,direccion,telefonos,correo!="");
        
        banco.AgregarCliente(CrearNuevoUsuario(num, fecha, nombres, apellidos, direccion, telefonos, correo));
    }
    
}

