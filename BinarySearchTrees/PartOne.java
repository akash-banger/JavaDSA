package BinarySearchTrees;
import java.util.ArrayList;
public class PartOne {

    // binary search trees are inherently binary trees only
    // they have the properties of binary tree with some additional properties 
    /* 
     * Left subtreee nodes < Root (in value)
     * Right subtreee nodes > Root (in value)
     * Left and Right subtrees are also BSTs with no duplicates.
     */

    // BST make search efficient 

    // Special Propery: Inorder Traversal of BST gives sorted sequence 


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

    // public static void addLeft(Node root, int data){
    //     Node newNode = new Node(data);
    //     root.left = newNode;
    // }

    // public static void addRight(Node root, int data){
    //     Node newNode = new Node(data);
    //     root.right = newNode;
    // }

    // public static void add(Node root, int leftData, int rightData){
    //     Node newNode1 = new Node(rightData);
    //     Node newNode2 = new Node(leftData);
    //     root.left = newNode2;
    //     root.right = newNode1;
    // }   



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



    public static void printInorder(Node root){
        if(root == null){
            return;
        }

        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }


    public static boolean binarySearch(Node root, int key){  // time complexity O(H) H is height of the tree
        if(root == null){
            return false;
        }


        if(root.data == key){
            return true;
        }

        if(key > root.data){
            return binarySearch(root.right, key);
        }else{
            return binarySearch(root.left, key);
        }
    }


    // deleting a node int BST 

    /* 3 Cases
     * node to be deleted is a leaf => just delete it by returning null to the parent node 
     * node to be deleted have one child => just connect the parent node to the child node of this node 
     * node to be deleted have two children => find inorder successor, replace the value of the node with inorder successor and delete the inorder successor 
     */


    // inorder successor of a node is left most node in right subtree 

    public static Node findInorderS(Node root){
        if(root.left == null){
            return root;
        }

        return findInorderS(root.left);
    }





    public static Node delete(Node root, int key){
        if(key > root.data){
            root.right =  delete(root.right, key);
        }
         
        else if(key < root.data){
            root.left =  delete(root.left, key);
        }

        else{
            // case 1
            if(root.left == null && root.right == null){
                return null;
            }


            // case 2 
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }

            // case 2 

            Node inOrderS = findInorderS(root.right);
            root.data = inOrderS.data;
            root.right = delete(root.right, inOrderS.data);
        }

        return root;
    }



    public static void printRange(Node root, int k1, int k2){
        if(root == null){
            return;
        }

        if(root.data>=k1 && root.data<=k2){
            printRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printRange(root.right, k1, k2);
        }

        else if(root.data < k1){
            printRange(root.right, k1, k2);
        }

        else{
            printRange(root.left, k1, k2);
        }
    }


    public static void rootToLeaf(Node root, ArrayList<Integer> list){
        if(root == null){
            return;
        }

        list.add(root.data);

        if(root.left == null && root.right == null){
            System.out.println(list);
        }

        rootToLeaf(root.left, list);
        rootToLeaf(root.right, list);

        list.remove(list.size() - 1);
    }



    public static boolean validateBST(Node root, Node min, Node max){

        if(root == null){
            return true;
        }
       
        if(max != null){
            return root.data < max.data;
        }

        else if(min != null){
            return root.data > min.data;
        }

        return validateBST(root.left, min, root) && validateBST(root.right, root, max);
    }



    public static Node mirrorTree(Node root){    // O(n)
        if(root == null){
            return root;
        }

        Node leftMirror = mirrorTree(root.left);
        Node rightMirror = mirrorTree(root.right);

        root.left = rightMirror;
        root.right = leftMirror;

        return root;
    }



    public static void main(String arg[]){
        int values[] = {5,1,3,4,2,7};

        Node root = buildBST(values);

        printInorder(root);
        System.out.println();

        System.out.println(binarySearch(root, 5));

        // root = delete(root, 3);
        // printInorder(root);
        // System.out.println();

        printInorder(root);
        System.out.println();

        // printRange(root, 3, 5);
        // System.out.println();

        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("root to leaf");
        rootToLeaf(root, list);


        System.out.println(validateBST(root, null, null));

        root = mirrorTree(root);
        printInorder(root);
    }
}
