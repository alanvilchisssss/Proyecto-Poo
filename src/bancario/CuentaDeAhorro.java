package bancario;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    public static void CreaciónCuentaDeInversión(Scanner scanner,ArrayList<Cliente> ListaCliente){//este método se utiliza creando a un nuevo cliente, siguiendo la lógica de que si se va a crear un nuevo usuario del banco, también se debe de crear una cuenta
        System.out.println("¿Cuánto saldo desea ingresar en la cuenta de inversión?");
        double saldo=scanner.nextDouble();
        scanner.nextLine();
        if(saldo==0 || saldo<0){
            System.out.println("El saldo mínimo para abrir una cuenta es de 1 peso");
        }else{
                System.out.println("¿A que cliente desea abrirle una cuenta de inversion?(Ingrese un índice)");
                Banco.ImprimirClientes(ListaCliente);
                int index = scanner.nextInt();
                scanner.nextLine();
                    if(index-1>ListaCliente.size()){
                        System.out.println("El usuario no existe");
                    }else if (ListaCliente.get(index - 1).getCuentaAhorro() == null){
                        System.out.println("Error, el cliente no tiene cuenta de ahorro");
                    }else if(ListaCliente.get(index-1).getCuentaInversion()!=null){
                        System.out.println("No puede tener más de una cuenta de inversión en este banco.");
                    }else if(ListaCliente.get(index - 1).getCuentaAhorro().getSaldo()<saldo){
                        System.out.println("Error, el cliente no tiene fondos suficientes");
                    }
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
    public static void CreaciónCuentaAhorro(Scanner scanner,ArrayList<Cliente> ListaCliente){
        double saldo=0;
            do{
            System.out.println("¿Cuánto saldo desea ingresar en la cuenta?");
            saldo=scanner.nextDouble();
            scanner.nextLine();
                if(saldo>0){
                    CuentaDeAhorro cuenta=new CuentaDeAhorro(saldo);
                    ListaCliente.get(ListaCliente.size()-1).setCuenta(cuenta);
                }else if(saldo==0||saldo<0){
                    System.out.println("El monto mínimo para crear una cuenta bancaria es de 1 peso.");
                } 
            }while(saldo<0||saldo==0);
        }

    public static void Agregardinero(Banco banco, Scanner scanner){
        Banco.ImprimirClienteYCuentaConAtributos(banco.getList());
        System.out.println("de que usuario desea agregar dinero?");
        int opcion=0;
        opcion=scanner.nextInt();
            if(opcion-1>banco.getList().size()){
                System.out.println("El usuario no existe.");
            }else{
                LocalDateTime deposito= LocalDateTime.now();
                if(banco.getList().get(opcion-1).getFechasDeposito().isEmpty()){
                    System.out.println("El usario no ha recibido aun depositos");
                }else{
                    System.out.println("Fechas de depositos anteriores ");
                    for(LocalDateTime fecha: banco.getList().get(opcion-1).getFechasDeposito()){
                       System.out.println(fecha);
                    } 
                }
                banco.getList().get(opcion-1).ultimoDeposito(deposito);
                System.out.println("Cuánto dinero desea agregar?");
                double dinero=0;
                dinero=scanner.nextDouble();
                banco.getList().get(opcion-1).getCuentaAhorro().ingresarDinero(dinero);
            }
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
        if (banco.getList().get(opcion-1).getCuentaInversion().obtenerInversion() == 0)
            return;
            
        banco.getList().get(opcion-1).getCuentaAhorro().ingresarDinero(banco.getList().get(opcion-1).getCuentaInversion().obtenerInversion());
        banco.getList().get(opcion-1).setCuentaDeInversion(new CuentaDeInversion(0,0,0));
    }

    public static void RetirarDinero(Banco banco, Scanner scanner){
        Banco.ImprimirClienteYCuentaConAtributos(banco.getList());
        System.out.println("de que usuario desea agregar dinero?");
        int opcion=0;
        opcion=scanner.nextInt();
        scanner.nextLine();
            if(opcion-1>banco.getList().size()){
                System.out.println("El usuario no existe.");
            }else{
                LocalDateTime retiro= LocalDateTime.now();
                if(banco.getList().get(opcion-1).getFechasRetiro().isEmpty()){
                    System.out.println("El usario no ha hecho aun retiros");
                }else{
                    System.out.println("Fechas de retiros anteriores ");
                    for(LocalDateTime fecha: banco.getList().get(opcion-1).getFechasRetiro()){
                       System.out.println(fecha);
                    } 
                }
            banco.getList().get(opcion-1).ultimaRetiro(retiro);
            System.out.println("Cuánto dinero desea retirar de su cuenta?");
            int dinero=0;
            dinero=scanner.nextInt();
            scanner.nextLine();
            banco.getList().get(opcion-1).getCuentaAhorro().retirarDinero(dinero);
            }
    }
}
