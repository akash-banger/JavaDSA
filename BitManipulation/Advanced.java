package BitManipulation;

public class Advanced {

    // fast expo 
    public static int fastExpo(int a, int n){
        int ans = 1;
        while(n>0){
            int m = n & 1;
            if(m==1){
                ans*=a;
            }
            a*=a;
            n = n>>1;
        }
        return ans;
    }



    // swaping two numbers without using the third varible
    // using the concept a^a==0; a xor a = 0;
    public static void swapNum(int a, int b){
        a = (a^b);
        b = a^b;
        a = a^b;
        System.out.println(a+","+b);
    }



    // adding one to a number using BitManipulation

    // the expression -(~x) will add 1 to x;
    public static int bitAddOne(int n){
        return -(~n);
    }



    // converting all uppercase letters to lowercase
    public static void convertToLower(){
        for(char a='A'; a<='Z'; a++){
            System.out.print((char) (a | ' ') + " ");
        }
    }



    public static void main(String arg[]){
        // fast exponentiation
        System.out.println(fastExpo(3,5));



        // swaping two numbers without using the third varible
        swapNum(3,8);



        // adding one to an integer using BitManipulation
        System.out.println(bitAddOne(5));



        // converting all uppercase letters to lowercase
        convertToLower();
    }
}
