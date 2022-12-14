package Hashing;

import java.util.TreeMap;

public class Treemap {
    public static void main(String arg[]){
        // tree map have additional property 
        // that the keys are in the sorted order 

        // put, get and remove are O(logn)

        TreeMap<Integer, String> tm = new TreeMap<>();

        tm.put(1, "one");
        tm.put(5, "five");
        tm.put(3, "three");
        tm.put(8, "eight");
        tm.put(2, "two");
        tm.put(4, "four");

        System.out.println(tm);

        // Implementation is done by Red Black Trees ( self balancing BSTs)
    }
}
