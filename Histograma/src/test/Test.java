package test;

import ADT.Histograma;
import Persistencia.Archivo;

public class Test {

    public static void main(String[] args) {
        Test t = new Test();
        Histograma h = new Histograma();
        int[][] ic;
        int[] fc, x;
        
        x = t.conversion("muestra2");
        ic = h.intervalosClase(x);
        fc = h.frecuenciasClase(x);
        
        System.out.println(h.datoMax(x) + " -- " + h.datoMin(x));
        System.out.println(h.criterioSturges(x.length));
        System.out.println(h.amplitudClase(h.datoMax(x), h.datoMin(x), x.length));
        
        for (int i = 0; i < ic.length; i++) {
            System.out.println(ic[i][0] + " -- " + ic[i][1] + " -- " + fc[i]);
        }
        
    }
    
    public int[] conversion(String s){
        String[] sa;
        int[] ia;
        Archivo a;
        
        a = new Archivo();
        sa = a.readFile(s);
        ia = new int[sa.length];
        for (int i = 0; i < sa.length; i++) 
            ia[i] = Integer.parseInt(sa[i]);
        return ia;
    }
    
}
