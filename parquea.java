import java.util.Scanner;
import java.util.Random;

public class Main
{
    public static void main(String[] args){
        
        int saldo = 0;
        int parqueaderos_libres = 0;
        
        System.out.println("Ingrese su T.I o C.C");
        Scanner Usuario = new Scanner(System.in);
        String StringUsuario = Usuario.nextLine();
        System.out.println(StringUsuario);
        
        System.out.println("Ingrese la placa del vehiculo");
        Scanner Placa = new Scanner(System.in);
        String PlacaString = Placa.nextLine();
        char lastPlaca = PlacaString.charAt(5);
        System.out.println(lastPlaca);
        
        System.out.println("Ingrese el dia de la semana: ");
        Scanner SemanaDia = new Scanner(System.in);
        String Dia = SemanaDia.nextLine();
        boolean Picoyplaca = false;
        
        String Lunes = "lunes";
        String Martes = "Martes";
        String Miercoles = "Miercoles";
        String Jueves = "Jueves";
        String Viernes = "Viernes";
        
        // Este pico y placa es el de el dia 29 marzo de 2023
        if(Dia.equalsIgnoreCase(Lunes)){
            if ((lastPlaca=='6')||(lastPlaca=='9')){
                Picoyplaca = true;
            }
        }
        
        if(Dia.equalsIgnoreCase(Martes)){
            if ((lastPlaca=='5')||(lastPlaca=='7')){
                Picoyplaca = true;
            }
        }
        
        if(Dia.equalsIgnoreCase(Miercoles)){
            if ((lastPlaca=='1')||(lastPlaca=='4')){
                Picoyplaca = true;
            }
        }
        
        if(Dia.equalsIgnoreCase(Jueves)){
            if ((lastPlaca=='8')||(lastPlaca=='0')){
                Picoyplaca = true;
            }
        }
        
        if(Dia.equalsIgnoreCase(Viernes)){
            if ((lastPlaca=='3')||(lastPlaca=='2')){
                Picoyplaca = true;
            }
        }
        
        int nOpcion = 0;
        
        if (Picoyplaca == true){
            System.out.println("Lo sentimos pero tienes pico y placa, intentelo otro dia");
        }
        if (Picoyplaca==false){
            while (nOpcion<3){
                System.out.println("Precione: ");
                System.out.println("1. Para agregar saldo");
                System.out.println("2. Para Asignar parqueaderos disponibles");
                System.out.println("3. Para Parquear");
                System.out.println("4. Para detener la aplicación");
                
                
                
                Scanner Opcion = new Scanner(System.in);
                nOpcion = Opcion.nextInt();
                
                if (nOpcion == 1){
                    saldo = Proceso.agregar_Saldo(saldo);
                    
                }
                
                if (nOpcion == 2){
                    parqueaderos_libres = Proceso.agregar_Parqueaderos(parqueaderos_libres);
                }
                if (nOpcion == 3){
                    String Ticket = Proceso.parquear(saldo, parqueaderos_libres);
                    System.out.println(Ticket);
                }
            }
        }
    }
}
