package DivideAndConquer;

public class MergeSort {
    // as the name suggests 
    // we will divide the problem into smaller problems 
    // and then we will conquer our bigger problem 

    // this is just an algorithm to solve questions
    

    // MERGE SORT 
    /* Approach
     * Divide(mid)
     * MergeSort(left), MergeSort(right)
     * merge
     */


    public static void mergeSort(int array[], int si, int ei){
        // base condition
        if(si >= ei){
            return;
        }

        int mid = si + (ei - si)/2; // (si+ei)/2 // so that we don't add two big integers

        // divide
        mergeSort(array, si, mid); // left part
        mergeSort(array, mid+1, ei); // right part

        // conquer
        merge(array, si, mid, ei);
    }   


    public static void merge(int array[], int si, int mid, int ei){
        int tempArray[] = new int[(ei-si)+1]; 

        int i = si;  // left part iterator
        int j = mid + 1; // right part iterator
        int k = 0; // tempArray iterator

        //comparing left and right part and thn storing in tempArray accordingly
        while(i<=mid && j<=ei){
            if(array[i]<array[j]){
                tempArray[k] = array[i];
                i++;
            }else{
                tempArray[k] = array[j];
                j++;
            }
            k++;
        }


        // elements left in the left part
        while(i<=mid){
            tempArray[k++] = array[i++];
        }   

        // elements left in the right part
        while(j<=ei){
            tempArray[k++] = array[j++];
        }


        // storing sorted values from tempArray to original array ? carefull
        for(k=0, i=si; k<tempArray.length; k++, i++){
            array[i] = tempArray[k];
        }
    }

    // time complexity O(n*log(n))


    public static void main(String arg[]){
        int array[] = {1,3,2,5,4};
        mergeSort(array, 0, array.length-1);



        for(int i=0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}
