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
            for (int j = 0; j < muestra.length; j++) {
                if (unicos[i] == muestra[j]) {
                    c++;
                }
            }
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
                    System.out.println("empieza: " + j);
                    do{
                       System.out.println(unico[i] + " " + muestra[j] + " " + c);
                       j++;
                       c++;
                       if(j == muestra.length) break;
                       else if(j >= muestra.length - 1) c = -1;
                    }while(unico[i] != muestra[j]);
                    System.out.println("termina " + j);
                    j--;
                    c--;
                    if(c > 0){
                        for (int k = 0; k < intervalo.length; k++) {
                            if(c >= intervalo[k][0] && c <= intervalo[k][1]) {
                                System.out.println("se guardo en: " + intervalo[k][0] + " - " + intervalo[k][1] + " - " + c );
                                oc[k]++;
                            }
                        }
                    }
                }
            }
        }
        return oc;
    }

    public int longitudHuecos(int n) {
        return Math.round((float) n / 3);
    }

    public int[] ordenarMuestra(int[] m) {
        int[] muestra = new int[m.length];
        System.arraycopy(m, 0, muestra, 0, m.length);
        for (int i = 0; i < muestra.length; i++) {
            for (int j = 0; j < muestra.length; j++) {
                if (muestra[i] < muestra[j]) {
                    int aux = muestra[j];
                    muestra[j] = muestra[i];
                    muestra[i] = aux;
                }
            }
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

        for (int i = 0; i < k.length; i++) {
            k[i] = al.get(i);
        }
        return k;
    }
}
