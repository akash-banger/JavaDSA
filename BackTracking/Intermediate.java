package BackTracking;
public class Intermediate {

    // printing the subsets of a String 
    public static void subsetsString(String s, int i, String s1){
        if(i==s.length()){
            if(s1 == ""){
                System.out.println("phi");
                return;
            }
            System.out.print(s1 + " ");
            return;
        }
        subsetsString(s, i+1, s1 + s.charAt(i)); // Element included
        subsetsString(s, i+1, s1); // Element not included
    }
    // time complexity for this is O(n*2^n)
    // as there are 2^n subsets and we call the function n times to print one subset



    // printting all the permutations of a String 
    public static void permutationsString(String s, String ans){
        if(s.length() == 0){
            System.out.println(ans + " ");
            return;
        }

        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i); // current character

            StringBuilder temp = new StringBuilder(s);
            temp.deleteCharAt(i);
            String newS = temp.toString(); // deleting the current character from the string and making a new string

            permutationsString(newS, ans + curr); // passing new string and ans
        }
    }
    // time complexity is O(n*n!) as there are n! permutations and we are taking n number of calls for each case



    public static void main(String arg[]){
        String s = "abc";
        subsetsString(s, 0, "");
        permutationsString(s, "");
    }
}
