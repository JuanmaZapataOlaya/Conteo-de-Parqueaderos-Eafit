import java.util.Scanner;
import java.util.Random;
public class Proceso{ //Los valores que llegan vienen de la clase Main
    public static int agregar_Saldo(int saldo){
        
        System.out.println("¿ Cuanto saldo desea agregar ?");
        Scanner saldonuevo = new Scanner(System.in);
        int saldoint = saldonuevo.nextInt();
        saldo = saldo+saldoint;
        Salida.imprimir_Saldo(saldo);
        return saldo;
    }
    
    public static int agregar_Parqueaderos(int parqueaderos){
        System.out.println("¿ Cuantos parqueaderos hay disponibles ?");
        Scanner parqueo = new Scanner(System.in);
        int parqueoint = parqueo.nextInt();
        parqueaderos = parqueaderos+parqueoint;
        Salida.imprimir_Parqueaderos_Disponibles(parqueaderos);
        return parqueaderos;
    }
    
    public static String parquear(int saldo, int parqueaderos_libres){
        if ((saldo>=6000)&&(parqueaderos_libres>0)){
            saldo = saldo-6000;
            parqueaderos_libres = parqueaderos_libres-1;
                        
            Random rand = new Random();
            int Numeroparqueo = rand.nextInt(1000);
            char randomChar = (char) ('a' + 5);
            //Genera un espacio aleatorio de parqueo notado por un número y una letra
            String TicketeFinal = Salida.tickete_concatenado(Numeroparqueo, randomChar);
            return TicketeFinal;
            
                        
        }else if (parqueaderos_libres==0){
            return ("Lo sentimos, no hay parqueaderos disponibles por el momento");
        }else{
            return ("No tienes saldo suficiente");
        }
    }
    
}