package Tries;

public class Problem3 {


    static class Node{
        Node children[] = new Node[26];
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
            }
            curr = curr.children[ch - 'a'];
        }
        curr.eow = true;
    }


    public static int countNodes(Node root){
        if(root == null){
            return 0;
        }
        int count = 0;

        for(int i=0; i<26; i++){
            if(root.children[i] != null){
                count+= countNodes(root.children[i]);
            }
        }

        return count + 1;
    }




    public static void main(String arg[]){
        // to find the unique substrings of a given string 
        

        // CONCEPT => unique substrings = all unique prefixes of all suffixes 

        // and trie by default stores unique prefixes

        // unique prefixes in a trie is count of number of nodes
        String s = "ababa";

        for(int i=0; i<s.length(); i++){
            insert(s.substring(i));
        }

        System.out.println(countNodes(root));

        
    }
}
