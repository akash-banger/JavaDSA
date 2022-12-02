package Sorting;
import java.util.Arrays;
import java.util.Collections;
public class BasicSorting {
    // bubbleSort
    public static void bubbleSort(int array[]){
        for(int i=0; i<array.length-1; i++){
            int swaps = 0;
            for(int j=0; j<array.length-1-i; j++){
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swaps++;
                }
            }
            if(swaps==0){
                break;
            }
        }
    }


    // selection Sorting
    public static void selectionSort(int array[]){
        for(int i=0; i<array.length-1; i++){
            int minIndex = i;
            for(int j=i+1; j<array.length; j++){
                if(array[j]<array[minIndex]){
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }


    // insertion sorting
    public static void insertionSort(int array[]){
        for(int i=1; i<array.length; i++){
            int curr = array[i];
            int prev = i-1;
            while(prev>=0 && array[prev]>curr){
                array[prev+1] = array[prev];
                prev--;
            }
            array[prev+1] = curr;
        }
    }

    public static void main(String arg[]){
        int array[] = {-1,5,8,-8,-2,0,3,1};
        // bubbleSort(array);
        // selectionSort(array);
        // insertionSort(array);
        
        
        // inbuilt sort of java
        // import java.util.Arrays // time compexity  = O(n*log(n));
        
        Integer arr[] = {1,3,2,5,34,3};
        Arrays.sort(arr, Collections.reverseOrder()); // Collections will only work for datatype Integer

        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println("");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
