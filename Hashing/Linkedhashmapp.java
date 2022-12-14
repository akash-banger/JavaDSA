package Hashing;

import java.util.LinkedHashMap;

public class Linkedhashmapp {
    // linked hash map have same properties as hashmap 
    // with an additional property of ordered key insertion

    // you will get the key first which is added first 

    public static void main(String arg[]){
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("india", 180);
        lhm.put("china", 150);
        lhm.put("US", 50);
        lhm.put("UK", 0);
        lhm.put("indonesia", 5);
        lhm.put("canada", 80);

        System.out.println(lhm); // ordered



        // TimeComplexity is same as hashmap 
        // Implementation is using same array and LinkedList but we use doubly linkedlist in this case
    }
    
}
