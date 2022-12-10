package Queues;

// import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueJCF {
    public static void main(String arg[]){

        Queue<Integer> q = new LinkedList<>(); // queue is an interface 

        // Queue<Integer> q = new ArrayDeque<>(); 

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
