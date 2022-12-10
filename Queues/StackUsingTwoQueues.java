package Queues;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueues {

    static class Stack{
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        public boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }


        public void push(int data){
            if(!q1.isEmpty()){
                q1.add(data);
            }else{
                q2.add(data);
            }
        }


        public int pop(){
            int top = 0;
            if(isEmpty()){
                System.out.println("Stack is empty");
                return Integer.MIN_VALUE;
            }

            if(!q1.isEmpty()){
                while(!q1.isEmpty()){  
                    top = q1.remove();
                    if(q1.isEmpty()){
                        break;
                    }
                    q2.add(top);
                }
            }else{
                while(!q2.isEmpty()){  
                    top = q2.remove();
                    if(q2.isEmpty()){
                        break;
                    }
                    q1.add(top);
                }
            }

            return top;
        }



    }
    public static void main(String arg[]){
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
}
