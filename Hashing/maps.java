package Hashing;

import java.util.HashMap;
import java.util.Set;

public class maps {
    // Hashing is used to convert one data type to some other 
    // with a hash function 

    // we make two data Structures using Hashing 
    /* 
     * Map: HashMap, linkedHashMap, TreeMap
     * Set: HashSet, linkedHashSet, TreeSet
     */

    // HashMap => a pair of value and a key (where each key has a unique value)
    // TimeComplexity for insert, remove and search is O(1) only


    public static void main(String arg[]){
        HashMap<String, Integer> menu = new HashMap<>();
        menu.put("Coffee", 10);
        menu.put("Tea", 15);
        menu.put("Samosa", 20);
        menu.put("Bread", 10);

        System.out.println(menu.get("Coffee"));
        System.out.println(menu.containsKey("Tea"));
        System.out.println(menu.remove("Bread"));
        menu.put("Tea", 100);
        System.out.println(menu.get("Tea"));

        System.out.println(menu);



        // iteration on hashmaps
        // you can use entrySet also it will give you pair of both the key and the value
        Set<String> keys = menu.keySet();

        System.out.println(keys);

        for (String k : keys) {
            System.out.println("key:" + k + ", " + "Value: " + menu.get(k));
        }
        
    }
}
