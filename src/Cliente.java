import java.util.LinkedList;
import java.util.Random;
public class Cliente {
    public int numeroDeCuenta;
    int[] fechaDeNacimiento = new int[3];
    double saldodeAhorro;
    String nombre;
    String apellido;
    String direccion;
    String telefono;
    String correo;
    LinkedList<Double>[] tarjetas;
    public static Cliente cliente(){
        Random random = new Random();
        int numeroDeCuenta=random.nextInt(500);
        return new Cliente();
    }
}

