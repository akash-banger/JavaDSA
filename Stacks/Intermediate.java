package Stacks;


import java.util.*;


public class Intermediate {

    // push at the bottom of the stack 
    public static void pushAtBottom(Stack<Integer> s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }

        int val = s.pop();
        pushAtBottom(s, data);
        s.push(val);
    }


    // reverse a string using stack 
    public static void reverseString(StringBuilder str){
        Stack<Character> ss = new Stack<>();
        for(int i=0; i<str.length(); i++){
            ss.push(str.charAt(i));
        }

        str.replace(0, str.length(), "");
        while(!ss.isEmpty()){
            str.append(ss.pop());
        }
    }


    // reverse a stack 
    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }

        int val = s.pop();
        reverseStack(s);
        pushAtBottom(s, val);
    }

    static int[] stackSpanProblem(int array[]){
        Stack<Integer> s = new Stack<>();
        s.push(0);
        int span[] = new int[array.length];
        span[0] = 1;
        for(int i=1; i<span.length; i++){
            while(array[s.peek()]<=array[i]){
                s.pop();
                if(s.isEmpty()){
                    break;
                }
            }
            if(s.isEmpty()){
                span[i] = i+1;
            }else{
                span[i] = i - s.peek();
            }

            s.push(i);
        }
        return span;
    }




    public static void main(String arg[]){
        // stack using JCF 
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        pushAtBottom(s, 4);

        reverseStack(s);
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }

        StringBuilder str = new StringBuilder("hsaka");
        reverseString(str);
        System.out.println(str);

        int arr[] = {100,80,60,70,60,85,100};
        int sol[] = stackSpanProblem(arr);

        for(int i=0; i<sol.length; i++){
            System.out.print(sol[i] + " ");
        }
        System.out.println();
    }
}
