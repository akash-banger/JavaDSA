package Stacks;


public class Basics {

    // Stacks: data Structure in which the data is stored up on one another 
    // we studied stacks in recursion 
    // How in memory a stack is made and functions are called after one and other
    // the stack we studied at that time is implicit stack 
    // means it is made by the computer itself
    // Now we shall talk about the explicit stack means made by us 


    /* three type of operations 
     * push  // O(1)
     * pop  // O(1)
     * peek  // O(1)
    */

    // stacks are called as LIFO data Structure (Last in first out)

    // implenting stack using arraylist 
    // static class Stack{
    //     static ArrayList<Integer> list = new ArrayList<>();

    //     // checking empty 
    //     static public boolean isEmpty(){
    //         return list.size() == 0;
    //     }

    //     // push 
    //     static public void push(int data){
    //         list.add(data);
    //     }

    //     // pop 
    //     static public int pop(){
    //         if(isEmpty()){
    //             System.out.println("stack is empty");
    //             return -1;
    //         }
    //         int top = list.get(list.size()-1);
    //         list.remove(list.size() -1 );
    //         return top;
    //     }

    //     // peek 
    //     static public int peek(){
    //         if(isEmpty()){
    //             System.out.println("stack is empty");
    //             return -1;
    //         }
    //         return list.get(list.size() -1);
    //     }
    // }



    // stack implentation using linkedlist 

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static class Stack{
        static Node head = null;

        static boolean isEmpty(){
            return (head == null);
        }

        // push 
        static void push(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = newNode;
                return;
            }

            newNode.next = head;
            head = newNode;
        }

        // pop
        static int pop(){
            if(head == null){
                System.out.println("stack is empty");
                return Integer.MIN_VALUE;
            }

            int val = head.data;
            head = head.next;
            return val;
        }


        // peek 
        static int peek(){
            if(head == null){
                System.out.println("stack is empty");
                return Integer.MIN_VALUE;
            }
            return head.data;
        }
    }









    public static void main(String arg[]){
        // Stack stack = new Stack();
        Stack.push(3);
        Stack.push(2);
        Stack.push(1);
        while(!Stack.isEmpty()){
            System.out.println(Stack.peek());
            Stack.pop();
        }
    }
}
