package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueues {
    static class Student implements Comparable<Student>{
        String name;
        int rank;

        Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2){   // to compare the students on rank basis
            return this.rank - s2.rank;
        }
    }

    // priority Queue is like a Queue with priority 
    // the element with highest priority will be first and lowest priority will be last 


    public static void main(String arg[]){
        // priority Queue in JCF 

        // for integers the lesser the value of integer the highest the priority of the integer (ascending order by default)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(3); // O(log n)
        pq.add(2);
        pq.add(1);
        pq.add(5);
        pq.add(4); // no matter in which order you add the elements, they will be removed priority wise (by default ascending)

        System.out.println(pq.remove()); // O(logn)
        System.out.println(pq.peek());      // O(1)

        while(!pq.isEmpty()){
            System.out.print(pq.peek() + " ");
            pq.remove();
        }
        System.out.println();

        /// for descending 

        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());
        pq2.add(3);
        pq2.add(2);
        pq2.add(1);
        pq2.add(5);
        pq2.add(4);

        while(!pq2.isEmpty()){
            System.out.print(pq2.remove() + " ");
        }
        System.out.println();



        /// priority list of objects 

        PriorityQueue<Student> students = new PriorityQueue<>();
        students.add(new Student("Akash", 15000));
        students.add(new Student("banger", 100));
        students.add(new Student("mohit", 15));
        students.add(new Student("lohit", 10000));
        students.add(new Student("chohit", 1500));


        while(!students.isEmpty()){
            System.out.println(students.peek().name + "->" + students.peek().rank);
            students.remove();
        }
    }   
}
