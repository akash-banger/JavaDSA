package Hashing;

import java.util.ArrayList;
import java.util.LinkedList;

public class ImplementationHashMap {

    // Implementation of hashmap 
    // hashmap is Implemented as Array of linkedlist 
    // and this array's indexes are called buckets 
    // so each bucket containts a linkedlist with some number of nodes 
    // these number of nodes are evenly spreaded in all the buckets 
    // so if we add a pair in our hashMap 
    // first the key will go to the hashFunction which will return a bucket index in O(1)
    // and now in this bucket we will iterate to the linked list and if the key already exist than will update the value 
    // otherwise we will add this pair of key value;

    // now wht will be the TimeComplexity will be lamda(n/N) here small n is total number of pairs and N is number of buckets 
    // now as the total pairs are evenly spreaded in all the buckets so each bucket will have n/N pairs so iteration will be n/N times 
    // and we will maintain n/N as some k if it increases(means n increases) we will make a new array of some greater N than before and store all the pairs into this new array one by one.
    // this process of making new array is called reHashing.

    static class Hashmap <K,V>{  // generic => means K and V data types are not fix it will be given later

        private class Node{
            K key;
            V val;

            public Node(K key, V val){
                this.key = key;
                this.val = val;
            }
        }

        private int n;  // n 
        private int N;  // N
        private LinkedList<Node> buckets[];  // buckets.length = N

        @SuppressWarnings("unchecked")
        public Hashmap(){
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i=0; i<4; i++){
                buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key){
            int hc = key.hashCode();
            return Math.abs(hc) % buckets.length;
        }

        private int searchInLL(int bi, K key){
            LinkedList<Node> ll = buckets[bi];
            int idx = 0;
            for(int i=0; i<ll.size(); i++){
                Node node = ll.get(i);
                if(node.key == key){
                    return idx;
                }
                idx++;
            }
            return -1;
        }


        @SuppressWarnings("unchecked")
        private void reHash(){
            LinkedList<Node> oldBuckets[] = buckets;
            buckets = new LinkedList[2*N];
            N = 2*N;

            for(int i=0; i<buckets.length; i++){
                buckets[i] = new LinkedList<>();
            }

            for(int i=0; i<oldBuckets.length; i++){
                LinkedList<Node> ll = oldBuckets[i];
                for(int j=0; j<ll.size(); j++){
                    Node node = ll.remove();
                    put(node.key, node.val);
                }
            }
        }


        public void put(K key, V val){
            int bi = hashFunction(key);
            int di = searchInLL(bi, key);

            if(di == -1){ // add
                buckets[bi].add(new Node(key, val));
                n++;
            }else{ // update
                Node node = buckets[bi].get(di);
                node.val = val;
            }

            double lamda = (double) n/N;

            if(lamda > 2.0) {
                reHash();
            }
        }


        public boolean contains(K key){
            int bi = hashFunction(key);
            int contain = searchInLL(bi, key);
            if(contain != -1){
                return true;
            }
            return false;
        }


        public V get(K key){
            int bi = hashFunction(key);
            int di = searchInLL(bi, key);
            if(di != -1){
                Node node = buckets[bi].get(di);
                return node.val;
            }
            return null;
        }


        public V remove(K key){
            int bi = hashFunction(key);
            int di = searchInLL(bi, key);
            if(di != -1){
                Node node = buckets[bi].remove(di);
                n--;
                return node.val;
            }
            return null;
        }


        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            for(int i=0; i<buckets.length; i++){
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty(){
            return n == 0;
        }

    }


    public static void main(String arg[]){
        Hashmap<String, Integer> hm = new Hashmap<>();
        hm.put("china", 150);
        hm.put("india", 100);
        hm.put("US", 50);
        hm.put("UK", 0);
        hm.put("indonesia", 5);
        hm.put("canada", 80);

        System.out.println(hm.contains("india"));

        
        ArrayList<String> keys = hm.keySet();
        
        for (String key : keys) {
            System.out.println("key:" + key + ", " + "value:" + hm.get(key));
        }
        
        System.out.println();
        hm.remove("indonesia");
        hm.remove("china");

        keys = hm.keySet();


        for (String key : keys) {
            System.out.println("key:" + key + ", " + "value:" + hm.get(key));
        }


        // in worst case some rare case 
        // sometimes it happens that you pass the key to the hashcode function and it always returns 
        // you 0 or some other index 
        // in that case you will add all the elements in one bucket only

        // and your TimeComplexity will become O(n)
    }
}
