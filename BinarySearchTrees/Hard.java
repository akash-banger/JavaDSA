package BinarySearchTrees;
import java.util.*;

public class Hard {


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


    public static void addLeft(Node root, int data){
        Node newNode = new Node(data);
        root.left = newNode;
    }

    public static void addRight(Node root, int data){
        Node newNode = new Node(data);
        root.right = newNode;
    }

    public static void add(Node root, int leftData, int rightData){
        Node newNode1 = new Node(rightData);
        Node newNode2 = new Node(leftData);
        root.left = newNode2;
        root.right = newNode1;
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





    // size of largest valid BST in a binary tree;
    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;

        Info(boolean isBST, int size, int min, int max){
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }


    public static int largestSize = 0;

    public static Info largestBST(Node root){
        if(root == null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);

        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(Math.min(leftInfo.min, rightInfo.min), root.data);
        int max = Math.max(Math.max(leftInfo.max, rightInfo.max), root.data);

        if(root.data <= leftInfo.max || root.data >= rightInfo.min){
            return new Info(false, size, min, max);
        }

        if(leftInfo.isBST && rightInfo.isBST){
            largestSize = Math.max(largestSize, size);
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);
    }

    public static Node buildBalancedBST(ArrayList<Integer> values, int si, int ei){

        if(si>ei){
            return null;
        }

        int mid = si + (ei - si)/2;

        Node root = new Node(values.get(mid));

        root.left = buildBalancedBST(values, si, mid -1);
        root.right = buildBalancedBST(values, mid + 1, ei);

        return root ;
    }   


    public static void BSTtoSortedArr(Node root, ArrayList<Integer> list){

        if(root == null){
            return;
        }

        BSTtoSortedArr(root.left, list);
        list.add(root.data);
        BSTtoSortedArr(root.right, list);

    }


    public static Node mergeTwoBSTs(Node root1, Node root2){
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();

        BSTtoSortedArr(root1, first);
        BSTtoSortedArr(root2, second);
        

        for(int i=0; i<second.size(); i++){  // instead you can use the merge algorithm also to merge and sort in linear time
            first.add(second.get(i));
        }

        Collections.sort(first);

        return buildBalancedBST(first, 0, first.size()-1);
    }



    public static void main(String arg[]){
        /*  
                            50
                         /      \
                       30        60
                     /    \    /    \
                    5     20  45     70
                                    /  \
                                   65   80

         */

        Node root = new Node(50);
        add(root, 30, 60);
        add(root.left, 5, 20);
        add(root.right, 45, 70);
        add(root.right.right, 65, 80);

        largestBST(root);
        System.out.println(largestSize);


        Node root1 = new Node(2);
        add(root1,1, 4);

        Node root2 = new Node(9);
        add(root2, 3, 12);

        Node root3 = mergeTwoBSTs(root1, root2);

        printLevel(root3);
    }
}
