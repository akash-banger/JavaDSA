package BitManipulation;

public class Basics {
    // odd or even
    public static void oddEven(int n){
        // 0000, 0001, 0010, 0011, 0100, 0101, 0110, 0111, 1000, 1001
        // here for odd number lsb is 1 and for even numbers lsb is 0
        // so we just have to find the lsb
        // lets take & of the number with 1 means 00000001
        // this will give 1 if the lsb is one and 0 if the lsb is 0;

        int test = 1;
        if((n & test) == 0){
            System.out.println("Even");
        }else{
            System.out.println("Odd");
        }
    }
    public static void main(String arg[]){
        /// binary and (&)
        System.out.println(15 & 16); // will give 0
        

        // binary or (|)
        System.out.println(15 | 16); // will give 31

        // binary xor (^)
        System.out.println(5 ^ 6);  // will give 3

        // binary not(~)
        System.out.println(~5); // will give -6 
        System.out.println(~0); // will give -1

        // how to find the decimal number from a binary number which is representing a nagetive number
        // take the not of that binary number and then add 1. the resulting binary number will give you the 
        // magnitude of ur decimal number

        // least significant bit (right most bit) (LSB)
        // most significant bit (left most bit) (MSB) // used to represent nagetive numbers



        // binary left shift operator 
        // here binary of 5 is 000101
        // here all the bits of 5 will shift to left by 2 units 
        // and the empty 2 spaces at right will become 0;
        System.out.println(5<<2); // a<<b = a * 2^b // 2 power b;


        // binary right shift operator 
        System.out.println(6>>1);  /// a>>b = a / 2^b ;


        /// checking odd even
        oddEven(6);
    }
}
