package Strings;

public class Intermediate {

     //printing the largest string for set of strings 
    public static void largestString(String array[]){
        String largeS = "";
        for(int i=0; i<array.length-1; i++){
            if(array[i].compareTo(array[i+1])>0){
                largeS = array[i];
                array[i+1] = array[i];
            }else if(array[i].compareTo(array[i+1])<0){
                largeS = array[i+1];
            }
        }
        System.out.println(largeS);
    }

    public static void main(String arg[]){
        

        // Comparing the Strings 
        String s1 = "Akash";
        String s2 = "Akash";
        String s3 = new String("Akash");
        if(s1 == s2){
            System.out.println("String are equal");
        }else{
            System.out.println("Strings are not equal");
        }
        if(s1 == s3){
            System.out.println("String are equal");
        }else{
            System.out.println("Strings are not equal");
        }


        // check the result.

        // this is happening bcz, if you make a string using the method used to make the strings s1 and s2 
        // then java will not make a new string. instead it will point to the old string so s1==s2;
        // but if you use the keyword new then, java will make a completely new string in the memory



        // but the values are equal for all the three strings.. right ?
        // then how will we compare the values.
        // if you use "==" then it will compare that string (as an object ) equal to other string (as an object);


        // to compare the values we use the following function 

        if(s1.equals(s3)){ // will return a boolean value
            System.out.println("Value of strings are equal");
        }else{
            System.out.println("value of strings are no equal");
        }



        // substring 
        // some small and contiguous part of a string 
        String s = "Hello ji";
        System.out.println(s.substring(0, 5)); // end index is excluded;



        // printing the largest string 
        String array[] = {"apple","mango","banana"};
        largestString(array);
    }
}
