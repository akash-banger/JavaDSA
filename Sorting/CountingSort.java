package Sorting;

public class CountingSort {
    // used for +ve numbers only and low range numbers means max number of array should be small;

    public static void main(String arg[]){
        int array[] = {1,2,7,5,4};

        int maxNum = Integer.MIN_VALUE;
        for(int i=0; i<array.length; i++){
            maxNum = Math.max(array[i],maxNum);
        }

        int count[] = new int[maxNum+1];
        for(int i=0; i<array.length; i++){
            count[array[i]]++;
        }


        int j = 0;
        for(int i=0; i<=maxNum; i++){
            while(count[i]>0){
                array[j] = i;
                j++;
                count[i]--;
            }
        }

        // output

        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
    }
}
