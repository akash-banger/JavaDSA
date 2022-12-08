package DivideAndConquer;

public class QuickSort {
    // approach 
    /*
     * Take a pivot (you can take any element as pivot, we will take last element)
     * partitions (take parts) (take smaller elements than pivot to left and bigger to right)
     * Call QuickSort(left and right)
     */
    public static void quickSort(int array[], int si, int ei){
        // base case
        if(si>=ei){
            return;
        }

        // finding index of our pivot after sorting around that pivot
        int pIdx = partitions(array, si, ei);

        quickSort(array, si, pIdx-1);
        quickSort(array, pIdx+1, ei);
    }

    // partiotioning the array around the pivot
    public static int partitions(int array[], int si, int ei){
        int pivot = array[ei];
        int i = si-1;
        for(int j=si; j<ei; j++){
            if(array[j]<pivot){
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        i++;
        int temp = array[i];
        array[i] = array[ei];
        array[ei] = temp;
        return i;
    }


    // time complexity of quickSort in average case is O(n*logn)
    // and in worst casse its (n*n)
    // space complexity is just O(1)
    public static void main(String arg[]){
        int array[] = {5,3,5,2,5,4,0};
        quickSort(array, 0, array.length-1);

        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+ " ");
        }
    }
}


// worst case time complexity of quickSort
// worst case time complexity occurs when our pivot is always largest or smallest (for every recursion)

// take example of a already sorted array
// the last element is largest so partition will occur 
// and the left part will have n-1 elements and right part is empty 
// and again for the left part the pivot is largest and so on

// in this case 
// first recursion used the loop n-1 times 
// and then n-2 times 
// and then n-3 times and so on
// summing this all we will get
// n(n+1)/2 which is O(n*n)


