import java.util.Random;
public class Celdas{
    
    public static int[] tiposCeldas(int celdasLibres){
        
        int tiposParqueaderos[] = new int[3];
        
        Random rand = new Random();
        int carrosNormales = rand.nextInt(celdasLibres);
        
        int restante1 = celdasLibres-carrosNormales;
        
        int motos = rand.nextInt(restante1);
        
        int autosElectricos = restante1-motos;
        
        tiposParqueaderos[0] = carrosNormales;
        tiposParqueaderos[1] = motos;
        tiposParqueaderos[2] = autosElectricos;
        
        return tiposParqueaderos;
    }
}