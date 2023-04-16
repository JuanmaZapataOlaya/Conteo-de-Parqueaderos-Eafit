import java.util.Scanner;
import java.util.Random;
public class Proceso{
    
    public static void procesoPicoYPlaca(boolean Picoyplaca){
        
        if (Picoyplaca == true){
            System.out.println("Lo sentimos pero tienes pico y placa, intentelo otro dia");
        }
        
        if (Picoyplaca==false){
            int saldo = 0;
            int parqueaderos_libres = 0;
            int nOpcion = 0;
            while (nOpcion<3){
                
                System.out.println("Precione: ");
                System.out.println("1. Para agregar saldo");
                System.out.println("2. Para Asignar parqueaderos disponibles");
                System.out.println("3. Para Parquear");
                System.out.println("4. Para detener la aplicación");
                
                Scanner Opcion = new Scanner(System.in);
                nOpcion = Opcion.nextInt();
                
                
                
                if (nOpcion == 1){
                    saldo = Proceso.procesoSaldo(saldo);
                }
                
                if (nOpcion == 2){
                    parqueaderos_libres = Proceso.procesoCeldas(parqueaderos_libres);
                }
                
                if (nOpcion == 3){
                    String Ticket = Proceso.procesoParquear(saldo, parqueaderos_libres);
                    System.out.println(Ticket);
                }
            }
        }
    }
    
    public static boolean procesoPlaca(char ultimoDigito, String Dia){
        
        String Lunes = "lunes";
        String Martes = "Martes";
        String Miercoles = "Miercoles";
        String Jueves = "Jueves";
        String Viernes = "Viernes";
        // Este pico y placa es el de el dia 29 marzo de 2023
        
        if(Dia.equalsIgnoreCase(Lunes)){
            if((ultimoDigito=='6')||(ultimoDigito=='9')){
                return true;
            }
        }
            
        if(Dia.equalsIgnoreCase(Martes)){
            if ((ultimoDigito=='5')||(ultimoDigito=='7')){
                return true;
            }
        }
            
        if(Dia.equalsIgnoreCase(Miercoles)){
            if ((ultimoDigito=='1')||(ultimoDigito=='4')){
                return true;
            }
        }
            
        if(Dia.equalsIgnoreCase(Jueves)){
            if ((ultimoDigito=='8')||(ultimoDigito=='0')){
                return true;
            }
        }
            
        if(Dia.equalsIgnoreCase(Viernes)){
            if ((ultimoDigito=='3')||(ultimoDigito=='2')){
                return true;
            }
        }
        return false;
    }
    
    public static int procesoSaldo(int saldo){
        
        System.out.println("¿ Cuanto saldo desea agregar ?");
        Scanner saldonuevo = new Scanner(System.in);
        
        int saldoint = saldonuevo.nextInt();
        saldo = saldo+saldoint;
        Salida.salidaSaldo(saldo);
        return saldo;
    }
    
    public static int procesoCeldas(int parqueaderos){
        System.out.println("¿ Cuantos parqueaderos hay disponibles ?");
        Scanner parqueo = new Scanner(System.in);
        int parqueoint = parqueo.nextInt();
        
        parqueaderos = parqueaderos+parqueoint;
        Salida.salidaCeldas(parqueaderos);
        return parqueaderos;
    }
    
    public static String procesoParquear(int saldo, int parqueaderos_libres){
        
        int plata = saldo;
        int celdas = parqueaderos_libres;
        
        if ((plata>=6000)&&(celdas>0)){
                     
            Random rand = new Random();
            int Numeroparqueo = rand.nextInt(1000);
            char randomChar = (char) ('a' + 5);
            
            String TicketeFinal = Salida.salidaParqueo(Numeroparqueo, randomChar);
            
            return TicketeFinal;
         
        }else if (celdas<=0){
            return ("Lo sentimos, no hay parqueaderos disponibles por el momento");
        }else{
            return ("No tienes saldo suficiente");
        }
    }
    
}