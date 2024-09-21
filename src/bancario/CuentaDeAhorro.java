package bancario;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class CuentaDeAhorro {
    private double saldo = 0;

    public CuentaDeAhorro(double saldo){//se recibirá saldo para tener un monto inicial en la cuenta.
        this.saldo=saldo;
    }

    //getters
    public double getSaldo(){
        return saldo;
    }


    public void ingresarDinero(double dinero){
        this.saldo+=dinero;
    }

    public double retirarDinero(double dinero){
        if(dinero>this.saldo){
            System.out.println("Saldo insuficiente");
            return 0;
        }else{
            this.saldo-=dinero;
            return dinero;
        }
    }


    //métodos
    public static void TiposDeCuentas(Scanner scanner,ArrayList<Cliente> ListaCliente){//este método se utiliza creando a un nuevo cliente, siguiendo la lógica de que si se va a crear un nuevo usuario del banco, también se debe de crear una cuenta
        System.out.println("¿Que tipo de cuenta desea crear, 1)de ahorro o de 2)inversión?");
        int opcion = scanner.nextInt();
        System.out.println("¿Cuánto saldo desea ingresar en la cuenta?");
        double saldo=scanner.nextDouble();

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
        banco.getList().get(opcion-1).getCuenta().get(cuenta-1).ingresarDinero(dinero);
    }
    public static void RetirarDinero(Banco banco, Scanner scanner){
        Banco.ImprimirSoloCliente(banco.getList(), scanner);
        System.out.println("de que usuario desea agregar dinero?");
        int opcion=0;
        opcion=scanner.nextInt();
        scanner.nextLine();
        System.out.println("De que cuenta bancaria?");
        int cuenta=0;
        cuenta=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Cuánto dinero desea retirar de su cuenta?");
        int dinero=0;
        dinero=scanner.nextInt();
        scanner.nextLine();
        banco.getList().get(opcion-1).getCuenta().get(cuenta-1).retirarDinero(dinero);
    
    }
    public static int NumerosDeCuentaRandom(){
        Random random=new Random();
        int numero=random.nextInt(0,999999999);
        return numero;
    }
}
