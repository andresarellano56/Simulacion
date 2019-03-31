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

    public int numeroHuecos(int n) {
        return n - 10;
    }

    public int numeroHuecos(int[] muestra) {
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

    public int[][] intervalosOcurrencia(int n) {
        int lh = longitudHuecos(n);
        int c = 0;
        int[][] intervalos = new int[lh][2];

        for (int i = 0; i < lh; i++) {
            if (i == 0) {
                intervalos[i][0] = 0;
                intervalos[i][1] = 2;
            } else {
                intervalos[i][0] = intervalos[i - 1][0] + 3;
                intervalos[i][1] = intervalos[i - 1][1] + 3;
            }
        }
        return intervalos;
    }

    public int[] ocurrencia(int[] muestra, int n) {
        int[] unico = digitosUnicos(muestra);
        int[] oc = new int[unico.length];
        int[][] intervalo = intervalosOcurrencia(n);
        int c;

        for (int i : oc) i = 0;
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
                    if(c >= 0)
                        for (int k = 0; k < intervalo.length; k++) 
                            if(c >= intervalo[k][0] && c <= intervalo[k][1]) 
                                oc[k]++;
                }
            }
        }
        return oc;
    }
    
    public double singleRA(int oc, int n){
        return ((double) oc / n);
    }
    
    public double singleFAR(int n){
        return ((double) 1 - Math.pow(0.9, n + 1));
    }
    
    public double[] frecuenciaAcumulada(int[] oc, int n){
        double[] fe = new double[oc.length];
        
        for (int i = 0; i < oc.length; i++) 
            fe[i] = singleRA(oc[i], n);
        
        return fe;
    }
    
    public double[] frecuenciaAcumuladaR(int[][] intM){
        double[] fo = new double[intM.length];
        
        for (int i = 0; i < intM.length; i++) 
            fo[i] = singleFAR(intM[i][1]);
        
        return fo;
    }
    
    public double[] diferenciaFrecuencias(int[] fe, int[] fo){
        double[] dif = new double[fe.length];
        
        for (int i = 0; i < fe.length; i++) 
            dif[i] = fe[i] - fo[i];
        
        return dif;
    }
    
    public double difenciaMAX(int[] fe, int[] fo){
        double[] dif = diferenciaFrecuencias(fe, fo);
        
        for (int i = 0; i < dif.length; i++) {
            for (int j = 0; j < dif.length; j++) {
                if(dif[i] < dif[j]){
                    double aux = dif[j];
                    dif[j] = dif[i];
                    dif[i] = aux;
                }
            }
        }
        return dif[0];
    }
    
    public boolean pasaPrueba(double dMax, double dKol){
        return dMax < dKol;
    }

    public double resKolmogorov(int nHuecos){
        return ((double) 1.36 / Math.sqrt(nHuecos));
    }

    public int longitudHuecos(int n) {
        return Math.round((float) n / 3);
    }

    public int[] ordenarMuestra(int[] m) {
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

    public int[] digitosUnicos(int[] muestra) {
        int[] aux = ordenarMuestra(muestra);
        ArrayList<Integer> nu = new ArrayList();

        for (int i = 0; i < aux.length; i++) 
            for (int j = 0; j < aux.length - 1; j++) 
                if(i != j) if (aux[i] == aux[j]) aux[j] = -1;    
        
        for (int i = 0; i < aux.length; i++) if(aux[i] >= 0) nu.add(aux[i]);
        
        return convertirArray(nu);
    }

    public int[] convertirArray(ArrayList<Integer> al) {
        int[] k = new int[al.size()];

        for (int i = 0; i < k.length; i++) k[i] = al.get(i);
        
        return k;
    }
}