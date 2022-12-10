package Stacks;

import java.util.Stack;

public class Hard {

    public static void printArray(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }




    public static int maxAreaInHistogram(int height[]){
        // left lowest 
        Stack<Integer> s = new Stack<>();
        int leftLowest[] = new int[height.length];
        int rightLowest[] = new int[height.length];


        // calculating leftLowest
        for(int i=0; i<height.length; i++){
            while(!s.isEmpty() && height[s.peek()]>=height[i]){
                s.pop();
            }
            if(s.isEmpty()){
                leftLowest[i] = -1;
            }else{
                leftLowest[i] = s.peek();
            }
            s.push(i);
        }

        while(!s.isEmpty()){
            s.pop();
        }

        // calculating right lowest
        for(int i=height.length-1; i>=0; i--){
            while(!s.isEmpty() && height[s.peek()]>=height[i]){
                s.pop();
            }
            if(s.isEmpty()){
                rightLowest[i] = -1;
            }else{
                rightLowest[i] = s.peek();
            }
            s.push(i);
        }

        // calculating vol and maxVol
        int vol = 0;
        int maxVol = 0;
        for(int i=0; i<height.length; i++){
            vol = height[i] * (rightLowest[i] - leftLowest[i] -1);
            maxVol = Math.max(maxVol, vol);
        }

        return maxVol;
    }
    public static void main(String arg[]){
        int height[] = {2,1,5,6,2,3};
        System.out.println(maxAreaInHistogram(height));
    }
}
