import java.util.LinkedList;
import java.util.Random;
public class Cliente {
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
        return telefono;
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
    /*public static Cliente cliente(){
        Random random = new Random();
        int numeroDeCuenta=random.nextInt(500);
        return new Cliente();
    }*/
}

