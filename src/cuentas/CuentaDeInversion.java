package cuentas;

import java.util.HashSet;
import java.time.LocalTime;

import utils.RandNum;

public class CuentaDeInversion {
    private final static HashSet<String> numeroDeCuentaSet = new HashSet<String>();
    private final String numeroDeCuenta;
    private final double retornoDeInversion;
    private final double saldo;
    private final int rendimiento;
    private final LocalTime fechaDeSalida;

    public CuentaDeInversion(double saldo, int rendimiento, int plazo, boolean isInSegundos) {//constructor, si el valor del boolean es true, el plazo es en segundo, de lo contrario en minutos
        String aux;

        while (true) {
            aux = RandNum.randNum(8, "2");

            if (!numeroDeCuentaSet.contains(aux)) {
                numeroDeCuentaSet.add(aux);
                break;
            }
        }

        if (isInSegundos)
            this.fechaDeSalida = LocalTime.now().plusSeconds(plazo);
        else
            this.fechaDeSalida = LocalTime.now().plusMinutes(plazo);

        this.saldo = saldo;
        this.rendimiento = rendimiento;
        this.retornoDeInversion = (this.rendimiento * saldo) / 100; //entre 100 porque se da el rendimiento en porcentaje
        this.numeroDeCuenta = aux;

    }


    //getters
    public String getNumeroDeCuenta() {
        return this.numeroDeCuenta;
    }

    public double getDineroInvertido() {
        return this.saldo;
    }

    public int getRendimiento() {
        return this.rendimiento;
    }

    //metodos
    public void obtenerInversion(CuentaDeAhorro cuenta) {
        if (this.fechaDeSalida.isBefore(LocalTime.now()))
            cuenta.ingresarDinero(this.retornoDeInversion + this.saldo);
        else
            System.out.println("No se ha cumplido el plazo de inversión");
    }

}
