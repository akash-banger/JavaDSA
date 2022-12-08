package ArrayList;
import java.time.chrono.HijrahEra;
import java.util.*;
public class Intermediate {


    // brute force by akash ( a little nice)
    public static void containerMostWater(ArrayList<Integer> height){
        ArrayList<Integer> sortedHeight = new ArrayList<>(height);
        Collections.sort(sortedHeight);
        int j = height.size() - 1;
        int vol = 0;
        int x = 0;
        int y = 0;
        while(j>0){
            int idx1 = height.indexOf(sortedHeight.get(j));
            int idx2 = height.indexOf(sortedHeight.get(j-1));
            if(idx1 == idx2){
                idx2 = height.lastIndexOf(sortedHeight.get(j-1));
            }
            if(Math.min(sortedHeight.get(j), sortedHeight.get(j))*(Math.max(idx1,idx2) - Math.min(idx1,idx2)) > vol){
                vol = Math.max(sortedHeight.get(j), sortedHeight.get(j))*(idx2-idx1);
                x = idx1;
                y = idx2;
            }
            j--;
        }
        System.out.println(x + " " + y);
    }


    // two pointer approach 
    public static void containerMostWaterOpt(ArrayList<Integer> height){
        int lp = 0;
        int rp = height.size()-1;
        int vol = -1;
        int maxVol = -1;
        int x=lp, y=rp;
        while(lp<rp){
            if(height.get(lp)>height.get(rp)){
                vol = (rp-lp)*height.get(rp);
                if(vol>maxVol){
                    maxVol = vol;
                    x = lp; y=rp;
                }
                rp--;
            }else{
                vol = (rp-lp)*height.get(lp);
                if(vol>maxVol){
                    maxVol = vol;
                    x = lp; y=rp;
                }
                lp++;
            }
            
        }
        System.out.println(x + " " + y);
    }








    public static void main(String arg[]){
        ArrayList<Integer> height = new ArrayList<Integer>(Arrays.asList(1,8,6,2,5,4,7,3,8));
        containerMostWaterOpt(height);
    }
}
