package Hashing;

import java.util.HashSet;

public class ProblemsSet {

    // count the number of distinct elements in an array
    public static int countDistinct(int array[]){
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i<array.length; i++){
            hs.add(array[i]);
        }
        return hs.size();
    }

    // to find the intersection and union of two arrays 
    public static void intersectionAndUnion(int arr1[], int arr2[]){
        HashSet<Integer> hs = new HashSet<>();
        int minSize = Math.min(arr1.length, arr2.length);
        int maxSize = Math.max(arr1.length, arr2.length);
        boolean x = minSize == arr1.length;
        for(int i=0; i<minSize; i++){
            hs.add(arr1[i]);
            hs.add(arr2[i]);
        }

        for(int i=minSize; i<maxSize; i++){
            if(x){
                hs.add(arr2[i]);
            }else{
                hs.add(arr1[i]);
            }
        }

        System.out.println("Union: " + hs.size());
        hs.clear();

        for(int i=0; i<arr1.length; i++){
            hs.add(arr1[i]);
        }   
        int count = 0;
        for(int i=0; i<arr2.length; i++){
            if(hs.contains(arr2[i])){
                count++;
                hs.remove(arr2[i]);
            }
        }

        System.out.println("Intersection: " + count);
    }


    public static void main(String arg[]){
        int array[] = {4,3,2,5,6,7,3,4,2,1};
        System.out.println(countDistinct(array));


        int arr1[] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4};

        intersectionAndUnion(arr1, arr2);
    }
}
