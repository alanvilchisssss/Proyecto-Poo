package bancario;

import java.time.LocalTime;

public class CuentaDeInversion {
    private final double retornoDeInversion;
    private final double saldo;
    private final int rendimiento;
    private final LocalTime fechaDeSalida;
    private final int plazo;

    public CuentaDeInversion(double saldo, int rendimiento, int plazo) {//constructor, si el valor del boolean es true, el plazo es en segundo, de lo contrario en minutos
        this.plazo = plazo;
        this.fechaDeSalida = LocalTime.now().plusSeconds(plazo);
        this.saldo = saldo;
        this.rendimiento = rendimiento;
        this.retornoDeInversion = (this.rendimiento * saldo) / 100; //entre 100 porque se da el rendimiento en porcentaje
    }

    //getters

    public double getDineroInvertido() {
        return this.saldo;
    }

    public int getRendimiento() {
        return this.rendimiento;
    }

    public int getPlazo(){return this.plazo;}

    //metodos
    public double obtenerInversion() {
        if (this.fechaDeSalida.isBefore(LocalTime.now()))
            return (this.retornoDeInversion + this.saldo);
        else
            System.out.println("No se ha cumplido el plazo de inversión");

        return 0;
    }

}
