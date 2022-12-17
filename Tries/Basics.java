package Tries;


public class Basics {


    static class Node{
        Node children[] = new Node[26];
        boolean endOfWord = false;

        Node(){
            for(int i=0; i<26; i++){
                children[i] = null;
            }
        }
    }

    static Node root = new Node();

    public static void insert(String word){   // O(L) L is the length of largest word
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            int ch = word.charAt(i);
            if(curr.children[ch - 'a'] == null){
                Node newNode = new Node();
                curr.children[ch - 'a'] = newNode;
            }
            curr = curr.children[ch - 'a'];
        }
        curr.endOfWord = true;
    }

    public static boolean search(String word){
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            int ch = word.charAt(i);
            if(curr.children[ch-'a'] == null){
                return false;
            }
            curr = curr.children[ch - 'a'];
        }
        return curr.endOfWord;
    }



    public static boolean wordBreak(String key){   // O(L)

        if(key.length() == 0){
            return true;
        }

        for(int i=1; i<=key.length(); i++){
            if(search(key.substring(0,i)) && wordBreak(key.substring(i))){
                return true;
            }
        }
        return false;
    }


    public static void main(String arg[]){
        // Trie is also called as prefix tree or retrieval tree 
        // in which we store the prefix of some words whose prefixes are similar 


        // it is a k-ary tree means it will have atmax of k child of each parent 

        String words[] = {"i", "like", "sam", "samsung", "moble", "ice"};

        for(int i=0; i<words.length; i++){
            insert(words[i]);
        }

        // System.out.println(search("there"));


        // WordBreak problem 
        // you are given a array of words and a String key
        // you have to find that can you make your key using the words in the array 

        System.out.println(wordBreak("ilikesamsung")); // words are above 
    }
}
