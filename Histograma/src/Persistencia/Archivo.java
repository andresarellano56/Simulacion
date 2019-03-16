package Persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Archivo {
    FileReader fr;
    BufferedReader br;
    ArrayList <String> lista;
    
    public void openFile(String s){
        try{
            fr = new FileReader("src/data/" + s + ".txt");
            br = new BufferedReader(fr);
        }catch(IOException e){
            System.err.println("No se encontro el archivo " + e);
        }
    }
    
    public String[] readFile(String s){
        try{
            openFile(s);
            String res;
            
            lista = new ArrayList();
            while((res = br.readLine()) != null )
                lista.add(res);
            br.close();
            fr.close();
            return lista.toArray(new String[lista.size()]);
        }catch(IOException  e){
            System.err.println("Error con el Archivo " + e);
            return null;
        }
    }
}
