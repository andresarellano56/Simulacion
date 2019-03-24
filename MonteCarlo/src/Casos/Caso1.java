/*
    Intituto Tecnológico de León
    Simulación
    Integración de MonteCarlo: Caso 1.
*/
package Casos;

import Integrales.Funcion;

public class Caso1 {
    
    public double calcularTheta(double a, double b, int k, int op){
        double s = 0;
        double[] r, x;
        
        r = new double[k];
        x = new double[k];
        for (int i = 0; i < k; i++) {
            r[i] = rAleatorio();
            x[i] = xAleatorio(a, b, r[i]);
            s = s + new Funcion(x[i]).eleccion(op);
        }
        return (double)((b - a) / k) * s;
    }
    
    public double rAleatorio(){
        return Math.random();
    }
    
    public double xAleatorio(double a, double b, double r){
        return a + (b - a) * r;
    }
    
}
