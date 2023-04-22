public class Salida{
    
    public static void salidaSaldo(int saldo){
        
        System.out.println("Su nuevo saldo es: "+saldo);
        if (saldo != 0){
            System.out.println("Le alcanza para parquear "+(saldo/6000)+" veces");
        }
    }
    
    public static void salidaCeldas(int parqueaderos){
        System.out.println("El numero de parqueaderos totales en las diferentes zonas de Eafit que se encuentran disponibles son :"+parqueaderos);
    }
    
    public static void salidaTipoCeldas(int[] tipos){
        
        System.out.println("El numero de celdas para carros a gasolina son: "+tipos[0]);
        System.out.println("El numero de celdas para motos son: "+tipos[1]);
        System.out.println("El numero de celdas para carros electricos son: "+tipos[2]);
    }
    
    public static String salidaParqueo(int NParque, char Zona){
        String ProcesamientoTickete = ("Su parqueadero es el: "+NParque+Zona);
        
        
        return ProcesamientoTickete;
    }
}