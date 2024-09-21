package bancario;

import java.util.LinkedList;
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
    private LinkedList<TarjetaDeCredito> tarjetasDeCredito;
    private CuentaDeAhorro cuentaDeAhorro;
    private CuentaDeInversion cuentaDeInversion;


    //private ArrayList<bancario.CuentaDeAhorro> bancario.CuentaDeAhorro;

    //Constructor
    public Cliente(int numeroDeCuenta, String fechaDeNacimiento, String nombre, String apellido, String Direccion, String telefono, String correo){
        this.cuentaDeAhorro =new CuentaDeAhorro(0);
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

    public CuentaDeAhorro getCuentaAhorro(){
        return cuentaDeAhorro;
    }
    public CuentaDeInversion getCuentaInversion(){return cuentaDeInversion;}
    //setters:
    public void setnumeroDecuenta(int numeroDeCuenta){
        if(numeroDeCuenta>0){
            this.numeroDeCuenta=numeroDeCuenta;
        }else{
            System.out.println("Dato no válido.");
        }
    }

    public void setCuentaDeInversion(CuentaDeInversion cuentaDeInversion){this.cuentaDeInversion=cuentaDeInversion;}

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
    public void AgregarCuenta(CuentaDeAhorro cuenta){
        cuentaDeAhorro = cuenta;
    }
    //métodos del cliente.
    public static Cliente CrearNuevoUsuario(int numeroDeCuenta, String fechaDeNacimiento, String nombre, String apellido, String Direccion, String telefono, String correo){
        Cliente cliente=new Cliente(numeroDeCuenta, fechaDeNacimiento, nombre, apellido, Direccion, telefono, correo);
        clientesCreados++;
        return cliente;
    }
    public static void IngreseDeDatos(Scanner scanner,Banco banco){
        //do{
            int num=CuentaDeAhorro.NumerosDeCuentaRandom();
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
        CuentaDeAhorro.TiposDeCuentas(scanner, banco.getList());
    }
    
}

