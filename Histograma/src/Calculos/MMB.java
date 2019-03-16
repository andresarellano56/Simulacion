package Calculos;

import java.util.Scanner;

public class MMB {
    int n, h, a, m, n0, b;
    final int c = 0;

    public static void main(String[] args) {
        new MMB().run();
    }

    int calculaB(int n) {
        double log = 2 + ((Math.log(n) / Math.log(2)) + (1 - Math.pow(10, -6)));
        return (int) log;
    }

    int calculaH(int b) {
        return (int) Math.pow(2, b - 2);
    }

    int calculaM(int b) {
        return (int) Math.pow(2, b);
    }

    int calculaA(int t) {
        double num;

        num = (int) 8 * (t * Math.random());
        if (Math.random() > 0.5) num += 3;
        else  num -= 3;
   
        return (int) num;
    }

    int calculaN0(int m) {
        return (int) (2 * Math.round(m * Math.random() + 0.5) + 1) % m;
    }

    void numerosAleatorios() {
        System.out.println("[i]     [nli]       [xli]       ");
        int semilla = n0, numero;
        double numero2;
        for (int i = 0; i < n; i++) {
            if (i == 0) numero = semilla;
            else numero = formulaCongruencia(a, semilla, m);
            
            numero2 = (double) numero / (double) m;
            System.out.println(i + "      " + numero + "      " + numero2);
            semilla = numero;
        }
    }

    int formulaCongruencia(int a, int semilla, int m) {
        return ((a * semilla) + c) % m;
    }

    int calculaRaizPrimitiva(int m) {
        int i = 0;
        int fmas, fmenos;
        float rm;
        rm = Math.round(Math.sqrt(m));
        
        do {
            fmas = 8 * i + 3;
            fmenos = 8 * i - 3;
            i++;
        } while ((double) fmenos < rm && (double) fmas < rm);
        
        double resta1=Math.abs((double)fmenos-Math.sqrt(m));
        double resta2=Math.abs((double)fmas-Math.sqrt(m));
        
        if(resta1 <= resta2) return fmenos;
        else return fmas;
    }

    void run() {
        System.out.print("Ingrese el numero de iteraciones: ");
        n = new Scanner(System.in).nextInt();
        b = calculaB(n);
        System.out.println("************");
        h = calculaH(b);
        m = calculaM(b);
        n0 = calculaN0(m);

        a = calculaRaizPrimitiva(m);

        System.out.println("b: " + b);
        System.out.println("h: " + h);
        System.out.println("m: " + m);
        System.out.println("c: " + c);
        System.out.println("a: " + a);
        System.out.println("No: " + n0);

        System.out.println("-----------------------------------");
        System.out.println("************");
        numerosAleatorios();
    }
    
}
