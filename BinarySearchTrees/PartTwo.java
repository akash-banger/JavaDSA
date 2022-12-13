package BinarySearchTrees;

import java.util.LinkedList;
import java.util.Queue;

public class PartTwo {


    static class Node {
        int data;
        Node right;
        Node left;

        Node(int data){
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }



     // building a BST with given values 
     public static void insert(Node root, Node newNode){
        if(newNode.data > root.data){
            if(root.right == null){
                root.right = newNode;
                return;
            }
            insert(root.right, newNode);
        }else{
            if(root.left == null){
                root.left = newNode;
                return;
            }
            insert(root.left, newNode);
        }
    }



    public static Node buildBST(int values[]){

        Node root = new Node(values[0]);

        for(int i=1; i<values.length; i++){
            Node newNode = new Node(values[i]);
            insert(root, newNode);
        }

        return root;
    }




    // sorted array to build balanced BST (min possible height)
    public static Node buildBalancedBST(int values[], int si, int ei){

        if(si>ei){
            return null;
        }

        int mid = si + (ei - si)/2;

        Node root = new Node(values[mid]);

        root.left = buildBalancedBST(values, si, mid -1);
        root.right = buildBalancedBST(values, mid + 1, ei);

        return root;
    }   



    public static void printInorder(Node root){
        if(root == null){
            return;
        }

        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }


    public static void printLevel(Node root){
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                q.add(null);
            }

            else{
                System.out.print(curr.data + " ");
                if(curr.left != null){
                    q.add(curr.left);
                }   

                if(curr.right != null){
                    q.add(curr.right);
                }
            }

        }
    }




    public static void main(String arg[]){
        int arr[] = {3,5,6,8,10,11,12};
        Node root = buildBalancedBST(arr, 0, arr.length -1);


        printInorder(root);
        System.out.println();

        printLevel(root);


        


        // converting a BST to a balanced BST 
        // firstly make a sorted array from this bst by inorder traversal 
        // than make a BST using this sorted array
    }
}
