public class Salida{
    
    public static void imprimir_Saldo(int saldo){ //Para el proceso de asignar saldo nuevo
        
        System.out.println("Su nuevo saldo es: "+saldo);
        if (saldo != 0){
            System.out.println("Le alcanza para parquear "+(saldo/6000)+" veces");
        }
    }
    
    public static void imprimir_Parqueaderos_Disponibles(int parqueaderos){
        System.out.println("El numero de parqueaderos totales en las diferentes zonas de Eafit que se encuentran disponibles son :"+parqueaderos);
    }
    
    public static String tickete_concatenado(int NParque, char Zona){
        String ProcesamientoTickete = ("Su parqueadero es el: "+NParque+Zona);
        
        
        return ProcesamientoTickete;
    }
}