package bancario;

import util.RandNum;

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



}
