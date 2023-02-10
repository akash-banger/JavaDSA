package Stacks;

import java.util.Stack;
import java.util.concurrent.SynchronousQueue;

public class Problems {

    static class Node{
        char data;
        Node next;

        Node(char data){
            this.data = data;
            this.next = null;
        }
    }   

    // checking the ll is a palindrome or not
    public static boolean isPalindrome(Node head){
        Stack<Character> s = new Stack<>();
        Node temp1 = head;
        Node temp2 = head;

        while(temp1 != null){
            s.add(temp1.data);
            temp1 = temp1.next;
        }   

        while(temp2 != null){
            if(s.pop() != temp2.data){
                return false;
            }
            temp2 = temp2.next;
        }

        return true;
    }



    // simplifying the path 
    public static String simplifyPath(String path){
        Stack<String> s = new Stack<>();
        String newPath = new String("");

        for(int i=0; i<path.length(); i++){
            String dir = "";
            while(i<path.length() && path.charAt(i) == '/'){
                i++;
            }

            while(i<path.length() && path.charAt(i) != '/'){
                dir += path.charAt(i);
                i++;
            }

            if(dir.equals("..")){
                if(!s.isEmpty()){
                    s.pop();
                }
            }
            else if(dir.equals(".")){
                continue;
            }

            else if(dir.length() != 0){
                s.push(dir);
            }
        }

        Stack<String> s2 = new Stack<>();

        while(!s.isEmpty()){
            s2.push(s.pop());
        }


        while(!s2.isEmpty()){
            newPath += "/" + s2.pop();
        }

        return newPath;
    }


    // decoding the string 
    public static String decode(String st){
        Stack<Character> stringStack = new Stack<>();
        Stack<Integer> intStack = new Stack<>();
        String result = "", temp = ""; 

        for(int i=0; i<st.length(); i++){

            int count = 0;

            if(Character.isDigit(st.charAt(i))){
                while(Character.isDigit(st.charAt(i))){
                    count = count*10 + (st.charAt(i) - '0');
                    i++;
                }
                intStack.push(count);
                i--;
            }


            else if(st.charAt(i) == '['){
                stringStack.push(st.charAt(i));
                if(i!=0){
                    if(!Character.isDigit(st.charAt(i-1))){
                        intStack.push(1);
                    }
                }else{
                    intStack.push(1);
                }
            }

            else if(st.charAt(i) == ']'){
                temp = "";
                count = 0;

                if(!intStack.isEmpty()){
                    count = intStack.pop();
                }

                while(!stringStack.isEmpty() && stringStack.peek()!='['){
                    temp = temp + stringStack.pop();
                }

                if(stringStack.peek() == '['){
                    stringStack.pop();
                }

                for(int j=0; j<count; j++){
                    result = result + temp;
                }

                for(int j=0; j<result.length(); j++){
                    stringStack.push(result.charAt(j));
                }

                result = "";
            }

            else{
                stringStack.push(st.charAt(i));
            }

        }

        while(!stringStack.isEmpty()){
            result = result + stringStack.pop();
        }

        return result;

    }



    public static void main(String arg[]){
        // checking a linkedList of characters is a palindrome or not
        Node head = new Node('A');
        head.next = new Node('B');
        head.next.next = new Node('C');
        head.next.next.next = new Node('B');
        head.next.next.next.next = new Node('A');

        System.out.println(isPalindrome(head));


        String path = "/a/b/../akash/";

        String sPath = simplifyPath(path);

        System.out.println(sPath);


        // decoding the string 
        System.out.println(decode(new String("3[b2[v]]")));


    }
}
