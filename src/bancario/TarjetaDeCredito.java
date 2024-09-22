package bancario;

import util.RandNum;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;

public class TarjetaDeCredito {
    private final static HashSet<String> numOcupados = new HashSet<>();
    private final String numTarjeta;
    private final double saldoLimite;
    private final int interes = 15;
    private final LocalDateTime fechaDeCorte;
    private double saldoUsado;
    private double deuda;

    public TarjetaDeCredito(double saldoLimite, int fechaDeCorte) {//La fecha de corte se ingresa en segundos
        String aux;

        do{
            aux = RandNum.randNum(15, "4");
        }while(numOcupados.contains(aux));

        numOcupados.add(aux);
        this.numTarjeta = aux;
        this.saldoLimite = saldoLimite;
        this.fechaDeCorte = LocalDateTime.now().plusMonths(fechaDeCorte);
    }
    public  String getNumTarjeta(){
        return numTarjeta;
    }
    public double getSaldoLimite(){
        return saldoLimite;
    }
    public LocalDateTime getFechaDeCorte(){
        return fechaDeCorte;
    }
    public double getSaldoUsado(){
        return saldoUsado;
    }
    public void setSaldoUsado (double saldoUsado){
        this.saldoUsado+=saldoUsado;
        this.deuda+=saldoUsado;
    }
    public double getDeuda(){
        return deuda; 
    }
    public void pagoTardio(int dias){
        LocalDateTime pagoTarde=this.fechaDeCorte.plusDays(dias);
        long diferencia =ChronoUnit.DAYS.between(this.fechaDeCorte, pagoTarde);
        double intereses=this.saldoUsado*this.interes;
        this.deuda+=intereses*diferencia;
        System.out.println("La deuda total despues de los intereses es:" +this.deuda);
    }
    public void Restante(){
        double resta=this.saldoLimite-this.saldoUsado;
        if (resta>0){
            System.out.println("Aun le quedan " + resta +" hasta alcanzar el limite");

        }else{
            System.out.println("Ya alcanzo el limite");
        }
    }
    public void imprimirTarjeta(){
        System.out.println("El limite de credito es: "+this.saldoLimite);
        System.out.println("La fecha de corte es: " +this.fechaDeCorte);
        System.out.println("Su saldo Usado hasta ahora es: "+deuda);
    }
    public static void AgregarTarjeta(Banco banco, Scanner scanner){
        System.out.println("Ingrese el cliente al que le dara la Tarjeta de credito");
        Banco.ImprimirClientes(banco.getList());
        int cliente=scanner.nextInt();
        scanner.nextLine();
        Cliente.agregarCredito(banco.getList().get(cliente-1),scanner); 
    }
    public static void Gastos(Banco banco,Scanner scanner){
        int i=1;
        int j=1;
            for(int k=0; k<banco.getList().size()-1; k++){
                if(banco.getList().get(k).getListaTarjetas().size()==0){
                    System.out.println("No hay tarjetas de crédito disponibles.");
                }else{
                    for(Cliente cliente:banco.getList()){
                        j=1;
                        System.out.println("Cliente con numero de cuenta "+ i++ +" :");
                        for(TarjetaDeCredito tarjeta:cliente.getListaTarjetas()){
                            System.out.println("Tarjeta numero "+ j++ +" :");
                            tarjeta.imprimirTarjeta();
                        }
                        
                    }
                    System.out.println("Ingrese el numero de cliente:");
                    int cliente=scanner.nextInt();
                    System.out.println("Ingrese el numero de la tarjeta del cliente:");
                    int tarjeta=scanner.nextInt();
                    System.out.println("Ingrese la cantidad que gasto el cliente: ");
                    double dinero=scanner.nextDouble();
                    banco.getList().get(cliente-1).getListaTarjetas().get(tarjeta-1).setSaldoUsado(dinero);
                }
            }
        }
    public static void SimuladorDePagoTardío(Banco banco, Scanner scanner){
        int i=1;
        int j=1;
        for(Cliente cliente:banco.getList()){
            j=1;
            System.out.println("Cliente con numero de cuenta "+ i++ +" :");
            for(TarjetaDeCredito tarjeta:cliente.getListaTarjetas()){
                System.out.println("Tarjeta numero  "+ j++ +" :");
                tarjeta.imprimirTarjeta();
            }
        }
        System.out.println("Ingrese el numero de cliente:");
        int cliente=scanner.nextInt();
        System.out.println("Ingrese el numero de la tarjeta que  el cliente no ha pagdo:");
        int tarjeta=scanner.nextInt();
        System.out.println("Ingrese los dias de retraso:");
        int retraso=scanner.nextInt();
        banco.getList().get(cliente-1).getListaTarjetas().get(tarjeta-1).pagoTardio(retraso);
        System.out.println("Nos debe actualmente: "+ banco.getList().get(cliente-1).getListaTarjetas().get(tarjeta-1).getDeuda());
        }

}
