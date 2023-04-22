import java.util.Scanner;
public class Entrada{
    static String stringUsuario;
    static String placaString;
    public static String entradaUsuario(){
        System.out.println("Ingrese su T.I o C.C");
        Scanner Usuario = new Scanner(System.in);
        stringUsuario = Usuario.nextLine();
        System.out.println(stringUsuario);
        
        return (stringUsuario);
    }
    
    public static char entradaVehiculo(){
        System.out.println("Ingrese la placa del vehiculo");
        Scanner Placa = new Scanner(System.in);
        placaString = Placa.nextLine();
        char lastPlaca = placaString.charAt(5);
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