package JavaBasics;
import java.util.*;
public class Functions {
    
    // function to check a number is palindrome or not;
    public static boolean isPalindrome(int n){
        int m = n;
        int rev = 0;
        while(n>0){
            int r = n%10;
            rev = rev*10 + r;
            n/=10;
        }
        return (rev == m);
    }

    // function to convert binary to decimal;
    public static int btod(int n){
        int dec=0;
        int counter = 0;
        while(n>0){
            int r = n%10;
            dec+= r*Math.pow(2,counter);
            counter++;
            n/=10;
        }
        return dec;
    }

    // function to convert decimal to binary;
    public static int dtob(int n){
        int b=0;
        int counter = 0;
        while(n>0){
            int r = n%2;
            b+= r*Math.pow(10,counter);
            counter++;
            n/=2;
        }
        return b;
    }

    // function to know a number is prime or not;
    // for n>=2
    public static boolean isPrime(int n){
        // corner case
        if(n==2){
            return true;
        }
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    // function to print all prime in a range; 
    // printing prime from 2 to n;
    public static void primeRange(int n){
        for(int i=2; i<=n; i++){
            if(isPrime(i)){
                System.out.print(i + " ");
            }
        }
        System.out.println("");
    }
    
    // function to find the binomial cofficient;
    public static int binomial(int n, int r){
        int nfact = 1;
        int rfact = 1;
        for(int i=n; i>=n-r; i--){
            nfact*=i;
        }
        for(int i=1; i<=r; i++){
            rfact*=i;
        }
        return nfact/rfact;
    }

    public static int sumOfTwoNumbers(int a, int b){ // here a & b are parameters or formal parameters;
        int c = a+b;
        return c;
    }
    public static void main(String arg[]){
        try (// function to add two numbers;
        Scanner sc = new Scanner(System.in)) {
            System.out.println("Sum of two nubmers");
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(sumOfTwoNumbers(a,b)); // here a & b are arguments or actual parameters;
        }
        System.out.println("Binomial coefficient");

        System.out.println(binomial(5,2));


        /// Function overloading 
        // multiple function with the same name but different parameters;
        // you can use the same name for the multiple functions but you will have to change either the datatype of the parameters given or the number of parameters
        

        // note: function overloading does not depend on the return type of the function

        primeRange(10);
        System.out.println(btod(10));

        System.out.println(dtob(5));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(321));
    }   
}