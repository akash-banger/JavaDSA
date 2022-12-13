package Heaps;

public class HeapSort {


    public static void heapify(int array[], int i, int n){
        int left = 2*i + 1;
        int right = left + 1;
        int maxIdx = i;

        if(left < n && array[left] > array[maxIdx]){
            maxIdx = left;
        }

        if(right < n && array[right] > array[maxIdx]){
            maxIdx = right;
        }

        if(maxIdx != i){
            int temp = array[i];
            array[i] = array[maxIdx];
            array[maxIdx] = temp;

            heapify(array, maxIdx, n);
        }

    }


    public static void heapSort(int array[]){
        int n = array.length;
        for(int i=n/2; i>=0; i--){
            heapify(array, i, n);
        }


        for(int i=n-1; i>0; i--){
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;

            heapify(array, 0, i);
        }

    }
    public static void main(String arg[]){
        int array[] = {1,5,2,7,3};
        heapSort(array);

        for(int i=0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }
        
        System.out.println();
    }
}
