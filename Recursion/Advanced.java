package Recursion;

public class Advanced {
    // print the number of ways of tiling of 2*n board with 2*1 tiles
    public static int tiling(int n){
        // base case
        if(n==0 || n==1){
            return 1;
        }
        

        // vertical choice
        int f1 = tiling(n-1);

        // horizontal choice
        int f2 = tiling(n-2);

        // total ways
        return f1+f2;
    }


    // remvoing the duplicates from a string 
    public static StringBuilder removeDuplicates(String s, StringBuilder sb, int i, boolean array[]){
        if(i==s.length()){
            return sb;
        }
        if(array[s.charAt(i)-'a']!=true){
            sb.append(s.charAt(i));
        }
        array[s.charAt(i)-'a'] = true;
        return removeDuplicates(s, sb, i+1, array);
    }



    // pairing up the friends 
    public static int pairFriends(int n){
        if(n==1 || n==0){
            return 1;
        }
        // remain single 
        int f1 = pairFriends(n-1);

        // pair with any of the remaining friends
        int f2 = (n-1) * pairFriends(n-2);


        // total
        return f1 + f2;
    }

    

    // binary string problem: binary string is a string containing only 0 and 1 as a character
    // print all the binary strings of size n without consecutive ones
    public static void binaryStrings(int n, String s, int lastPlace){
        if(n==0){
            System.out.println(s);
            return;
        }
        binaryStrings(n-1, s+"0", 0);
        if(lastPlace != 1){
            binaryStrings(n-1, s+"1", 1);
        }
    }




    public static void main(String arg[]){
        System.out.println(tiling(3));
        boolean array[] = new boolean[26];
        StringBuilder sb = new StringBuilder("");
        System.out.println(removeDuplicates( "aba", sb , 0, array));
        System.out.println(pairFriends(3));
        binaryStrings(3, "", 0);
    }
}
