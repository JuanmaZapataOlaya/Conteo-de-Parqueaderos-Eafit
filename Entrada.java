import java.util.Scanner;
public class Entrada{
    
    public static String entradaUsuario(){
        System.out.println("Ingrese su T.I o C.C");
        Scanner Usuario = new Scanner(System.in);
        String StringUsuario = Usuario.nextLine();
        System.out.println(StringUsuario);
        
        return (StringUsuario);
    }
    
    public static char entradaVehiculo(){
        System.out.println("Ingrese la placa del vehiculo");
        Scanner Placa = new Scanner(System.in);
        String PlacaString = Placa.nextLine();
        char lastPlaca = PlacaString.charAt(5);
        System.out.println(lastPlaca);
        
        return (lastPlaca);
    }
    
    public static String entradaDia(){
        System.out.println("Ingrese el dia de la semana: ");
        Scanner SemanaDia = new Scanner(System.in);
        String Dia = SemanaDia.nextLine();
        
        return (Dia);
    }
    
}