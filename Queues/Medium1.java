package Queues;

import java.util.*;


public class Medium1 {

    public static void printArray(char arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static char[] firstNonRepeating(String str){
        Queue<Character> q = new LinkedList<>();
        int freq[] = new int[26];
        char sol[] = new char[str.length()];
        for(int i=0; i<str.length(); i++){
            int curr = str.charAt(i) - 'a';
            q.add(str.charAt(i));
            freq[curr]++;
            while(true){
                if(freq[q.peek() - 'a']<=1){
                    break;
                }
                q.remove();
                if(q.isEmpty()){
                    break;
                }
            }
            if(q.isEmpty()){
                sol[i] = '*';
            }else{
                sol[i] = q.peek();
            }
        }
        return sol;
    }
    public static void main(String arg[]){
        String str = "aabccxb";
        char sol[] = firstNonRepeating(str);
        printArray(sol);
    }
}
