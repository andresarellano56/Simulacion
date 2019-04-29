package Test;

import java.util.ArrayList;

public class TestArray {
    public static void main(String[] args) {
        String var = "0.65432222";
        String parts[] = var.split("\\.");
        String parte1 = parts [0];
        String parte2 = parts [1];
        ArrayList<Integer> lista=new ArrayList();
        for(int i=0;i<parts[1].length();i++){
           char n = parts[1].charAt(i);
           lista.add(Character.getNumericValue(n)); 
        }
        
        for(int i: lista) System.out.println(i);
    }
}
