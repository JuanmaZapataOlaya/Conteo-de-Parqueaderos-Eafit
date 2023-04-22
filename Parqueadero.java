import java.util.Scanner;

public class Parqueadero{
    
    public static int procesoCeldas(int parqueaderos){
        
        System.out.println("¿ Cuantos parqueaderos hay disponibles ?");
        Scanner parqueo = new Scanner(System.in);
        int parqueoint = parqueo.nextInt();
        
        parqueaderos = parqueaderos+parqueoint;
        Salida.salidaCeldas(parqueaderos);
        return parqueaderos;
        
        
    }
}