/*
   Intituto Tecnológico de León
   Simulación
   Integración de MonteCarlo: Caso 2.
 */
package Casos;

import Integrales.Funcion;

public class Caso3 {
    
    public double calcularTheta(int k, int op){
        double s = 0;
        double[] r, x;
        
        r = new double[k];
        x = new double[k];
        for (int i = 0; i < k; i++) {
            r[i] = rAleatorio();
            x[i] = xValor(r[i]);
            s = s + (new Funcion(x[i]).eleccion(op) / denominador(r[i]));
        }
        return ((double) 1 / k) * s;
    }
    
    public double xValor(double r){
        return Math.log(r / (1 - r));
    }
    
    public double denominador(double r){
        return r * (1 - r);
    }
    
    public double rAleatorio(){
        return Math.random();
    }
    
}
