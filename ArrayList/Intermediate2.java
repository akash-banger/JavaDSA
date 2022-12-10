package ArrayList;

import java.util.*;

public class Intermediate2 {
    // pair sum
    // sorted ArrayList is given 
    // find the sum of any two elements of arraylist which is equal to our target number
    public static boolean pairOneSum(ArrayList<Integer> list, int target){
        int lp = 0;
        int rp = list.size()-1;
        while(lp<rp){
            int sum = list.get(rp) + list.get(lp);
            if(sum == target){
                return true;
            }
            if(sum > target){
                rp--;
            }else{
                lp++;
            }
        }
        return false;
    }


    public static int findPIdx(ArrayList<Integer> list){
        for(int i=0; i<list.size()-1; i++){
            if(list.get(i)>list.get(i+1)){
                return (i + 1);
            }
        }
        return -1;
    }

    // pair sum 2
    // sorted and rotated ArrayList is given this time
    public static boolean pairTwoSum(ArrayList<Integer> list, int target){
        int pIdx = findPIdx(list);
        if(pIdx == -1){
            return pairOneSum(list, target);
        }
        int lp = pIdx - 1;
        int rp = pIdx;
        while(lp!=rp){
            int sum = list.get(rp) + list.get(lp);
            if(sum == target){
                return true;
            }
            if(sum>target){
                // lp--;
                // if(lp == -1){
                //     lp = list.size()-1;
                // }

                lp = (list.size() + lp -1)%list.size();
            }else{
                // rp++;
                // if(rp == list.size()-1){
                //     rp = 0;
                // }

                rp = (rp+1)%list.size();
            }
        }
        return false;
    }








    public static void main(String arg[]){
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        System.out.println(pairOneSum(list, 5));

        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(11,15,6,8,9,10));
        System.out.println(pairTwoSum(list2, 16));
    }
}
