package Test;

import Huecos.GAP;

public class TestHuecos {

    public static void main(String[] args) {
        int[] x = {0,2,1,2,2,2,3,6,4,8,9,7,4,5,1,2,6,9,4,2,4,6,1};
        //int[] k = new GAP().digitosUnicos(x);
        //for(int i: k)System.out.println(i);
        
/*        System.out.println("* " + new GAP().numeroHuecos(x.length));
        System.out.println("- " + new GAP().numeroHuecos(x));
        System.out.println(new GAP().longitudHuecos(x.length));
        
        int[][] v = new GAP().intervalosOcurrencia(x.length);
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.println(v[i][j] + " - " + v[i][j + 1]);
                break;
            }
        }*/
        
        new GAP().ocurrencia(x, x.length);
    }
    
    
    
}
