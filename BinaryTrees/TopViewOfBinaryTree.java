package BinaryTrees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


public class TopViewOfBinaryTree {
    static class Node{
        int data; 
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void add(Node root, int left, int right){
        Node leftNode = new Node(left);
        Node righNode = new Node(right);

        root.left = leftNode;
        root.right = righNode;
    }   


    static class Info{
        Node node;
        int hd;

        Info(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }


    // top view 
    public static void topView(Node root){
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        q.add(new Info(root, 0));
        q.add(null);
        int min = 0;
        int max = 0;
        while(!q.isEmpty()){

            Info curr = q.remove();

            if(curr == null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }  
            else{
                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd, curr.node);
                }

                if(curr.node.left != null){
                    q.add(new Info(curr.node.left, curr.hd -1));
                    min = Math.min(curr.hd - 1, min);
                }

                if(curr.node.right != null){
                    q.add(new Info(curr.node.right, curr.hd + 1));
                    max = Math.max(curr.hd + 1, max);
                }
            }
        }


        for(int i=min; i<=max; i++){
            System.out.print(map.get(i).data + " ");
        }

        System.out.println();
    }

    public static void main(String arg[]){



        /*   tree
                      1
                    /   \
                   2     3
                  / \   / \
                 4   5 6   7

         */


        Node root = new Node(1);    
        add(root, 2, 3);
        add(root.left, 4,5);
        add(root.right, 6,7);

        topView(root);
    }
}
