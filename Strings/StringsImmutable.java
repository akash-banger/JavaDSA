package Strings;

public class StringsImmutable {
    // whenever you make a string and then you add some character to that string to change it.
    // then a new string will be made and your varible will point to this new string instead of the previous.
    // the previous string won't change 

    // so there is a problem due to this 
    // whenever you are using a loop and with each iteration you are changing your string 
    // then new copies will be made of your string .
    // and this copying process has the time complexity of O(lenght of string);

    // for longer loops and longer strings 
    // your program will become too slow 

    // so to solve this problem we use string builder


    // string builder is another data structure which is mutable;

    public static void main(String arg[]){
        // creation of string builder 

        StringBuilder sb = new StringBuilder("");


        // toString() function will make any object to a string 
        // but it should be an object only
        // for example int n = 10; is not an object 
        // but Integer n = 10; is an object 
        // similarly Character a = 'A' is an object; 

        // we use .append() function to add something to or StringBuilder

        for(char a='a'; a<='z'; a++){
            sb.append(a);
        }

        System.out.println(sb);
    }
}
