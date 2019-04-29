package Archivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Archivo {
    BufferedReader bw;
    
    public int[] numeros(String path) throws IOException{
        bw = new BufferedReader(new FileReader(path));
        ArrayList<Integer> lista=new ArrayList();
        String linea="";
        
        while((linea=bw.readLine())!=null){
            String[] parts = linea.split("\\.");
            for(int i=0;i<parts[1].length();i++){
               char n = parts[1].charAt(i);
               lista.add(Character.getNumericValue(n)); 
            }         
        }
        int[] numeros =new int[lista.size()];
        for(int i=0;i<numeros.length;i++) numeros[i]=lista.get(i);
        return numeros;
    }
}
