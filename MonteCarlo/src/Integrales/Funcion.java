/*
    Intituto Tecnológico de León
    Simulación
    Integración de MonteCarlo: Clase que contendrá las integrales de ejemplo
 */
package Integrales;

public class Funcion {
    double x;
    
    public Funcion(double x){
        this.x = x;
    }
    
    public double funcionUno(){
        return Math.pow(Math.E, Math.pow(Math.E, x));
    }
    
    public double funcionDos(){
        return Math.pow((1 - Math.pow(x, 2)), (3 / 2));
    }
    
    public double funcionTres(){
        return Math.pow(Math.E, x + Math.pow(x, 2));
    }
    
    public double eleccion(int op){
        switch(op){
            case 1: return funcionUno();
            case 2: return funcionDos();
            case 3: return funcionTres();
            default: return 0;
        }
    }
    
}
