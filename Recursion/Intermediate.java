package Recursion;

public class Intermediate {
    // check if the array is sorted or not
    public static boolean arraySorted(int array[], int i){
        if(i==array.length-1){
            return true;
        }
        int m = array[i];
        int n = array[i+1];
        if(m>n){
            return false;
        }
        return arraySorted(array, i+1);
    }

    // first occurence of an element in array. 
    public static int firstOccurence(int array[], int k, int i){
        if(k==array[i]){
            return i;
        }
        if(i==array.length-1){
            return -1;
        }
        return firstOccurence(array, k, i+1);
    }

    // last occurence of an element in array;
    public static int lastOccurence(int array[], int k, int i){
        if(i==array.length){
            return -1;
        }

        int isFound = lastOccurence(array, k, i+1);
        if(k==array[i] && isFound==-1){
            return i;
        }

        return isFound;
    }


    // print x to the power n 
    public static int xToN(int x, int n){
        if(n==0){
            return 1;
        }
        return x * xToN(x, n-1);
    }
    // time and space complexity of this is O(n);



    // print x to the power n (optimized)
    public static int xToNOpt(int x, int n){
        if(n==0){
            return 1;
        }
        int m = n & 1;
        if(m==0){
            return 1 * xToN(x*x, n>>1);
        }else{
            return x * xToN(x*x, n>>1);
        }
    }

    // print x to the powe n (optimized same)
    public static int xToNOptSame(int x, int n){
        if(n==0){
            return 1;
        }
        int halfPow = xToN(x, n/2);
        int halfPowSq = halfPow * halfPow;
        if(n%2!=0){
            halfPowSq*= x;
        }
        return halfPowSq;
    }



    public static void main(String arg[]){
        int array[] = {4,4};
        System.out.println(arraySorted(array, 0));
        System.out.println(firstOccurence(array, 4, 0));
        System.out.println(lastOccurence(array, 4, 0));
        System.out.println(xToNOptSame(2, 5));
    }
}
