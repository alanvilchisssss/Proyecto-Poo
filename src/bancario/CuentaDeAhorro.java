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
                ListaCliente.get(index-1).AgregarCuenta(cuenta);
            }
            case 2-> {
                System.out.println("¿A que cliente desea abrirle una cuenta de inversion?(Ingrese un índice)");
                Banco.ImprimirClientes(ListaCliente);
                int index = scanner.nextInt();

                if (ListaCliente.get(index - 1).getCuentaAhorro() == null)
                    System.out.println("Error, el cliente no tiene cuenta de ahorro");
                else if(ListaCliente.get(index - 1).getCuentaAhorro().getSaldo()<saldo)
                    System.out.println("Error, el cliente no tiene fondos suficientes");
                else{
                    System.out.println("******************************************************");
                    System.out.println("Seleccione un plazo de inversion");
                    System.out.println("1.- Inversion a corto plazo (10 segundos). Retorno 5%");
                    System.out.println("2.- Inversion a medio plazo (30 segundos). Retorno 10%");
                    System.out.println("3.- Inversion a largo plazo (60 segundos). Retorno 15%");
                    switch(scanner.nextInt()){
                        case 1->{ListaCliente.get(index - 1).setCuentaDeInversion(new CuentaDeInversion(ListaCliente.get(index - 1).getCuentaAhorro().retirarDinero(saldo), 5, 10));}
                        case 2->{ListaCliente.get(index - 1).setCuentaDeInversion(new CuentaDeInversion(ListaCliente.get(index - 1).getCuentaAhorro().retirarDinero(saldo), 10, 30));}
                        case 3->{ListaCliente.get(index - 1).setCuentaDeInversion(new CuentaDeInversion(ListaCliente.get(index - 1).getCuentaAhorro().retirarDinero(saldo), 15, 60));}
                    }
                }
            }
        }
    }


    public static void Agregardinero(Banco banco, Scanner scanner){
        Banco.ImprimirClienteYCuentaConAtributos(banco.getList());
        System.out.println("de que usuario desea agregar dinero?");
        int opcion=0;
        opcion=scanner.nextInt();
        System.out.println("Cuánto dinero desea agregar?");
        double dinero=0;
        dinero=scanner.nextDouble();
        banco.getList().get(opcion-1).getCuentaAhorro().ingresarDinero(dinero);
    }

    public static void obtenerRetornoDeInversion(Banco banco, Scanner scanner){
        Banco.ImprimirClienteYCuentaConAtributos(banco.getList());
        System.out.println("de que usuario desea obtener el retorno de su inversion?");
        int opcion=0;
        opcion=scanner.nextInt();

        if(banco.getList().get(opcion-1).getCuentaInversion() == null){
            System.out.println("Error, el cliente no tiene inversion");
            return;
        }

        banco.getList().get(opcion-1).getCuentaAhorro().ingresarDinero(banco.getList().get(opcion-1).getCuentaInversion().obtenerInversion());
        banco.getList().get(opcion-1).setCuentaDeInversion(new CuentaDeInversion(0,0,0));
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
        banco.getList().get(opcion-1).getCuentaAhorro().retirarDinero(dinero);
    }


    public static int NumerosDeCuentaRandom(){
        Random random=new Random();
        int numero=random.nextInt(0,999999999);
        return numero;
    }
}
