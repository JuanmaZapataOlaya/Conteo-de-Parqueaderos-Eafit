import java.util.Scanner;
public class Entrada{
    static String stringUsuario;
    static String placaString;
    public static String entradaUsuario(){
        System.out.println("Ingrese su T.I o C.C");
        Scanner Usuario = new Scanner(System.in);
        stringUsuario = Usuario.nextLine();
        System.out.println(stringUsuario);
        if (stringUsuario.length() == 0){
            System.out.println("Ingresaste un documento inválido, automáticamente se usará el documento 0000000000");
            stringUsuario = "0000000000";
        }
        return (stringUsuario);
    }
    
    public static char entradaVehiculo(){
        System.out.println("Ingrese la placa del vehiculo");
        Scanner Placa = new Scanner(System.in);
        placaString = Placa.nextLine();
        char lastPlaca = '0';
        if (placaString.length() < 5){ //Arregla que pongan una placa no valida
            System.out.println("La placa ingresada no es válida, se continuará asignando automáticamente la placa AAA000");
        }
        else{
            lastPlaca = placaString.charAt(5);
        }
        
        System.out.println(lastPlaca);
        
        return (lastPlaca);
    }
    
    public static String entradaDia(){
        System.out.println("Ingrese el día de la semana: ");
        Scanner SemanaDia = new Scanner(System.in);
        String Dia = SemanaDia.nextLine();
        
        return (Dia);
    }
    
    public static boolean discapacitado(){
        System.out.println("¿Posees una discapacidad? Si/No");
        Scanner disc = new Scanner(System.in);
        String discString = disc.nextLine();
        System.out.println(discString);
        
        if(discString.equalsIgnoreCase("si")||discString.equalsIgnoreCase("yes")){
            return true;
        }
        return false;
    }
}
