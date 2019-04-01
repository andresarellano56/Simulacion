/*
    Instituto Tecnológico de León
    Simulacion
    Equipo 5
    ------------------------------
    Clase GAP: contiene todos los métodos que sirven para asegurar que los
               numeros son realmente aleatorios.
 */
package Huecos;

import java.util.ArrayList;

public class GAP {
    public int[] nHuecos;
    public int[][] intervalos;
    public int[] frecuencia;
    public double[] fe;
    public double[] fo;
    public double[] diferencia;
    
    private int numeroHuecos(int n) {
        return n - 10;
    }

    private int numeroHuecos(int[] muestra) {
        int res = 0, c = 0;
        int[] unicos = digitosUnicos(muestra);

        for (int i = 0; i < unicos.length; i++) {
            for (int j = 0; j < muestra.length; j++) 
                if (unicos[i] == muestra[j]) c++;
            res = res + (c - 1);
            c = 0;
        }

        return res;
    }

    //Modificar
    private void intervalosOcurrencia() {
        int lh = longitudHuecos(huecoMayor())+1;
        int c = 0;
        intervalos = new int[lh][2];

        for (int i = 0; i < lh; i++) {
            if (i == 0) {
                intervalos[i][0] = 0;
                intervalos[i][1] = 2;
            } else {
                intervalos[i][0] = intervalos[i - 1][0] + 3;
                intervalos[i][1] = intervalos[i - 1][1] + 3;
            }
        }
    }

    private void ocurrencia(int[] muestra, int n) {
        int[] unico = digitosUnicos(muestra);
        nHuecos = new int[muestra.length];
        int c, r = 0;

        for (int i : nHuecos) i = 0;
        for (int i = 0; i < unico.length; i++) {
            for (int j = 0; j < muestra.length; j++) {
                c = 0;
                if (unico[i] == muestra[j]) {
                    do{
                       j++;
                       c++;
                       if(j == muestra.length){ 
                           c = -1; 
                           break; 
                       }
                    }while(unico[i] != muestra[j]);
                    j--; 
                    c--;
                    nHuecos[r] = c;
                    r++;
                }
            }
        }
    }
    
    private void frecuencias(){
        frecuencia = new int[intervalos.length];
        int suma=0;
        
        for(int h: nHuecos)
            for (int i = 0; i < intervalos.length; i++) 
                if(h >= intervalos[i][0] && h <= intervalos[i][1]){
                    frecuencia[i]++;
                    System.out.println(h);
                    break;
                }
        //System.out.println(suma);
    }
    
    private int huecoMayor(){
        for (int i = 0; i < nHuecos.length; i++) {
            for (int j = 0; j < nHuecos.length; j++) {
                if(nHuecos[i] > nHuecos[j]){
                    int aux = nHuecos[j];
                    nHuecos[j] = nHuecos[i];
                    nHuecos[i] = aux;
                }
            }
        }
        return nHuecos[0];
    }   
    
    private double singleRA(int oc, int n){
        return ((double) oc / n);
    }
    
    private double singleFAR(int n){
        return ((double) 1 - Math.pow(0.9, n + 1));
    }
    
    private void frecuenciaAcumulada(int[] muestra){
        fe = new double[intervalos.length];
        
        for (int i = 0; i < fe.length; i++) 
            if(i == 0)
                fe[i] = round(singleRA(frecuencia[i], numeroHuecos(muestra.length)),3);
             else
                fe[i] = round(singleRA(frecuencia[i], numeroHuecos(muestra.length)) + fe[i-1],3);
    }
    
    private void frecuenciaAcumuladaR(){
        fo = new double[intervalos.length];
        
        for (int i = 0; i < intervalos.length; i++) 
            fo[i] = round(singleFAR(intervalos[i][1]),3);
    }
    
    private void diferenciaFrecuencias(){
        diferencia = new double[fe.length];
        
        for (int i = 0; i < fe.length; i++) 
            diferencia[i] = round(Math.abs(fe[i] - fo[i]),3);
    }
    
    private double diferenciaMAX(double[] fe, double[] fo){      
        for (int i = 0; i < diferencia.length; i++) {
            for (int j = 0; j < diferencia.length; j++) {
                if(diferencia[i] > diferencia[j]){
                    double aux = diferencia[j];
                    diferencia[j] = diferencia[i];
                    diferencia[i] = aux;
                }
            }
        }
        return diferencia[0];
    }
    
    public boolean pasaPrueba(int[] muestra){
        double dMax = diferenciaMAX(fe, fo);
        double dKol = resKolmogorov(numeroHuecos(muestra.length));
        System.out.println(dMax +"  "+dKol);
        return dMax < dKol;
    }

    private double resKolmogorov(int nHuecos){
        return ((double) 1.36 / Math.sqrt(nHuecos));
    }

    private int longitudHuecos(int n) {
        return (int) Math.round((double)n / 3);
    }
    
    private int[] ordenarMuestra(int[] m) {
        int[] muestra = new int[m.length];
        System.arraycopy(m, 0, muestra, 0, m.length);
        for (int i = 0; i < muestra.length; i++) 
            for (int j = 0; j < muestra.length; j++) 
                if (muestra[i] < muestra[j]) {
                    int aux = muestra[j];
                    muestra[j] = muestra[i];
                    muestra[i] = aux;
                }
   
        return muestra;
    }

    private int[] digitosUnicos(int[] muestra) {
        int[] aux = ordenarMuestra(muestra);
        ArrayList<Integer> nu = new ArrayList();

        for (int i = 0; i < aux.length; i++) 
            for (int j = 0; j < aux.length - 1; j++) 
                if(i != j) if (aux[i] == aux[j]) aux[j] = -1;    
        
        for (int i = 0; i < aux.length; i++) if(aux[i] >= 0) nu.add(aux[i]);
        
        return convertirArray(nu);
    }

    private int[] convertirArray(ArrayList<Integer> al) {
        int[] k = new int[al.size()];

        for (int i = 0; i < k.length; i++) k[i] = al.get(i);
        
        return k;
    }
    
    Double round(Double numero, Integer numeroDecimales) {
        return Math.round(numero * Math.pow(10, numeroDecimales)) / Math.pow(10, numeroDecimales);
    }
    
    public void proceso(int[] muestra){
        System.out.println("No. Huecos: " +numeroHuecos(muestra));
        
        ocurrencia(muestra, muestra.length);
       
        intervalosOcurrencia();
        frecuencias();
        frecuenciaAcumulada(muestra);
        frecuenciaAcumuladaR();
        diferenciaFrecuencias();
    }
}