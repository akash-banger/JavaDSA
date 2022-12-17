package Tries;

public class Problem4 {


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


    public static String ans = "";

    public static void longestWordPrefixes(Node root, StringBuilder temp){
        if(root == null){
            return;
        }

        for(int i=0; i<26; i++){
            if(root.children[i] != null && root.children[i].eow == true){
                char ch = (char) (i+'a');
                temp.append(ch);
                if(ans.length() < temp.length()){
                    ans = temp.toString();
                }
                longestWordPrefixes(root.children[i], temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }




    public static void main(String arg[]){
        // find the longest word containing all the prefixes 

        String words[] = {"a", "banana", "app", "appl", "ap", "apple", "apply"};

        for(int i=0; i<words.length; i++){
            insert(words[i]);
        }

        longestWordPrefixes(root, new StringBuilder(""));

        System.out.println(ans);
    }
}
