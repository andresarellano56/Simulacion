package Calculos;

public class TablaFrecuencias {
    double[][] clase;
    int[] frecuencia;
    
    public double rango(double max, double min){
        return max - min;
    }
    
    public double criterioSturges(double n){
        return 1 + 3.322 * Math.log10(n);
    }
    
    public double[][] intervalosClase(double max, double min, double n){
        int amplitud, limite;
        
        amplitud = (int) (rango(max, min) / criterioSturges(n));
        limite = (int) (n / amplitud);
        clase = new double[limite][2];
        for (int i = 0; i < limite; i++) {
            clase[i][0] = min;
            clase[i][1] = min + amplitud;
            min = clase[i][1] + 1;
        }
        return clase;
    }
    
    public int[] frecuenciasClase(double[] datos){
        int f = 0; 
        
        for (int i = 0; i < clase.length; i++) {
            for(double d: datos)
                if(d <= clase[i][0] && d >= clase[i][0]) f++;
            frecuencia[i] = f;
        }
        return frecuencia;
    }
}
