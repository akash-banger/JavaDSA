package Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Medium2 {
    public static void interleaveTwoHalves(Queue<Integer> q){

        Queue<Integer> q2 = new LinkedList<>();
        int n = q.size();
        for(int i=0; i<n/2; i++){
            q2.add(q.remove());
        }

        while(q.size()<10){
            q.add(q2.remove());
            q.add(q.remove());
        }
    }

    public static void qReversal(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty()){
            s.push(q.remove());
        }

        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }

    public static void main(String arg[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(1); q.add(2);
        q.add(3); q.add(4);
        q.add(5); q.add(6);
        q.add(7); q.add(8);
        q.add(9); q.add(10);
        // interleaveTwoHalves(q);
        // while(!q.isEmpty()){
        //     System.out.println(q.remove());
        // }
        qReversal(q);
        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
    }
}
