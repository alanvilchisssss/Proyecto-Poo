package cliente;

import cuentas.*;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Cliente {
    public int numeroDeCuenta;
    int[] fechaDeNacimiento = new int[3];
    double saldodeAhorro;
    String nombre;
    String apellido;
    String direccion;
    String telefono;
    String correo;
    //LinkedList<Double>[] tarjetas; // ???

    private final LinkedList<CuentaDeAhorro> cuentasDeAhorros = new LinkedList<>();
    private final LinkedList<CuentaDeInversion> cuentasDeInversion = new LinkedList<>();


    public static Cliente cliente(){
        Random random = new Random();
        int numeroDeCuenta=random.nextInt(500);
        return new Cliente();
    }

    public void abrirCuentaDeAhorro(double saldo){
        cuentasDeAhorros.add(new CuentaDeAhorro(saldo));
    }

    public void abrirCuentaDeInversion(CuentaDeAhorro cuentaDeAhorro){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el dinero a invertir: ");
        double inversion = sc.nextDouble();

        if(cuentaDeAhorro.getSaldo()<inversion) {
            System.out.println("La cuenta de ahorros especificada no tiene los fondos necesarios");
            return;
        }

        System.out.println("Ingrese el rendimiento en porcentaje: ");
        int rendimiento = sc.nextInt();

        System.out.println();
        System.out.println("1.- Plazo de inversion en segundos");
        System.out.println("Otro.- Plazo de inversion en minutos");

        boolean isInSeconds = (sc.nextInt() == 1);

        System.out.println("Ingrese el plazo de inversion: ");
        int plazo = sc.nextInt();

        cuentasDeInversion.add(new CuentaDeInversion(cuentaDeAhorro.retirarDinero(inversion), rendimiento, plazo, isInSeconds));
    }

    public void retirarInversion(CuentaDeInversion cuentaDeInversion){
        Scanner sc = new Scanner(System.in);
        String numeroDeCuenta;
        int aux;
        int depth = 0;

        do {
            System.out.println("¿A qué cuenta de ahorro desea transferir la inversion?");
            numeroDeCuenta = sc.nextLine();
            aux = buscarIndiceDeLaCuenta(numeroDeCuenta);


            if(depth > 1) {
                System.out.println("1.- Imprimir numeros de cuenta del cliente");
                System.out.println("Otro.- Reintentar ingresar ");
                if(sc.nextInt()==1)
                    imprimirNumerosDeCuenta();
            }


            depth++;
        } while (aux == -1);

        cuentaDeInversion.obtenerInversion(cuentasDeAhorros.get(aux));
        cuentasDeInversion.remove(cuentaDeInversion);
    }

    private int buscarIndiceDeLaCuenta(String numeroDeCuenta) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < cuentasDeAhorros.size(); i++) {
            if (cuentasDeAhorros.get(i).getNumeroDeCuenta().equals(numeroDeCuenta))
                return i;
        }

        System.out.println("La cuenta con ese número de cuenta no existe");
        return -1;
    }

    private void imprimirNumerosDeCuenta(){
        for (int i = 0; i < cuentasDeAhorros.size(); i++) {
            System.out.println("Indice "+i+". Número de cuenta: "+cuentasDeAhorros.get(i).getNumeroDeCuenta());
        }
    }

}

