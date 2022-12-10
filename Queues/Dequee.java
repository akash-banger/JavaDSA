package Queues;

import java.util.LinkedList;
import java.util.Deque;

public class Dequee {

    // Deque means double ended que 
    // Dequeue (method, action) means removing an element from que don't get confused between both

    public static void main(String arg[]){
        Deque<Integer> dq = new LinkedList<>();

        dq.addFirst(2);
        dq.addFirst(1);
        dq.addLast(3);
        dq.addLast(4);
        dq.addLast(5);

        dq.removeLast();
        dq.removeFirst();

        System.out.println(dq);
    }
}
