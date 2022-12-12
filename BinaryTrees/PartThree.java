package BinaryTrees;

import java.time.chrono.HijrahEra;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.RowFilter;

public class PartThree {

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


    public static void kthLevelOfTree(Node root, int k, int level){

        if(root == null){
            return;
        }


        if(level == k){
            System.out.print(root.data + " ");
            return;
        }

        kthLevelOfTree(root.left, k, level + 1);
        kthLevelOfTree(root.right, k, level + 1);
    }   


    public static boolean getPath(Node root, ArrayList<Node> path, int n){
        if(root == null){
            return false;
        }

        if(root.data == n){
            return true;
        }

        path.add(root);

        boolean leftFound = getPath(root.left, path, n);
        boolean rightFound = getPath(root.right, path, n);

        if(leftFound || rightFound){
            return true;
        }


        path.remove(path.size() - 1);
        return false;
    }



    public static Node lowestCommonAncestor(Node root, int n1, int n2){ // O(n)
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, path1, n1);  // O(n)
        getPath(root, path2, n2);  // O(n)

        int i;
        for(i=0; i<path1.size() && i<path2.size(); i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }


        return path1.get(i-1);
    }   


    public static Node lowestCommonAncestor2(Node root, int n1, int n2){

        if(root == null){
            return null;
        }

        if(root.data == n1 || root.data == n2){
            return root;
        }

        Node leftFound = lowestCommonAncestor2(root.left, n1, n2);
        Node rightFound = lowestCommonAncestor2(root.right, n1, n2);


        if(rightFound == null){
            return leftFound;
        }

        if(leftFound == null){
            return rightFound;
        }


        return root;
    }   


    public static int dist(Node root, int n){  
        if(root == null){
            return -1;
        }

        if(root.data == n){
            return 0;
        }

        int leftDist = dist(root.left, n);
        int rightDist = dist(root.right, n);

        if(leftDist> -1){
            leftDist++;
        }

        if(rightDist> -1){
            rightDist++;
        }

        return leftDist>rightDist? leftDist:rightDist;

    }


    public static int minDistanceBWTwoNodes(Node root, int n1, int n2){
        Node lca = lowestCommonAncestor2(root, n1, n2);
        int h1 = dist(lca, n1);
        int h2 = dist(lca, n2);

        return h1 + h2;
    }


    public static int kthAnscestor(Node root, int n, int k){
        if(root == null){
            return -1;
        }

        if(root.data == n){
            return 0;
        }

        int leftDist = kthAnscestor(root.left, n, k);
        int rightDist = kthAnscestor(root.right, n, k);


        // int max = Math.max(leftDist, rightDist);
        
        // if(leftDist == -1 & rightDist == -1){
        //     return -1;
        // }

        // max++;

        // if(max == k){
        //     System.out.println("kth anscestor: " + root.data);
        // }


        // return max;

        if(leftDist> -1){
            leftDist++;
        }

        if(rightDist> -1){
            rightDist++;
        }

        if(leftDist == k || rightDist == k){
            System.out.println("kth anscestor: " + root.data);
        }


        return leftDist>rightDist? leftDist: rightDist;
    }


    public static int transformToSumTree(Node root){
        if(root == null){
            return 0;
        }

        int leftSum = transformToSumTree(root.left);
        int rightSum = transformToSumTree(root.right);

        int temp = root.data;
        root.data = leftSum + rightSum;

        return temp + leftSum + rightSum;
    }



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
                System.out.print(q.remove().data + " ");
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


        kthLevelOfTree(root, 3, 1);

        System.out.println();

        System.out.println(lowestCommonAncestor(root, 4,5).data);
        System.out.println(lowestCommonAncestor2(root, 2,7).data);

        System.out.println(minDistanceBWTwoNodes(root, 4,7));

        kthAnscestor(root, 5, 1);

        printLevelorderTree(root);


        transformToSumTree(root);

        printLevelorderTree(root);
    }
}
