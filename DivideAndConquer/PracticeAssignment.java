package DivideAndConquer;
public class PracticeAssignment {

    // merge sort for an array of strings
    public static void mergeSortString(String array[], int si, int ei){
        if(si>=ei){
            return;
        }

        int mid = si + (ei - si)/2;

        mergeSortString(array, si, mid); // left part
        mergeSortString(array, mid + 1, ei); // right part

        merge(array, si, mid, ei); // merging
    }


    public static void merge(String array[], int si, int mid, int ei){
        String tempArray[] = new String[ei-si+1];
        int i = si;
        int j = mid + 1;
        int k = 0;
        while(i<=mid && j<=ei){
            if(array[i].compareTo(array[j])<0){
                tempArray[k] = array[i++];
            }else{
                tempArray[k] = array[j++];
            }
            k++;
        }
        while(i<=mid){
            tempArray[k++] = array[i++];
        }
        while(j<=ei){
            tempArray[k++] = array[j++];
        }
        for(k=0, i=si; k<tempArray.length; k++,i++){
            array[i] = tempArray[k];
        }
    }


    // returning the element which is occuring more than n/2 times in an array
    // public static int check(int arr[]){
    //     int count = 1;
    //     int ans = -1;
    //     for(int i=1; i<arr.length; i++){
    //         if(arr[i] == arr[i-1]){
    //             count++;
    //             if(count>arr.length/2){
    //                 ans = arr[i];
    //                 break;
    //             }

    //         }else{
    //             count = 1;
    //         }
    //     }
    //     return ans;
    // }



    public static int countInRange(int arr[], int n, int si, int ei){
        int count = 0;
        for(int i=si; i<=ei; i++){
            if(arr[i]==n){
                count++;
            }
        }
        return count;
    }

    // returning the element which is occuring more than n/2 times in an array (optimized)
    public static int majorityElement(int arr[], int si, int ei){
        if(si>=ei){
            return arr[si];
        }
        
        int mid = si + (ei-si)/2;
        int left = majorityElement(arr, si, mid);
        int right = majorityElement(arr, mid+1, ei);

        if(left == right){
            return left;
        }

        int leftCount = countInRange(arr, left, si, ei);
        int rightCount = countInRange(arr, right, si, ei);
        
        return leftCount>rightCount ? left:right;
        
    }



    // Inversion count of an array (means how much far is an array to being sorted)
    public static int inversionCount(int array[], int si, int ei){
        if(ei>=array.length){
            return 0;
        }
        int m = inversionCount(array, si, ei+1);
        if(array[si]<=array[ei]){
            return 0 + m;
        }else{
            return 1 + m;
        }
    }

    public static int inversionCountHelp(int array[], int si){
        if(si==array.length-1){
            return 0;
        }
        return inversionCount(array, si, si+1) + inversionCount(array, ++si, si+1);
    }



    public static void main(String arg[]){
        String array[] = {"akash","banger","aakaah","abr","barger"};
        mergeSortString(array, 0, array.length-1);

        for(int i=0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }

        int arr[] = {3,2,3};
        System.out.println(majorityElement(arr, 0, arr.length-1));
        int arr2[] = {5,5,5};
        System.out.println(inversionCountHelp(arr2, 0));
    }
}
