package Queues;

public class ImplementationUsingArrays {
    // Queues
    // this is a FIFO (first in first out) data structure
    /* three operations on que 
     * Add (adding the element at last)
     * Remove (removing the element from front)
     * peek (checking the front element)
    */

    static class Queue{
        int que[];
        static int size;
        static int rear;
        static int front; // added later 
        
        // constructor 
        Queue(int n){
            que = new int[n];
            size = n;
            rear = -1;
            front = -1; // added later
        }

        public boolean isEmpty(){
            return front == -1 && rear == -1; // changed later for circular
        }

        public boolean isFull(){
            return (rear+1)%size == front;
        }


        // add 
        public void add(int data){ 
            if(isFull()){
                System.out.println("Queue is full");
                return;
            }
            // rear++;
            if(front == -1){
                front = 0;
            }
            rear = (rear+1)%size;
            que[rear] = data;
        }


        //remove 
        public int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return Integer.MIN_VALUE;
            }


            // int front = que[0];
            
            // for(int i=0; i<rear; i++){ // O(n) to tackle this we use circular queue 
                //     que[i] = que[i+1];          // means instead of shifted elements we will shift front 
                // }
                
            // return front;
            // last element 
            int val = que[front];
            
            if((rear == front)){
                rear = front = -1;
            }else{
                front = (front+1)%size;
            }

            return val;
        }

        // peek
        public int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return Integer.MIN_VALUE;
            }
            return que[front];
        }
    }
    public static void main(String arg[]){
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
