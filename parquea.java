
/**
 * Write a description of class parquea here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.Random; //Especificamente estas dos funciones en vez del * para no gastar tantos recursos.
public class parquea
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
        System.out.println(lastPlaca); //Mantenemos el último dígito con fin de documentar.
        
        int nOpcion = 0; //Se usa para definir cuál función se va a ejecutar
        
        while (nOpcion<3){ //menor a 3 asegura que el programa termine cuando el usuario parqueé
            System.out.println("Precione: ");
            System.out.println("1. Para agregar saldo");
            System.out.println("2. Para Asignar parqueaderos disponibles");
            System.out.println("3. Para Parquear");
            System.out.println("4. Para detener la aplicación");
            
            
            
            Scanner Opcion = new Scanner(System.in);
            nOpcion = Opcion.nextInt();
            
            if (nOpcion == 1){
                System.out.println("¿ Cuanto saldo desea agregar ?");
                Scanner saldonuevo = new Scanner(System.in);
                int saldoint = saldonuevo.nextInt();
                saldo = saldo+saldoint;
                System.out.println("Su saldo nuevo es de: "+saldo);
            }
            
            if (nOpcion == 2){
                System.out.println("¿ Cuantos parqueaderos hay disponibles ?");
                Scanner parqueo = new Scanner(System.in);
                int parqueoint = parqueo.nextInt();
                parqueaderos_libres = parqueaderos_libres+parqueoint;
                System.out.println("La cantidad de parqueaderos disponibles es: "+parqueaderos_libres);
            }
            if (nOpcion == 3){
                if ((saldo>=6000)&&(parqueaderos_libres>0)){
                    saldo = saldo-6000;
                    parqueaderos_libres = parqueaderos_libres-1;
                    
                    Random rand = new Random();
                    int Numeroparqueo = rand.nextInt(1000);
                    int randomNum = rand.nextInt(5);
                    char randomChar = (char) ('a' + randomNum);
                    
                    System.out.println("Su parqueadero es el: "+Numeroparqueo+randomChar);
                    System.out.println("Su saldo restante es: "+saldo);
                    
                }else if (parqueaderos_libres==0){
                    System.out.println("Lo sentimos, no hay parqueaderos disponibles por el momento");
                }else{
                    System.out.println("No tienes saldo suficiente");
                }
            }
        }
    }
}

