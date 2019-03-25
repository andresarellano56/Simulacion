/*
   Intituto Tecnológico de León
   Simulación
   Integración de MonteCarlo: Caso 2.
*/
package Casos;

import Integrales.Funcion;

public class Caso2 {
    
    public double calcularTheta(int k, int op){
        double s = 0;
        double[] r, x;
        
        r = new double[k];
        x = new double[k];
        for (int i = 0; i < k; i++) {
            r[i] = rAleatorio();
            x[i] = xValor(r[i]);
            s = s + (1 / Math.pow(r[i], 2)) * new Funcion(x[i]).eleccion(op);
        }
        return ((double) 1 / k) * s;
    }
    
    public double rAleatorio(){
        return Math.random();
    }
    
    public double xValor(double r){
        return -1 + (1 / r);
    }
}
