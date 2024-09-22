package bancario.registro;

import bancario.CuentaDeInversion;

import java.time.LocalTime;

public record RegistroInversion(LocalTime fechaDeInversion, CuentaDeInversion datos){}

