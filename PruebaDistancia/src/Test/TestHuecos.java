package Test;

import Archivo.Archivo;
import Huecos.GAP;
import java.io.IOException;

public class TestHuecos {

    public static void main(String[] args) throws IOException {
        Archivo ar=new Archivo();
        String path="src/Numeros C#/0.txt";
        //int[] x = ar.numeros(path);
        int[] x={2,9,3,1,6,3,0,4,6,3,2,8,7,0,8,1,3,1,8,3,6,0,7,9,6,1,3,4,8,6,3,4,9,1,4,2,8,1,0,5,5,9,2,3,1,4,0,5,8,8,9,8,3,9,9,3,3,5,9,1,1,5,3,6,8,4,7,7,9,6,0,4,0,6,0,5,8,3,1,5,9,5,4,0,1,4,6,0,0,5,4,6,2,4,8,4,2,0,5,4,4,1,0,2,0,5,4,1,3,7,5,3,3,1,6,7,1,0,2,9,6,7,0,1,7};
        GAP g=new GAP();
        int[] o = g.ocurrencia(x, x.length);
        double[] f = g.frecuenciaAcumulada(x, x.length);
        int[][] v = new GAP().intervalosOcurrencia(x.length);
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + " - " + v[i][j + 1]+"    ");
                break;
            }
            System.out.println(f[i]);
        }
    }
}