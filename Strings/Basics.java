package Strings;

public class Basics {

    // shortest path 
    public static void shortPath(String str){
        int x =0;
        int y =0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == 'W'){
                x--;
            }else if(str.charAt(i) == 'E'){
                x++;
            }else if(str.charAt(i) == 'N'){
                y++;
            }else{
                y--;
            }
        }
        System.out.println(Math.sqrt(x*x + y*y));
    }
    

    // check if the string is palindrome or not
    public static boolean palindrome(String str){
        for(int i=0; i<str.length()/2; i++){
            if(str.charAt(i)!=str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }




    public static void main(String arg[]){
        // decalaring a String
        String str = "abcd";
        new String("akash");

        // Strings are Immutable. means strings never change in java;


        // finding length of a string
        int len = str.length();
        System.out.println(len);

        // concatenation 
        String firstName = "Akash";
        String lastName = "Banger";
        String fullName = firstName + " " + lastName;

        System.out.println(fullName);

        // charAt function for string 

        System.out.println(fullName.charAt(4));
        System.out.println(palindrome("abba"));


        // shortest path 
        shortPath("WNEENESENNN");
    }
}
