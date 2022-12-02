package Arrays;
public class Array {

    // reversing an array: 
    // public static void reverseArray(int array[]){
    //     int n = array.length-1;
    //     for(int i=0; i<=n/2; i++){
    //         int temp = array[i];
    //         array[i] = array[n-i];
    //         array[n-i] = temp;
    //     }
    // }

    // better
    public static void reverseArray(int array[]){
        int first = 0;
        int last = array.length - 1;
        while(first<last){
            int temp = array[first];
            array[first] = array[last];
            array[last] = temp;
            first++;
            last--;
        }
    }


    // pairing of array
    public static void pairArray(int array[]){
        for(int i=0; i<array.length; i++){
            int curr = array[i];    
            for(int j=i+1; j<array.length; j++){
                System.out.print("("+curr+","+array[j]+") ");
            }
            System.out.println("");
        }
    }


    // printing subarrays.
    public static void subArray(int array[]){
        for(int i=0; i<array.length; i++){
            for(int j=i; j<array.length; j++){
                System.out.print("("+array[i]);
                for(int k=i+1; k<=j; k++){
                    System.out.print(","+array[k]);
                }
                System.out.print(") ");
            }
            System.out.println("");
        }
    }



    // max/min sum of subArray (brute force)

    // public static void sumSubArray(int array[]){
    //     int maxSum = Integer.MIN_VALUE;
    //     int minSum = Integer.MAX_VALUE;
    //     for(int i=0; i<array.length; i++){
    //         for(int j=i; j<array.length; j++){
    //             int sum = 0;
    //             for(int k=i; k<=j; k++){
    //                 sum+=array[k];
    //             }
    //             maxSum = Math.max(maxSum,sum);
    //             minSum = Math.min(minSum,sum);
    //         }
    //     }
    //     System.out.println("max sum: "+ maxSum);
    //     System.out.println("min sum: "+ minSum);
    // }   



    // // prefix sum (better way) sum of subarrays;
    // public static void sumSubArray(int array[]){
    //     int maxSum = Integer.MIN_VALUE;
    //     int minSum = Integer.MAX_VALUE;
    //     for(int i=0; i<array.length; i++){
    //         int sum = 0;
    //         for(int j=i; j<array.length; j++){
    //             sum+=array[j];
    //             maxSum = Math.max(maxSum, sum);
    //             minSum = Math.min(minSum, sum);
    //         }
    //     }
    //     System.out.println("max sum: "+ maxSum);
    //     System.out.println("min sum: "+ minSum);
    // }   


    // more better way kadane's rule; // atleast one number is array should be postive

    public static void sumSubArray(int array[]){
        int maxSum = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        int cs = 0;
        for(int i=0; i<array.length; i++){
            max = Math.max(array[i],max);
            cs+= array[i];
            if(cs<0){
                cs = 0;
            }
            maxSum = Math.max(maxSum, cs);
        }
        if(max<0){
            System.out.println(max);
        }else{
            System.out.println(maxSum);
        }
    }   





    // binary search 
    public static boolean binarySearch(int k, int array[]){
        int start = 0;
        int end = array.length - 1;
        while(start<=end){
            int mid = (start + end)/2;
            if(array[mid] == k){
                return true;
            }else if(array[mid]<k){
                start = mid + 1;
            }else if(array[mid]>k){
                end = mid - 1;
            }
        }
        return false;
    }
    public static void main(String arg[]){
        // binary search: for sorted array only



        // binarySearch

        // System.out.println("array size");
        // int n = sc.nextInt();
        // int array[] = new int[n];
        // System.out.println("array");
        
        // for(int i=0; i<n; i++){
        //     array[i] = sc.nextInt();
        // }

        // System.out.println("key");

        // int key = sc.nextInt();
        // System.out.println(binarySearch(key,array));

        // time compexity of binary search is less then the linear search 
        // as n > log2(n);





        // reverseArray
        int array[] = {-2,-3,4,-1,-2,1,5,-3};
        reverseArray(array);
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]);
        }


        System.out.println("");
        // pairing of array
        pairArray(array);


        // printing subarrays.
        subArray(array);


        // max/min sum of subarrays.
        sumSubArray(array);
    }
}
