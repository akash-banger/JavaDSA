package Queues;



public class ImplementationUsingLL {

    // implementation of Queue using LL
    static class Queue{


        static Node head;
        static Node tail;
        static class Node{
            int data;
            Node next;

            Node(int data){
                this.data = data;
                this.next = null;
            }
        }


        public boolean isEmpty(){
            return head == null;
        }


        public void add(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = tail = newNode;
                return;
            }

            tail.next = newNode;
            tail = newNode;

        }

        public int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return Integer.MIN_VALUE;
            }
            if(head.next == null){
                int val = head.data;
                head = tail = null;
                return val;
            }

            int val = head.data;
            head = head.next;

            return val;
        }


        public int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return Integer.MIN_VALUE;
            }
            return head.data;
        }



    }



    public static void main(String arg[]){
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
