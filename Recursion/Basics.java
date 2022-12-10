package Recursion;

public class Basics {
    // in math we used to do like this f(f(x)) or f(f(f(f(f(x))));
    // now lets implement this into code

    // RECURSION
    /* Recursion is a method of solving a computational problem where the solution depends on
     the solutions to smaller instances of the same problem;
     */

    public static int fact(int n){
        if(n==1){
            return 1;
        }
        return n*fact(n-1);
    }

    // print numbers from n to 1 in decreasing order.
    public static void printDecNums(int n){
        System.out.print(n+" ");
        if(n!=1){
            printDecNums(n-1);
        }
    }


    // print numbers from 1 to n in increasing order 
    public static void printIncNums(int n){
        if(n==0){
            return;
        }
        printIncNums(n-1);
        System.out.print(n + " ");
    }


    // print sum of n natural numbers.
    public static int sumNums(int n){
        if(n==1){
            return 1;
        }
        return n + sumNums(n-1);
    }


    // printing nth fibonacci number.
    public static int fibonacci(int n){
        if(n==0 || n==1){
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
    // refer stack analysis if fibonacci important!
    // a tree like structure will be formed 
    // with the space complexity of O(n);
    // and time complexity of O(2^n) which is very bad


    // stack overflow

    // the sitution in which our stack is full by any of the means
    // it can be bcz of too many calls
    // or it can be bcz our parameters are occupiying too much of memory 


    public static void main(String arg[]){
        System.out.println(fact(4));
        printDecNums(5);
        System.out.println();
        printIncNums(7);
        System.out.println();
        System.out.println(sumNums(5));
        System.out.println(fibonacci(5));
    }   
}
