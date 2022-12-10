package Stacks;

import java.util.Stack;
public class Medium1 {
    // next greater element 
    // next greater element of some element in an array is the first greater element to the right of the 
    // x in the same array 

    public static void nextGreaterElement(int array[], int sol[]){
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        for(int i=sol.length-1; i>=0; i--){
            while(!s.isEmpty() && s.peek()<=array[i]){
                s.pop();
            }
            if(s.isEmpty()){
                sol[i] = -1;
            }else{
                sol[i] = s.peek();
            }
            s.push(array[i]);
        }
    }

    public static void printArray(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String arg[]){
        int array[] = {6,8,0,1,3};
        int sol[] = new int[array.length];
        nextGreaterElement(array, sol);
        printArray(sol);
    }
}
