package Hashing;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Sets {

    // A set is collection of distinct elements 

    /* 
     * Null allowed
     * No duplicates 
     * Unordered
     */
    public static void main(String arg[]){

        // hash set
        HashSet<Integer> hs = new HashSet<>();
        // add, contains, remove all are O(n)

        hs.add(1);
        hs.add(2);
        hs.add(3);
        hs.add(4);
        hs.add(5);  

        // hash set is implemented using hash map only
        // here key goes as our hashset value so each key is unique 
        // and random values are stored in hashmap 

        // System.out.println(hs.contains(4));
        // System.out.println(hs.isEmpty());
        // System.out.println(hs.remove(4));
        // System.out.println(hs.contains(4));

        // System.out.println(hs);
        // hs.clear();


        hs.add(6);
        hs.add(7);

        System.out.println(hs);

        // iteration on hashset 
        // first way
        Iterator<Integer> it = hs.iterator();  // initial the iterator will point to a null value it would have some nxt element or it can have no next value also 

        while(it.hasNext()){  // O(n)
            System.out.print(it.next() + " ");
        }
        System.out.println();


        // second way 
        for(Integer k: hs){
            System.out.print(k + " ");
        }
        System.out.println();



        // Linked HashSet => ordered set ( the order of insertion is maintained)
        // if something is added first it will be shown first 

        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        lhs.add(8);
        lhs.add(7);
        lhs.add(9);
        lhs.add(2);
        lhs.add(1);
        System.out.println(lhs);

        // performance 
        // HashSet < Linked HashSet 
        // HashMap < Linked HashMap 
        // but TimeComplexity almost remains same



        // TreeSet => sorted in ascending order 
        // NUll values are not allowed 
        // implemented using TreeMap ( which is implemented using Red Black Trees)
        // insert remove O(logn)
        
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(7);
        ts.add(9);
        ts.add(4);
        ts.add(1);
        ts.add(5);

        System.out.println(ts); // sorted 


    }
}
