import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class CuentaDeAhorro {
    private int numeroDeCuenta=NumerosDeCuentaRandom();
    private int saldo=0;
    public CuentaDeAhorro(int saldo){//se recibirá saldo para tener un monto inicial en la cuenta.
        this.saldo=saldo;
    }   
    //getters
    public int getnumeroDecuenta(){
        return numeroDeCuenta;
    }
    public int getSaldo(){
        return saldo;
    }
    //setters:
    public void setnumeroDecuenta(int numeroDeCuenta){
        this.numeroDeCuenta=numeroDeCuenta;
    }
    public void setsaldo(int saldo){
        this.saldo=saldo;
    }
    //métodos
    public static void TiposDeCuentas(Scanner scanner,ArrayList<Cliente> ListaCliente){//este método se utiliza creando a un nuevo cliente, siguiendo la lógica de que si se va a crear un nuevo usuario del banco, también se debe de crear una cuenta
        System.out.println("¿Que tipo de cuenta desea crear, 1)de ahorro o de 2)inversión?");
        int opcion=scanner.nextInt();
        scanner.nextLine();
        System.out.println("¿Cuánto saldo desea ingresar en la cuenta?");
        int saldo=scanner.nextInt();
        scanner.nextLine();
        switch(opcion){
            case 1->{
                CuentaDeAhorro cuenta=new CuentaDeAhorro(saldo);
                System.out.println("¿A que cliente desea asociar esta cuenta?(Ingrese un índice)");
                Banco.ImprimirClientes(ListaCliente);
                int index=scanner.nextInt();
                scanner.nextLine();
                ListaCliente.get(index-1).AgregarCuenta(cuenta);
            }
            case 2->{
                //aquí va el método para crear cuenta de inversión
            }
        }
    }
    public static int NumerosDeCuentaRandom(){
        Random random=new Random();
        int numero=random.nextInt(0,999999999);
        return numero;
    }
}
