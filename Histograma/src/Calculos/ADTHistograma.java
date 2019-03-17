package Calculos;

public class ADTHistograma {
    int[][] intervaloClase;
    int[] limInf, frecuencia;
    
    public int rango(int max, int min){
        return max - min;
    }
    
    public int criterioSturges(double n){
        return (int)(1 + 3.322 * Math.log10(n));
    }
    
    public int amplitudClase(int max, int min, int n){
        return (int) (rango(max, min) / criterioSturges(n));
    }
    
    public int numeroClases(int max, int min, int n){
        return (int) (n / amplitudClase(max, min, n));
    }

    public int[][] intervalosClase(int[] datos){
        int amp, nc, max, min, n;
        
        max = datoMax(datos);
        min = datoMin(datos);
        n = datos.length;
        nc = numeroClases(max, min, n);
        amp = amplitudClase(max, min, n);
        intervaloClase = new int[nc][2];
        for (int i = 0; i < nc; i++) {
            intervaloClase[i][0] = min;
            intervaloClase[i][1] = min + amp;
            min = intervaloClase[i][1] + 1;
        }
        return intervaloClase;
    }
    
    public int[] frecuenciasClase(int[] datos){
        int f = 0; 
        
        frecuencia = new int[intervaloClase.length];
        for (int i = 0; i < intervaloClase.length; i++) {
            for(double d: datos)
                if(d <= intervaloClase[i][0] && d >= intervaloClase[i][0]) f++;
            frecuencia[i] = f;
        }
        return frecuencia;
    }
    
    public int datoMax(int[] datos){
        int aux = datos[0];
        
        for (int i = 0; i < datos.length; i++) 
           if(datos[i] > aux) aux = datos[i];
        return aux;
    }
    
    public int datoMin(int[] datos){
        int aux = datos[0];
        
        for (int i = 0; i < datos.length; i++) 
           if(datos[i] < aux) aux = datos[i];
        return aux;
    }
}