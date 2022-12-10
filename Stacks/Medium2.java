package Stacks;

import java.util.Stack;

public class Medium2 {
    public static boolean validParentheses(String str){
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char curr = str.charAt(i);
            if(curr == '(' || curr == '[' || curr == '{'){
                s.push(curr);
            }else{
                if(s.isEmpty()){
                    return false;
                }
                int a = curr - s.peek();
                if(a==1 || a==2){
                    s.pop();
                }else{
                    return false;
                }
            }
        }
        if(s.isEmpty()){
            return true;
        }
        return false;
    }
    public static void main(String arg[]){
        String str = "({})[]";
        System.out.println(validParentheses(str));
    }
}
