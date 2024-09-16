import java.util.LinkedList;
import java.util.Scanner;
import java.util.Hashtable;
public class Utilerías1 {
    public static void MenuAccesoBanco(Scanner scanner){
        Banco banco=new Banco();
        int opcion=0;
        do{
            System.out.println("Opciones del sistema:");
            System.out.println("1.-Crear Nueva Cuenta afiliada al cliente.");//Le tenemos que preguntar al usuario que tipo de cuenta. 
            System.out.println("2.- Ingresar dinero a la cuenta principal.");
            System.out.println("3.- Retirar dinero de la cuenta principal.");
            System.out.println("4.- Agregar un nuevo cliente al banco PumaDolarFI");
            System.out.println("5.- Agregar alguna tarjeta de crédito.");
            System.out.println("6.-Datos de clientes actuales");
            System.out.println("7.- Salir.");
            System.out.println("Para acceder a la opción escriba en minúsculas la opción.");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch(opcion){
                case 1->{

                }
                case 2->{

                }
                case 3->{

                }
                case 4->{
                    Cliente.IngreseDeDatos(scanner, banco);
                }
                case 5->{

                }
                case 6->{
                    Banco.ImprimirClientes(banco.getList());
                }
                case 7->{
                    //Salida del programa.
                    System.out.println("Salida del sistema Bancario.");
                    System.exit(0);
                }
                default-> System.out.println("Ingrese una opción correcta.");
            }
        }while(opcion!=7);
    }
    public static void InicioSesión(Scanner scanner){
        //La parte de los admins se puede hacer con una hashtable
        int contador=0;
        Hashtable<String,String> CuentasAdministradores=new Hashtable<String, String>();
        CuentasAdministradores.put("alanvilchis","1");
        CuentasAdministradores.put("alexander","69");
        CuentasAdministradores.put("Brandon","1234");
        do{
        System.out.println("Bienvenido al Sistema Bancario PumaDolarFI");
            System.out.println("Ingrese su correo:");
            String correo=scanner.nextLine();
            scanner.nextLine();
            System.out.println("Ingrese su contraseña:");
            String Contraseña=scanner.nextLine();
            scanner.nextLine();
            if((CuentasAdministradores.containsKey(correo))&&(CuentasAdministradores.containsValue(Contraseña))){
                System.out.println("Bienvenido Administrador.");
                MenuAccesoBanco(scanner);
            }else{
                System.out.println("Cuenta incorrecta");
                contador++;
            }
        }while(contador<4);
        if(contador==3){
            System.out.println("Sistema Bloqueado.");
        }
    }
    public static LinkedList<Double> crearTarjetaDeDebito(){
        return new LinkedList<>();
    }

}//termina utilerías
