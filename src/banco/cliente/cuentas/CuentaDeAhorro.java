package banco.cliente.cuentas;

import java.util.HashSet;

import utils.RandNum;

public class CuentaDeAhorro {
    private final static HashSet<String> numeroDeCuentaSet = new HashSet<String>();
    private final String numeroDeCuenta;
    private double saldo = 0;


    public CuentaDeAhorro(double saldo) { //constructor
        String aux;

        while(true) {
            aux = RandNum.randNum(8, "1");

            if(!numeroDeCuentaSet.contains(aux)){
                numeroDeCuentaSet.add(aux);
                break;
            }

        }

        this.numeroDeCuenta = aux;
        this.saldo = saldo;
    }



    //getters
    public String getNumeroDeCuenta(){
        return this.numeroDeCuenta;
    }

    public double getSaldo(){
        return this.saldo;
    }

    //setters
    public void setSaldo(double saldo){
        this.saldo=saldo;
    }

    //métodos
    public void ingresarDinero(double dinero){
        this.saldo += dinero;
    }

    public double retirarDinero(double retiro){
        if(retiro>this.saldo)
            System.out.println("Saldo insuficiente");
        else//retiro exitoso
            this.saldo-=retiro;

        return retiro;
    }

    public void realizarTransferencia(CuentaDeAhorro cuentaDestino, double dineroATransferir){
        if(this.saldo<dineroATransferir)
            System.out.println("Saldo insuficiente");
        else
            cuentaDestino.ingresarDinero(this.retirarDinero(dineroATransferir));
    }




    public static void TiposDeCuentas(Scanner scanner,ArrayList<banco.cliente.Cliente> ListaCliente){//este método se utiliza creando a un nuevo banco.cliente, siguiendo la lógica de que si se va a crear un nuevo usuario del banco, también se debe de crear una cuenta
        System.out.println("¿Que tipo de cuenta desea crear, 1)de ahorro o de 2)inversión?");
        int opcion=scanner.nextInt();
        scanner.nextLine();
        System.out.println("¿Cuánto saldo desea ingresar en la cuenta?");
        int saldo=scanner.nextInt();
        scanner.nextLine();
        switch(opcion){
            case 1->{
                CuentaDeAhorro cuenta=new CuentaDeAhorro(saldo);
                System.out.println("¿A que banco.cliente desea asociar esta cuenta?(Ingrese un índice)");
                banco.Banco.ImprimirClientes(ListaCliente);
                int index=scanner.nextInt();
                scanner.nextLine();
                ListaCliente.get(index-1).AgregarCuenta(cuenta);
            }
            case 2->{
                //aquí va el metodo para crear una cuenta de inversion
            }
        }
    }
    public static void Agregardinero(banco.Banco banco, Scanner scanner){
        banco.Banco.ImprimirClienteYCuentaConAtributos(banco.getList());
        System.out.println("de que usuario desea agregar dinero?");
        int opcion=0;
        opcion=scanner.nextInt();
        scanner.nextLine();
        System.out.println("De que cuenta bancaria?");
        int cuenta=0;
        cuenta=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Cuánto dinero desea agregar?");
        int dinero=0;
        dinero=scanner.nextInt();
        scanner.nextLine();
        banco.getList().get(opcion-1).getCuenta().get(cuenta-1).sumaDeDinero(dinero);
    }
    public static void RetirarDinero(banco.Banco banco, Scanner scanner){
        banco.Banco.ImprimirSoloCliente(banco.getList(), scanner);
        System.out.println("de que usuario desea agregar dinero?");
        int opcion=0;
        opcion=scanner.nextInt();
        scanner.nextLine();
        System.out.println("De que cuenta bancaria?");
        int cuenta=0;
        cuenta=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Cuánto dinero desea retirar de su cuenta?");
        int dinero=0;
        dinero=scanner.nextInt();
        scanner.nextLine();
        banco.getList().get(opcion-1).getCuenta().get(cuenta-1).retirarDinero(dinero);
    
    }
    public static int NumerosDeCuentaRandom(){
        Random random=new Random();
        int numero=random.nextInt(0,999999999);
        return numero;
    }
    */




}
