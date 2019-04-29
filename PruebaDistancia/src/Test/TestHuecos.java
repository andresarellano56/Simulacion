package Test;

import Archivo.Archivo;
import Huecos.GAP;
import java.io.IOException;
import java.util.Scanner;

public class TestHuecos {

    public static void main(String[] args) throws IOException {
        String leng="";
        System.out.println("Escoja el lenguaje: ");
        System.out.println("1.- C++");
        System.out.println("2.- C#");
        System.out.println("3.- Python");
        System.out.println("4.- VB");
        System.out.println("5.- JAVA");
        System.out.println("6.- MMB");
        
        switch(new Scanner(System.in).nextInt()){
            case 1: leng="Numeros C++"; break;
            case 2: leng="Numeros C#"; break;
            case 3: leng="Numeros Python"; break;
            case 4: leng="Numeros VB"; break;
            case 5: leng="Numeros JAVA"; break;
            case 6: leng="Numeros MMB"; break;
            default: System.err.println("Opcion no valida"); break;
        }
        prueba(leng);
    }
    
    static void prueba(String lenguaje) throws IOException{
        int pasaPrueba= 0,noPasa= 0;
        for (int i = 0; i < 50; i++) {
            Archivo ar=new Archivo();
            GAP g = new GAP();
            String path="src/"+lenguaje +"/"+String.valueOf(i)+".txt";
                   
//            int[] x={2,9,3,1,6,3,0,4,6,3,2,8,7,0,8,1,3,1,8,3,6,0,7,9,6,1,3,4,8,6,
//                3,4,9,1,4,2,8,1,0,5,5,9,2,3,1,4,0,5,8,8,9,8,3,9,9,3,3,5,9,1,1,5,3,
//                6,8,4,7,7,9,6,0,4,0,6,0,5,7,3,1,5,9,5,4,0,1,4,6,0,0,5,4,6,2,4,8,4,
//                2,0,5,4,4,1,0,2,0,5,4,1,3,7,5,3,3,1,6,7,1,0,2,9,6,7,0,1,7};        
           int[] x = ar.numeros(path);
            
            g.proceso(x);
            System.out.println("LONGITUD        FRECUENCIA      FRECUENCIA AC       Fx(x)       DIFERENCIA");
 
            for (int k = 0; k < g.intervalos.length; k++) {
                for (int j = 0; j < g.intervalos[k].length; j++){
                    System.out.print(g.intervalos[k][j] + " - " + g.intervalos[k][1]+"              "); break;
                }
            System.out.println(g.frecuencia[k]+"                "+g.fe[k]+"            "+g.fo[k]+"         "+g.diferencia[k]);
        }

  

           boolean pasa = g.pasaPrueba(x);
           System.out.println("PASA LA PRUEBA: "+ pasa);
           if(pasa) pasaPrueba++; else noPasa++;
        }
        
        System.out.println("Pasan: "+pasaPrueba);
        System.out.println("No Pasan: "+noPasa);
    }
}