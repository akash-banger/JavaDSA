package Queues;

import java.util.Deque;
import java.util.LinkedList;

public class ImplementStackUsingDQ {

    static class Stack{
        Deque<Integer> dq = new LinkedList<>();

        public boolean isEmpty(){
            return dq.isEmpty();
        }

        public void push(int data){
            dq.addFirst(data);
        }


        public int pop(){
            return dq.removeFirst();
        }

        public int peek(){
            return dq.getFirst();
        }

    }
    public static void main(String arg[]){
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}


// you can implement the queue also using the deque;
