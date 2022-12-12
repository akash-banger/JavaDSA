package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class PartOne {

    // binary tree is a hierarchical data structure 
    /* a hierarchical data structure is like a tree with a root then multiple nodes from that root
     and than multiple leafs from those nodes and so on.
     */
    // now binary tree is special type of hierarchical structure in which
    // each node can have atmost 2 child nodes.

    // building the tree 
    // you will be given a preorder sequence 
    // iterate through this sequence firstly make the root
    // thn make the left node and right node 


    // lets build 
    static class Node{
        int data;
        Node right;
        Node left;

        Node(int data){
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    static class BinaryTree{
        static int idx = -1;
        public Node buildTree(int nodes[]){
            idx++;
            
            if(nodes[idx] == -1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }


    // preorder traversal (root left right)
    public static void printPreorderTree(Node root){
        if(root == null){
            // System.out.print(-1 + " "); // to include -1 also in case of null
            return;
        }

        System.out.print(root.data + " ");

        printPreorderTree(root.left);
        printPreorderTree(root.right);
    }

    // Inorder traversal (left root right)
    public static void printInorderTree(Node root){
        if(root == null){
            // System.out.print(-1 + " "); // to include -1 also in case of null
            return;
        }
        printInorderTree(root.left);
        System.out.print(root.data + " ");
        printInorderTree(root.right);

    }

    // post order traversal (left right root)
    public static void printPostorderTree(Node root){
        if(root == null){
            // System.out.print(-1 + " "); // to include -1 also in case of null
            return;
        }
        printPostorderTree(root.left);
        printPostorderTree(root.right);
        System.out.print(root.data + " ");

    }


    // level order traversal (level wise print)
    public static void printLevelorderTree(Node root){
        if(root == null){
            return;
        }
        // int count = 0; for getting height

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            if(q.peek()!=null){
                if(q.peek().left != null){
                    q.add(q.peek().left);
                }
                if(q.peek().right != null){
                    q.add(q.peek().right);
                }
                System.out.print(q.remove().data);
            }else{
                // count++; for counting
                q.remove();
                if(q.isEmpty()){
                    break;
                }
                System.out.println();
                q.add(null);
            }
        }
        System.out.println();
        // System.out.print("height: " + count);
    }

    // height
    public static int heightTree(Node root){
        if(root == null){
            return 0;
        }

        int lh = heightTree(root.left);
        int rh = heightTree(root.right);

        return 1 + Math.max(lh,rh);
    }


    // number of nodes 
    public static int countNodes(Node root){
        if(root == null){
            return 0;
        }

        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);

        return leftNodes + rightNodes + 1;
    }


    // sum of nodes 
    public static int sumOfNodes(Node root){
        if(root == null){
            return 0;
        }

        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);

        return leftSum + rightSum + root.data;
    }

    public static void main(String arg[]){
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();

        /*   
                    1
                   / \
                  2   3
                 / \   \
                4   5   6

         */


        Node root = tree.buildTree(nodes);
        System.out.println(root.left.data);

        // Tree traversals 
        // a) Preorder 

        printPreorderTree(root);
        System.out.println();

        printInorderTree(root);
        System.out.println();

        printPostorderTree(root);
        System.out.println();

        printLevelorderTree(root);

        System.out.println(heightTree(root));

        System.out.println(countNodes(root));

        System.out.println(sumOfNodes(root));
    }
}
