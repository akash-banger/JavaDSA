package DivideAndConquer;

public class SearchInRotated {

    // serching the pivot in a rotated array.
    // this is just modified binary search

    public static int searchInRotatedArray(int array[], int si, int ei, int tar){
        if(si>ei){
            return -1;
        }
        
        int mid = si + (ei - si)/2;

        // target FOUND
        if(tar == array[mid]){
            return mid;
        }

        // target on L1
        if(array[si]<=array[mid]){
            if(tar<=array[mid] && tar>=array[si]){// On left
                return searchInRotatedArray(array, si, mid-1, tar);
            }else{// On right
                return searchInRotatedArray(array, mid+1, ei, tar);
            }
        }else{  // target on L2
            if(tar<=array[ei] && tar>=array[mid]){// on right
                return searchInRotatedArray(array, mid+1, ei, tar);
            }else{// on left
                return searchInRotatedArray(array, si, mid-1, tar);
            }
        }
    }
    public static void main(String arg[]){
        int array[] = {4,5,6,-1,0,1,2};
        System.out.println(searchInRotatedArray(array, 0, array.length-1, -1)); 
    }
}
