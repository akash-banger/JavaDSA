package Stacks;

import java.util.Stack;

public class Medium3 {
    public static boolean isDuplicate(String str){
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char curr = str.charAt(i);
            if(curr != ')'){
                s.push(curr);
            }else{
                int count = 0;
                while(s.peek() != '('){
                    s.pop();
                    count++;
                }
                if(count == 0){
                    return true;
                }
                s.pop();
            }
        }
        return true;
    }
    public static void main(String arg[]){
        String str = "((a+b)+(c+d))";
        System.out.println(isDuplicate(str));
    }
}
