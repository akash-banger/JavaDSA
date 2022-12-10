package Queues;

import java.util.Stack;


public class ImplementationUsingTwoStacks {

    static class Queue{
        Stack<Integer> mainStack = new Stack<>();
        Stack<Integer> helperStack = new Stack<>();

        public boolean isEmpty(){
            return mainStack.isEmpty();
        }

        public void add(int data){
            while(!isEmpty()){
                helperStack.push(mainStack.pop());
            }

            mainStack.push(data);

            while(!helperStack.isEmpty()){
                mainStack.push(helperStack.pop());
            }
        }


        public int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return Integer.MIN_VALUE;
            }

            return mainStack.pop();
        }


        public int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return Integer.MIN_VALUE;
            }

            return mainStack.peek();
        }

    }   
    public static void main(String arg[]){
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
