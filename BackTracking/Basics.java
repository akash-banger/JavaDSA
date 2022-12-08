package BackTracking;

public class Basics {
    // BackTracking is just BackTracking your path to the source. 

    /* Types of BackTracking
     * Decision: is solution exist of a problem or not
     * Optimization: finding out best solution out of some number of solutions
     * Enumeration: List all the possible solutions
     */


    // Basics: BackTracking an array 
    // go through an array and assign values 1,2,3,4 and so on 
    // and then while returning decrease the values by 2

    // means there will be n calls of the function 
    // now after n calls the toppest function will return a value and then second toppest and so on (we are coming back)//
    // now while coming back we have to perform a function.

    public static void backTrackArray(int array[],int n, int val){
        if(n==array.length){
            printArray(array);
            return;
        }
        array[n] = val;
        backTrackArray(array, n+1, val+1); // function call step
        array[n]=array[n] - 2; // backTracking step
    }

    public static void printArray(int array[]){
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public static void main(String arg[]){
        int n = 5;
        int array[] = new int[n];
        backTrackArray(array, 0, 1);
        printArray(array);
    }
}
