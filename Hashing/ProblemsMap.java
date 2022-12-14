package Hashing;


import java.util.HashMap;

public class ProblemsMap {
    public static void majorityElement(int array[]){
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = array.length;
        for(int i=0; i<array.length; i++){
            // if(hm.containsKey(array[i])){
            //     int newFreq = hm.get(array[i]) + 1;
            //     hm.put(array[i], newFreq);
            //     continue;
            // }
            // hm.put(array[i], 1);

            // efficient way
            hm.put(array[i], hm.getOrDefault(array[i], 0) + 1);
        }

        // Set<Integer> keys = hm.keySet();
        // directly write 
        for (Integer key : hm.keySet()) {
            if(hm.get(key) > n/3){
                System.out.print(key + " ");
            }
        }
        System.out.println();
    }


    public static boolean validAnagrams(String s1, String s2){
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<s1.length(); i++){
            hm.put(s1.charAt(i), hm.getOrDefault(s1.charAt(i), 0) + 1);
        }

        for(int i=0; i<s2.length(); i++){
            if(hm.containsKey(s2.charAt(i))){
                if(hm.get(s2.charAt(i)) == 1){
                    hm.remove(s2.charAt(i));
                    continue;
                }
                hm.put(s2.charAt(i), hm.get(s2.charAt(i)) - 1);
            }else{
                return false;
            }
        }
        return hm.isEmpty();
    }


    public static void printJourney(HashMap<String, String> tickets){
        HashMap<String, String> reverse = new HashMap<>();
        for (String from : tickets.keySet()) {
            String to = tickets.get(from);
            reverse.put(to, from);
        }   
        String start = "";
        for( String from : tickets.keySet()){
            if(!reverse.containsKey(from)){
                start = from;
            }
        }

        if(start != ""){
            System.out.print(start);
            for (String ticket : tickets.keySet()) {
                System.out.print("=>" + tickets.get(ticket));
            }
        }else{
            System.out.print("Journey Not Possible");
        }

        System.out.println();
    }


    public static int largestSubArrZero(int arr[]){
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        int len = 0;
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
            if(hm.containsKey(sum)){
                len = Math.max(len, i - hm.get(sum));
            }else{
                hm.put(sum, i);
            }
        }

        return len;
    }


    public static int subArraySumK(int arr[], int k){
        HashMap<Integer, Integer> hm = new HashMap<>();

        hm.put(0, 1);
        int sum = 0;
        int ans = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            if(hm.containsKey(sum - k)){
                ans += hm.get(sum-k);
            }
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }

        return ans;

    }

    public static void main(String arg[]){
        // find the element is the array whose freq is more than n/3
        int array[] = {1,3,2,5,1,3,1,5,1};
        majorityElement(array);


        // check two strings are valid anagrams or not 
        System.out.println(validAnagrams("racee", "cleer"));


        // Print the journey 
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        printJourney(tickets);

        // largest subarray with sum 0
        int arr[] = {15,-2,2,-8,1,7,10};
        System.out.println(largestSubArrZero(arr));


        // find the number of subarrays whose sum is equal to the K
        int test[] = {1,2,3};
        int k = 3;
        System.out.println(subArraySumK(test, k));
    }
}
