import java.util.LinkedList;
import java.util.Scanner;
import java.util.LinkedList;
public class Utilerías1 {
    public static void MenuPrincipal(Scanner scanner){
        MenuAccesoBanco(scanner);
    }
    public static void MenuAccesoBanco(Scanner scanner){
        System.out.println("Bienvenido al Sistema Bancario PumaDolarFI");
        System.out.println("Opciones del sistema:");
        System.out.println("1.-Iniciar sesión.");
        System.out.println("2.- Crear nuevo usuario.");
        System.out.println("3.- Salir.");
        System.out.println("Para acceder a la opción escriba en minúsculas la opción.");
        String option = scanner.nextLine();
        scanner.nextLine();
        switch(option){
            case "iniciar sesión"->{
                //aquí va el método de iniciar sesión
                InicioSesión(scanner);
            }
            case "crear nuevo usuario"->{
                //aquí va el método de Crear un nuevo usuario
            }
            case "salir"->{
                //Salida del programa.
                System.exit(0);
            }
        }
    }
    public static void InicioSesión(Scanner scanner){
        //La parte de los admins se puede hacer con una hashtable
        String CorreoAdmin="alanvilchis";
        double ContraseñaAdmin=1;
        String CorreoAdmin2="alexander";
        double Contraseñaadmin2=69;
        String CorreoAdmin3="Barandon";
        double ContraseñaAdmin3=1234;

        System.out.println("Ingrese su correo:");
        String correo=scanner.nextLine();
        scanner.nextLine();
        System.out.println("Ingrese su contraseña:");
        String Contraseña=scanner.nextLine();
        scanner.nextLine();
        if((correo.equals(CorreoAdmin))&&(Contraseña.equals(CorreoAdmin))){
            System.out.println("Bienvenido Administrador.");
        }else{
            System.out.println("Bienvenido Usuario.");
        }

    }
    public static LinkedList<Double> crearTarjetaDeDebito(){
        return new LinkedList<>();
    }

}//termina utilerías
