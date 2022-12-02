package Strings;
public class StringBuilders{

    // checking the two strings are anagrams or not


    /// Wrong: see assignment 2
    public static boolean anagrams(String s1, String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
        int n = s1.length();
        int array[] = new int[26];
        for(int i=0; i<n; i++){
            int x = (int) s1.charAt(i);
            x = x - 'a';
            array[x] = 1;
        }
        for(int i=0; i<n; i++){
            int x = (int) s2.charAt(i);
            x = x - 'a';
            if(array[x]!=1){
                return false;
            }
        }
        return true;
    }
    // wrong



    // String Compression 
    public static void compressString(StringBuilder sb){
        StringBuilder newS = new StringBuilder("");
        for(int i=0; i<sb.length(); i++){
            Integer n = 1;
            while( (i < sb.length() - 1) && (sb.charAt(i) == sb.charAt(i+1))){
                n++;
                i++;
            }
            newS.append(sb.charAt(i));
            if(n > 1){
                newS.append(n.toString());
            }
        }
        System.out.println(newS);
    }




    // converting first letter of each word in a sentence to uppercase
    public static void makeUpperCase(StringBuilder sb){
        StringBuilder newS = new StringBuilder("");
        newS.append(Character.toUpperCase(sb.charAt(0)));
        for(int i=1; i<sb.length(); i++){
            char space = sb.charAt(i-1);
            if(space == ' '){
                newS.append(Character.toUpperCase(sb.charAt(i)));
            }else{
                newS.append(sb.charAt(i));
            }
        }
        System.out.println(newS);
    }
    public static void main(String arg[]){
        // StringBuilder sb = new StringBuilder("hi, i am akash");
        // makeUpperCase(sb);


        StringBuilder s = new StringBuilder("aabbccccddd");
        compressString(s);

        String s1 = "akas";
        String s2 = "aksh";
        System.out.println(s1.compareTo(s2));


        String str = s1.replace("a","");
        System.out.println(str);


            // wrong
        System.out.println(anagrams("race", "carr"));


    }
}
