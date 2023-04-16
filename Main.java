import java.util.Scanner;
import java.util.Random;

public class Main
{
    public static void main(String[] args){
        
        int saldo = 0;
        int parqueaderos_libres = 0;
        
        String usuario = Entrada.entradaUsuario();
        
        char placa = Entrada.entradaVehiculo();
        
        String dia = Entrada.entradaDia();
        
        boolean picoyplaca = Proceso.procesoPlaca(placa,dia);
        
        Proceso.procesoPicoYPlaca(picoyplaca);

    }
}
        

