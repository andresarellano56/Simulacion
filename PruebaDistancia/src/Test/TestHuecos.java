package Test;

import Archivo.Archivo;
import Huecos.GAP;
import java.io.IOException;

public class TestHuecos {

    public static void main(String[] args) throws IOException {
        Archivo ar=new Archivo();
        String path="src/Numeros C#/0.txt";
        int[] x = ar.numeros(path);
        int[] k = new GAP().digitosUnicos(x);
        for(int i: k)System.out.println(i);
        
        for(int i: x)System.out.println("*** " + i);
        
       System.out.println("* " + new GAP().numeroHuecos(x.length));
        System.out.println("- " + new GAP().numeroHuecos(x));
        System.out.println(new GAP().longitudHuecos(x.length));
        
        int[][] v = new GAP().intervalosOcurrencia(x.length);
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.println(v[i][j] + " - " + v[i][j + 1]);
                break;
            }
        }
        
        GAP g=new GAP();
        int[] o = g.ocurrencia(x, x.length);
        System.out.println("Pasa la prueba: ");
        for(int m: o) System.out.println(m);
    }
    
    
    
}
