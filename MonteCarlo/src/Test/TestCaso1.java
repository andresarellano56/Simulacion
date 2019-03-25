/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Casos.Caso1;

public class TestCaso1 {

    public static void main(String[] args) {
        double y = new Caso1().calcularTheta(0, 1, 3000000, 6);
        double x = y * new Caso1().calcularTheta(0, 1, 3000000, 6);
        System.out.println(x);
    }
    
}
