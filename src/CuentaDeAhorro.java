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
    public void sumaDeDinero(int dinero){
        this.saldo+=dinero;
    }
    public void retirarDinero(int dinero){
        if(dinero>this.saldo){
            System.out.println("Saldo insuficiente");
        }else{
            this.saldo-=dinero;
        }
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
    public static void Agregardinero(Banco banco, Scanner scanner){
        Banco.ImprimirClienteYCuentaConAtributos(banco.getList());
        System.out.println("de que usuario desea agregar dinero?");
        int opcion=0;
        opcion=scanner.nextInt();
        scanner.nextLine();
        System.out.println("De que cuenta bancaria?");
        int cuenta=0;
        cuenta=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Cuánto dinero desea agregar?");
        int dinero=0;
        dinero=scanner.nextInt();
        scanner.nextLine();
        banco.getList().get(opcion-1).getCuenta().get(cuenta-1).sumaDeDinero(dinero);
    }
    public static void RetirarDinero(Banco banco, Scanner scanner){
        Banco.ImprimirSoloCliente(banco.getList(), scanner);
        System.out.println("de que usuario desea agregar dinero?");
        int opcion=0;
        opcion=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Cuánto dinero desea retirar de su cuenta?");
        int dinero=0;
        dinero=scanner.nextInt();
        scanner.nextLine();
        banco.getList().get(opcion-1).getCuenta().get(0).retirarDinero(dinero);
    
    }
    public static int NumerosDeCuentaRandom(){
        Random random=new Random();
        int numero=random.nextInt(0,999999999);
        return numero;
    }
}
