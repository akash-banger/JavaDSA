package WeiredStuff;

public class WeiredStuff {
    public static void permutations(String str, String perm){

        if(str.length()==0){
            System.out.println(perm);
            return;
        }

        for(int i=0;i<str.length();i++){
            char currchar = str.charAt(i);
            String newstr = str.substring(0, i)+str.substring(i+1);
            System.out.println(newstr+ "1");
            // perm = perm+currchar;
            // System.out.println(perm);
            permutations(newstr,perm + currchar);

        }
    }
    public static void main(String args[]){
        permutations("ABC","");
    }
}