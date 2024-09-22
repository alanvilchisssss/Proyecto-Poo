package util;

import java.util.Scanner;
import java.util.Hashtable;

import bancario.*;

public class Utilerías1 {
    public static void MenuAccesoBanco(Scanner scanner, Banco banco){
        int opcion=0;
        do{
            System.out.println("Opciones del sistema:");
            //Movimientos con el usuario
            System.out.println("1.-Operaciones de Usuario.");
            //movimientos de la cuenta bancaria
            System.out.println("2.-Movimientos de las cuentas.");
            //movimientos con la tarjeta de crédito
            System.out.println("3.-Movimientos con tarjetas de crédito.");

            System.out.println("4.- Salir.");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch(opcion){
                case 1->{
                    int case1=0;
                    do{
                        System.out.println("Seleccione una opción:");
                        System.out.println("1.-Crear nuevo cliente con nueva cuenta de ahorro afiliada.");//Le tenemos que preguntar al usuario que tipo de cuenta. 
                        System.out.println("2.- Modificar algún dato del usuario");
                        System.out.println("3.- Datos de clientes actuales");
                        System.out.println("4.-Salir.");
                        case1=scanner.nextInt();
                        scanner.nextLine();
                        switch(case1){
                            case 1->{
                                Cliente.IngreseDeDatos(scanner, banco);
                            }
                            case 2->{
                                if(banco.getList().isEmpty()){
                                    System.out.println("La lista está vacía");
                                }else{
                                    Banco.ModificarAlgunDato(banco.getList(), scanner);
                                }
                            }
                            case 3->{
                                int opcionn=0;
                                System.out.println("¿Desea imprimir 1)todos los clientes o 2)alguno en específico o 3)Imprimir cliente y datos de cuentas bancarias?.");
                                opcionn=scanner.nextInt();
                                scanner.nextLine();
                                    switch (opcionn) {
                                        case 1->{
                                            Banco.ImprimirClientes(banco.getList());
                                        }
                                        case 2->{
                                            Banco.ImprimirSoloCliente(banco.getList(), scanner);
                                        }
                                        case 3->{
                                            Banco.ImprimirClienteYCuentaConAtributos(banco.getList());
                                        }
                                        default->System.out.println("Ingrese una opción correcta");
                                    }
                            }
                            default->System.out.println("...saliendo al menú principal.");
                        }
                    }while(case1!=4);
                }
                case 2->{
                    int case2=0;
                    do{
                        System.out.println("Seleccione alguna opción:");
                        System.out.println("1.- Agregar una nueva cuenta de ahorro a algún usuario.");
                        System.out.println("2.- Obtener el rendimiento de la cuenta de inversion");
                        System.out.println("3- Ingresar dinero a la cuenta principal.");
                        System.out.println("4.- Retirar dinero de la cuenta principal.");
                        System.out.println("5.- Salir");
                        case2=scanner.nextInt();
                        scanner.nextLine();
                        switch(case2){
                            case 1->{
                                CuentaDeAhorro.CreaciónCuentaDeInversión(scanner, banco.getList());
                            }
                            case 2->{
                                CuentaDeAhorro.obtenerRetornoDeInversion(banco, scanner);
                            }
                            case 3->{
                                CuentaDeAhorro.Agregardinero(banco, scanner);
                            }
                            case 4->{
                                CuentaDeAhorro.RetirarDinero(banco, scanner);
                            }
                            case 5->{
                                System.out.println("...regresando al menú principal.");
                            }
                            default->{
                                System.out.println("Error.");
                            }
                        }
                    }while(case2!=5);

                }
                case 3->{
                    int case3=0;
                    do{
                        System.out.println("Seleccione alguna opción:");
                        System.out.println("1.- Agregar alguna tarjeta de crédito.");
                        System.out.println("2.- Agregar gastos de tarjeta de credito.");
                        System.out.println("3.- Pago tardio de credito.");
                        System.out.println("4.- salida");
                        case3=scanner.nextInt();
                        scanner.nextLine();
                        switch(case3){
                            case 1->{
                                TarjetaDeCredito.AgregarTarjeta(banco, scanner);
                            }
                            case 2->{
                                TarjetaDeCredito.Gastos(banco, scanner);
                            }
                            case 3->{
                                TarjetaDeCredito.SimuladorDePagoTardío(banco, scanner);
                            }
                            case 4->{
                                System.out.println("...Saliendo");
                            }
                            default->System.out.println("Error");
                        }
                    }while(case3!=4);
                }
                case 4->{
                    System.out.println("Salida del sistema Bancario.");
                    System.exit(0);
                }
                default-> System.out.println("Ingrese una opción correcta.");
            }
        }while(opcion!=4);
    }


    public static void InicioSesión(Scanner scanner){
        Banco banco=new Banco();
        int contador=0;
        Hashtable<String,String> CuentasAdministradores=new Hashtable<String, String>();
        CuentasAdministradores.put("alanvilchis","1");
        CuentasAdministradores.put("alexander","69");
        CuentasAdministradores.put("Brandon","1234");
        CuentasAdministradores.put("Profesor","Poo");
        do{
        System.out.println("Bienvenido al Sistema Bancario "+banco.getnombre());
            System.out.println("Ingrese su correo:");
            String correo=scanner.nextLine();
            System.out.println("Ingrese su contraseña:");
            String Contraseña=scanner.nextLine();
            if((CuentasAdministradores.containsKey(correo))&&(CuentasAdministradores.containsValue(Contraseña))){
                System.out.println("Bienvenido Administrador.");
                MenuAccesoBanco(scanner,banco);
            }else{
                System.out.println("Cuenta incorrecta");
                contador++;
            }
        }while(contador<4);
        if(contador==4){
            System.out.println("Sistema Bloqueado.");
        }
    }
}//termina utilerías
