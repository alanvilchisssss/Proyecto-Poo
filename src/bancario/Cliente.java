package bancario;

import bancario.registro.RegistroInversion;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.Scanner;
public class Cliente {
    static int clientesCreados=0;
    private String fechaDeNacimiento;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String correo;
    private LinkedList<TarjetaDeCredito> tarjetasDeCredito;
    private CuentaDeAhorro cuentaDeAhorro;
    private CuentaDeInversion cuentaDeInversion;
    private LinkedList<LocalDateTime> fechasDeposito=new LinkedList<>();
    private LinkedList<LocalDateTime> fechasRetiro=new LinkedList<>();
    private LinkedList<RegistroInversion> registros = new LinkedList<>();


    //Constructor
    public Cliente(String fechaDeNacimiento, String nombre, String apellido, String Direccion, String telefono, String correo){
        this.fechaDeNacimiento=fechaDeNacimiento;
        this.nombre=nombre;
        this.apellido=apellido;
        this.direccion=Direccion;
        this.telefono=telefono;
        this.correo=correo;
        this.tarjetasDeCredito=new LinkedList<>();
        clientesCreados++;
    }
    //Getters:
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
    public CuentaDeInversion getCuentaInversion(){
        return cuentaDeInversion;
    }
    public LinkedList<TarjetaDeCredito> getListaTarjetas(){
        return tarjetasDeCredito;
    }
    public LinkedList<LocalDateTime> getFechasDeposito(){
        return fechasDeposito;
     }
     public LinkedList<LocalDateTime> getFechasRetiro(){
        return fechasRetiro;
     }
    //setters:
    public void ultimoDeposito(LocalDateTime deposito){
        this.fechasDeposito.add(deposito);
    }
    public void ultimaRetiro(LocalDateTime retiro ){
        this.fechasRetiro.add(retiro);
    }
    public void setCuenta(CuentaDeAhorro cuenta){
        this.cuentaDeAhorro=cuenta;
    }

    public void setCuentaDeInversion(CuentaDeInversion cuentaDeInversion){
        this.cuentaDeInversion=cuentaDeInversion;
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
    public void AgregarCuenta(CuentaDeAhorro cuenta){
        cuentaDeAhorro = cuenta;
    }
    //métodos del cliente.
    public static Cliente CrearNuevoUsuario(String fechaDeNacimiento, String nombre, String apellido, String Direccion, String telefono, String correo){
        Cliente cliente=new Cliente(fechaDeNacimiento, nombre, apellido, Direccion, telefono, correo);
        clientesCreados++;
        return cliente;
    }
    public static void IngreseDeDatos(Scanner scanner,Banco banco){
        //do{
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
        banco.AgregarCliente(CrearNuevoUsuario(fecha, nombres, apellidos, direccion, telefonos, correo));
        CuentaDeAhorro.CreaciónCuentaAhorro(scanner, banco.getList());        

    }
    public void agregarCredito(TarjetaDeCredito tarjeta){
        this.tarjetasDeCredito.add(tarjeta);
     }
     public static void agregarCredito(Cliente cliente,Scanner scanner){
         int tamaño=cliente.getListaTarjetas().size();
         if(tamaño<=2){
             System.out.println("Ingrese el saldo limite");
             int saldoLimite=scanner.nextInt();
             scanner.nextLine();
             System.out.println("Ingrese la fecha de corte (cantidad de meses despues de la fecha actual)");
             int fechaCorte=scanner.nextInt();
             scanner.nextLine();
             TarjetaDeCredito tarjeta=new TarjetaDeCredito(saldoLimite, fechaCorte);
             cliente.agregarCredito(tarjeta);
         }else{
             System.out.println("No es posible asignarle una tarjeta de credito extra");
         }
     }
     public void imprimirListaCredito(){
         int i=1;
         for(TarjetaDeCredito tarjeta:this.tarjetasDeCredito){
             System.out.println("Tarjeta de credito numero "+ i++ + " :");
             tarjeta.imprimirTarjeta();
         }
     }

    public void nuevoRegistro(double saldo, int rendimiento, int plazo) {
        this.registros.add(new RegistroInversion(LocalTime.now(), new CuentaDeInversion(saldo, rendimiento, plazo, true)));
    }

    public void imprimirRegistros() {
        int inversion = 1;
        for(RegistroInversion r : this.registros){
            System.out.println("Inversion: " + inversion);
            System.out.println("Fecha de la inversión: "+r.fechaDeInversion().toString());
            System.out.println("Datos de la inversión: "+"\t Dinero invertido "+r.datos().getDineroInvertido()+"$");
            System.out.println("\tRendimiento: "+r.datos().getRendimiento()+"\tPlazo de inversion: "+r.datos().getPlazo());
            inversion++;
        }
    }

}

