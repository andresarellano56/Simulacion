package Test;

import Archivo.Archivo;
import Huecos.GAP;
import java.io.IOException;

public class TestHuecos {

    public static void main(String[] args) throws IOException {
        Archivo ar=new Archivo();
        String path="src/Numeros Python/3.txt";
        int[] x = ar.numeros(path);
        /*int[] x={2,9,3,1,6,3,0,4,6,3,2,8,7,0,8,1,3,1,8,3,6,0,7,9,6,1,3,4,8,6,
            3,4,9,1,4,2,8,1,0,5,5,9,2,3,1,4,0,5,8,8,9,8,3,9,9,3,3,5,9,1,1,5,3,
            6,8,4,7,7,9,6,0,4,0,6,0,5,7,3,1,5,9,5,4,0,1,4,6,0,0,5,4,6,2,4,8,4,
            2,0,5,4,4,1,0,2,0,5,4,1,3,7,5,3,3,1,6,7,1,0,2,9,6,7,0,1,7};*/
        GAP g = new GAP();
        g.proceso(x);
        
        System.out.println("LONGITUD        FRECUENCIA      FRECUENCIA AC       Fx(x)       DIFERENCIA");
        
        for (int i = 0; i < g.intervalos.length; i++) {
            for (int j = 0; j < g.intervalos[i].length; j++) {
                System.out.print(g.intervalos[i][j] + " - " + g.intervalos[i][j + 1]+"              ");
                break;
            }
            System.out.println(g.frecuencia[i]+"                "+g.fe[i]+"            "+g.fo[i]+"         "+g.diferencia[i]);
        }
        
        System.out.println("PASA LA PRUEBA: "+g.pasaPrueba(x));
    }
}