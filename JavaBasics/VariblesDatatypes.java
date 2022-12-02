package JavaBasics;
import java.util.*;
public class VariblesDatatypes { // file name and the class name should be same .!!
    public static void main(String arg[]){
        System.out.print("Hello World!!\n");
        System.out.println("Hello World??"); /// println will give a line space after printing your value.

        // Two types of datatypes: primitive and non-primitive

        // primitive: already exist in java eg. int, short , char, boolean, byte etc.
        // non-primitive: we have to create them eg. string, array, Class, Object, Interface

        // Size of datatypes: 
        // 1 byte = 8 bits 

        // byte = 1 byte [-128 to 127]
        // short = 2 bytes
        // char = 2 bytes
        // boolean = 1 byte
        // int = 4 bytes
        // long = 8 bytes
        // float = 4 bytes
        // double = 8 bytes


        // Input in java

        // try(Scanner sc = new Scanner(System.in)){ // to avoid sc never closed
        //     String input = sc.next();
        //     System.out.println(input);
        // }

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("input string");
            String input = sc.next();
            System.out.println(input);


            // sc.next(); // used to capture string till a space 
            // sc.nextLine(); // used to capture the entire line including space
            // sc.nextInt(); // for capturing integer
            // sc.nextFloat(); // float value

            // sum of a and b 
            System.out.println("sum of two numbers");
            int a = sc.nextInt();
            int b = sc.nextInt(); 
            int c = a+b;
            System.out.println(c);
        }
        


        // type conversion in java

        int x = 3; 
        long y = x; // will work because long have more size than int
        System.out.println(y);

        // long u = 3;
        // int v = u;
        // System.out.println(v); // will not work bcz of size 

        // So for type conversion: 
        // a. type compatible
        // b. destinatin type >= sourse type




        // type casting in java: 
        float f = 4.322f; // including f to make it float, otherwise will have to use double as datatype
        // int i = f; // won't work lossy conversion 
        int i = (int) f;
        System.out.println(i);




        // type promotion in java;
        // a. java automatically promote byte, char and short to int when evaluating an expression;
        // b. if one operand is double, float or long thn the whole expression converts to double, float or long respectively;

        // java is portable language and c++ is not. 
        // means if you write code in java in any machine eg. mac or linux it will run in every other machine but for c++ it won't 
        // get to know about this more and make a youtube video.   
    }
}
// BoilerPlate code 


// for compiling: javac filename.java
// for running : java filename.java 



