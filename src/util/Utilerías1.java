package util;

import java.util.Scanner;
import java.util.Hashtable;


import bancario.*;

public class Utilerías1 {
    public static void MenuAccesoBanco(Scanner scanner, Banco banco){
        int opcion=0;
        while(true){
            System.out.println("Opciones del sistema:");
            System.out.println("1.-Crear nuevo cliente con nueva cuenta afiliada.");//Le tenemos que preguntar al usuario que tipo de cuenta. 
            System.out.println("2.- Ingresar dinero a la cuenta principal.");
            System.out.println("3.- Retirar dinero de la cuenta principal.");
            System.out.println("4.- Agregar alguna tarjeta de crédito.");
            System.out.println("5.- Datos de clientes actuales");
            System.out.println("6.- Agregar una nueva cuenta bancaria a algún usuario.");
            System.out.println("7.- Modificar algún dato del usuario");
            System.out.println("8.- Obtener el retorno de la cuenta de inversion");
            System.out.println("9.- Salir.");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch(opcion){
                case 1->{
                    Cliente.IngreseDeDatos(scanner, banco);
                }
                case 2->{
                    CuentaDeAhorro.Agregardinero(banco, scanner);
                }
                case 3->{
                    CuentaDeAhorro.RetirarDinero(banco, scanner);
                }   
                case 4->{
                    //Tiene que ser algo como lo del banco.agregarCliente()
                    //en la clase de las tarjetas de crédito agrega un método para poder agregar a una lista la tarjeta de crédito
                }
                case 5->{
                    int opcionn=0;
                    System.out.println("¿Desea imprimir 1)todos los clientes o 2)alguno en específico? 3)Imprimir cliente y datos de cuentas bancarias.");
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
                case 6->{
                    if(banco.getList().isEmpty()){
                        System.out.println("La lista está vacía");
                    }else{
                        CuentaDeAhorro.TiposDeCuentas(scanner, banco.getList());
                    }
                }
                case 7->{
                    if(banco.getList().isEmpty()){
                        System.out.println("La lista está vacía");
                    }else{
                        Banco.ModificarAlgunDato(banco.getList(), scanner);
                    }
                }
                case 8->{
                    CuentaDeAhorro.obtenerRetornoDeInversion(banco, scanner);
                }

                case 9->{
                    //Salida del programa.
                    System.out.println("Salida del sistema Bancario.");
                    System.exit(0);
                }


                default-> System.out.println("Ingrese una opción correcta.");
            }
        }
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
