package bancario;

import util.RandNum;

import java.time.LocalTime;
import java.util.HashSet;

public class TarjetaDeCredito {
    private final static HashSet<String> numOcupados = new HashSet<>();
    private final String numTarjeta;
    private final double saldoLimite;
    private final int interes = 15;
    private final LocalTime fechaDeCorte;
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
        this.fechaDeCorte = LocalTime.now().plusSeconds(fechaDeCorte);
    }




}
