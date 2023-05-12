import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Persistencia{
    public static void guardarUsuario(String stringUsuario, char placa, boolean discapacidad){
        File f = new File("Archivos del Usuario.txt"); //Especifica que 'f' será la abreviación del archivo de texto
        FileWriter writer = null;
        PrintWriter pw = null;
        
        
        //Este código se encarga de crear el archivo
        if (!f.exists()){
            try{
                f.createNewFile();
            }
            catch(IOException exception){
                System.err.println("Error creando el archivo :c");
            }
        }
        try{
            writer = new FileWriter("Archivos del Usuario.txt",true);
            pw = new PrintWriter(writer);
            pw.println("======================================================================================================"+"\n");//Crea un separador para que no se confundan diferentes usuarios
            pw.println("ID usuario: " + stringUsuario + " Último dígito de placa: " + placa + " ¿Posee discapacidad? true o false: " + discapacidad);
        }
        catch(IOException exception){
            System.err.println("Error abriendo el archivo guardado :c");
        }
        finally{
            try{ //Esto intentará cerrar el archivo
                if (null != writer){
                    writer.close();
                }
            }
            catch(Exception e2){
                e2.printStackTrace();
            }
        }
    }
    
    public static void guardarCelda(String TicketeFinal){
        File f = new File("Archivos del Usuario.txt");
        FileWriter writer = null;
        PrintWriter pw = null;
        
        
        //Este código se encarga de crear el archivo
        if (!f.exists()){
            try{
                f.createNewFile();
            }
            catch(IOException exception){
                System.err.println("Error creando el archivo :c");
            }
        }
        try{
            writer = new FileWriter("Archivos del Usuario.txt",true);
            pw = new PrintWriter(writer);
            pw.println("Celda: " + TicketeFinal + "\n");
            pw.println("======================================================================================================"+"\n");
        }
        catch(IOException exception){
            System.err.println("Error abriendo el archivo guardado :c");
        }
        finally{
            try{ //Esto intentará cerrar el archivo
                if (null != writer){
                    writer.close();
                }
            }
            catch(Exception e2){
                e2.printStackTrace();
            }
        }
    }
    
    public static void guardarHora(String hora){
        File f = new File("Archivos del Usuario.txt");
        FileWriter writer = null;
        PrintWriter pw = null;
        
        
        //Este código se encarga de crear el archivo
        if (!f.exists()){
            try{
                f.createNewFile();
            }
            catch(IOException exception){
                System.err.println("Error creando el archivo :c");
            }
        }
        try{
            writer = new FileWriter("Archivos del Usuario.txt",true);
            pw = new PrintWriter(writer);
            pw.println("Hora asignada: "+ hora);
        }
        catch(IOException exception){
            System.err.println("Error abriendo el archivo guardado :c");
        }
        finally{
            try{ //Esto intentará cerrar el archivo
                if (null != writer){
                    writer.close();
                }
            }
            catch(Exception e2){
                e2.printStackTrace();
            }
        }
    }
    
    public static void guardarSaldo(int saldo){
        File f = new File("Archivos del Usuario.txt");
        FileWriter writer = null;
        PrintWriter pw = null;
        
        
        //Este código se encarga de crear el archivo
        if (!f.exists()){
            try{
                f.createNewFile();
            }
            catch(IOException exception){
                System.err.println("Error creando el archivo :c");
            }
        }
        try{
            writer = new FileWriter("Archivos del Usuario.txt",true);
            pw = new PrintWriter(writer);
            pw.println("Saldo: " + saldo);
        }
        catch(IOException exception){
            System.err.println("Error abriendo el archivo guardado :c");
        }
        finally{
            try{ //Esto intentará cerrar el archivo
                if (null != writer){
                    writer.close();
                }
            }
            catch(Exception e2){
                e2.printStackTrace();
            }
        }
    }
}
