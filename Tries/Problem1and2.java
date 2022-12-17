package Tries;

public class Problem1and2 {

    static class Node{
        Node children[] = new Node[26];
        int freq = 1;
        boolean eow = false;
        Node(){
            for(int i=0; i<children.length; i++){
                children[i] = null;
            }
        }
    }

    static Node root = new Node();

    public static void insert(String word){
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(curr.children[ch - 'a'] == null){
                curr.children[ch - 'a'] = new Node();
            }else{
                curr.children[ch-'a'].freq++;
            }
            curr = curr.children[ch - 'a'];
        }

        curr.eow = true;
    }


    public static String findPrefix(String word){
        String sol = "";
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            sol += ch;
            if(curr.children[ch - 'a'].freq == 1 || curr.children[ch - 'a'].eow == true){
                return sol;
            }
            curr = curr.children[ch - 'a'];
        }
        return sol;
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
        return curr.eow;
    }



    // problem two find that is there any word with the given prefix
    public static boolean startsWith(String prefix){
        Node curr = root;
        for(int i=0; i<prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(curr.children[ch - 'a'] == null){
                return false;
            }

            curr = curr.children[ch - 'a'];
        }
        return true;
    }



    public static void main(String arg[]){
        // find the smallest possible unique prefix of word in array of words 
        String words[] = {"zebra", "dog", "duck", "dove"};
        for(int i=0; i<words.length; i++){
            insert(words[i]);
        }


        String sol[] = new String[words.length];
        for(int i=0; i<words.length; i++){
            sol[i] = findPrefix(words[i]);
        }

        for(int i=0; i<sol.length; i++){
            System.out.println(sol[i]);
        }

        // refer mam's solution also whenever revising 


        // startsWith problem 
        System.out.println(startsWith("zeb"));

    }
}
