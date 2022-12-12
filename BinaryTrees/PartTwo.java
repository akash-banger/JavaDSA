package BinaryTrees;

public class PartTwo {
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


    // height
    public static int heightTree(Node root){
        if(root == null){
            return 0;
        }

        int lh = heightTree(root.left);
        int rh = heightTree(root.right);

        return 1 + Math.max(lh,rh);
    }


    // diameter Approach 1
    // public static int diameter(Node root){
    //     if(root == null){
    //         return 0;
    //     }
    //     int leftD = diameter(root.left);
    //     int rightD = diameter(root.right);
    //     int rootD = heightTree(root.left) + heightTree(root.right) + 1;
    //     return Math.max(Math.max(rightD, leftD), rootD);
    // }



    static class InfoDH{
        int diameter;
        int height;

        InfoDH(int diameter, int height){
            this.diameter = diameter;
            this.height = height;
        }
    }

    // diameter Approach 2 
    public static InfoDH diameter(Node root){
        if(root == null){
            return new InfoDH(0, 0);
        }

        InfoDH leftInfo = diameter(root.left);
        InfoDH rightInfo = diameter(root.right);

        int diam = Math.max(leftInfo.height + rightInfo.height + 1, Math.max(leftInfo.diameter, rightInfo.diameter));
        int ht = Math.max(leftInfo.height, rightInfo.height) + 1;

        return new InfoDH(diam, ht);
    }


    public static boolean isIdentical(Node root, Node subRoot){

        if(root == null && subRoot == null){
            return true;
        }else if(root == null || subRoot == null || root.data!= subRoot.data){
            return false;
        }


        boolean leftM = isIdentical(root.left, subRoot.left);
        boolean rightM = isIdentical(root.right, subRoot.right);

        return leftM && rightM;
    }

    // subtree in another tree 
    public static boolean subTreeInTree(Node root, Node subRoot){

        if(root == null){
            return false;
        }

        if(root.data == subRoot.data){
            if(isIdentical(root, subRoot)){
                return true;
            }
        }

        return subTreeInTree(root.left, subRoot) || subTreeInTree(root.right, subRoot);
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

        /*  subtree
                        2
                       / \
                      4   5
         */


        Node subRoot = new Node(2);
        add(subRoot, 4, 5);

        /// calculating the diameter Approach 1;
        System.out.println(diameter(root).diameter);

        System.out.println(subTreeInTree(root, subRoot));
    }
}
