package GreedyAlgorithms;

import java.util.Collection;
import java.util.Collections;
import java.util.Arrays;
public class ChocolaProblem {
    public static void main(String arg[]){
        int n=4, m=6;
        Integer costVer[] = {2,1,3,1,4};
        Integer costHor[] = {4,1,2};

        Arrays.sort(costHor, Collections.reverseOrder());
        Arrays.sort(costVer, Collections.reverseOrder());

        int h=0, v=0;
        int hp=1, vp=1;
        int cost = 0;

        while(h<costHor.length && v<costVer.length){
            // vertical cost < horizontal cost 
            if(costVer[v] < costHor[h]){  // horizontal cut
                cost+=costHor[h]*vp;
                hp++;
                h++;
            }else{                  // vertical cut
                cost+=costVer[v]*hp;
                vp++;
                v++;
            }
        }

        while(h<costHor.length){
            cost+=costHor[h]*vp;
            hp++;
            h++;
        }

        while(v<costVer.length){
            cost+=costHor[v]*hp;
            vp++;
            v++;
        }

        System.out.println("Min cost of cutting the choco into square pieces: " + cost);
    }
}
