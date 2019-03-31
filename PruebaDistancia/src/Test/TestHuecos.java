package Test;

import Huecos.GAP;

public class TestHuecos {

    public static void main(String[] args) {
        int[] x = {0,2,1,2,2,2,3,6,4,8,9,7,4,5,1,2,6,9,4,2,4,6,1};
        int[] y = {9,3,8,0,4,9,8,4,1,5,5,2,0,2,0,7,1,6,0,3,7,0,3,7,6,9,7,9,6,1};
        int[] z = {0,1,0,2,4,5,9,8,5,3,2,7,6,0,3,7,0,3,8,4,9,4,5,4,7,9,6,4,1};
        //int[] k = new GAP().digitosUnicos(y);
        //for(int i: k)System.out.println(i);
        
        //for(int i: x)System.out.println("*** " + i);
        
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

        int[] o = new GAP().ocurrencia(z, z.length);
        for(int m: o) System.out.println(m);
    }
    
    
    
}
