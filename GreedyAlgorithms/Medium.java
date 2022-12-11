package GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Medium {


    // we have to select pairs after one another such that (a,b) then (c,d) c>b
    public static int maxLenChainPairs(int pairs[][]){
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));
        int count = 1;
        int chainEnd = pairs[0][1];
        for(int i=1; i<pairs.length; i++){
            if(pairs[i][0]> chainEnd){
                count++;
                chainEnd = pairs[i][1];
            }
        }
        return count;
    }



    // Indian rupees change 
    public static int indianRupeesChange(int denoms[], int val, ArrayList<Integer> ans){
        int count = 0;
        int i=denoms.length -1;
        while(val>0){
            if(val>=denoms[i]){
                while(val>=denoms[i]){
                    val-=denoms[i];
                    ans.add(denoms[i]);
                    count++;
                }
            }
            i--;
        }
        return count;
    }

    public static void main(String arg[]){
        int pairs[][] = {{5,24},
                         {39,60},
                         {5,28},
                         {27,40},
                         {50,90}};
        ArrayList<Integer> ans = new ArrayList<>();

        int denoms[] = {1,2,5,10,20,50,100,500,2000};
        System.out.println(maxLenChainPairs(pairs));
        System.out.println(indianRupeesChange(denoms, 590, ans));
        System.out.println(ans);
    }
}
