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
    
    public double funcionCuatro(){
        return x / Math.pow(1 + Math.pow(x, 2), 2);
    }
    
    public double funcionCinco(){
        return Math.pow(Math.E, - Math.pow(x, 2));
    }
    
    public double funcionSeis(){
        return Math.pow(Math.E, - Math.pow(x, 2));
    }
    
    public double eleccion(int op){
        switch(op){
            case 1: return funcionUno();
            case 2: return funcionDos();
            case 3: return funcionTres();
            case 4: return funcionCuatro();
            case 5: return funcionCinco();
            case 6: return funcionSeis();
            default: return 0;
        }
    }
    
}
