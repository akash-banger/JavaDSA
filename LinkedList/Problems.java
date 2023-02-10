package LinkedList;

import java.util.ArrayList;

public class Problems {

    static class Node{
        int data;
        Node next;
    
        // constructor 
        public Node(int data){
            this.data = data;
            this.next = null; // by default it should be null
        }
    }  

    // finding the intersection of 2 LinkedLists 
    public static int intersection(Node head1, Node head2){

        while(head1.next != null){
            Node temp = head1.next;
            head1.next = null;
            head1 = temp;
        }


        while(head2.next != null){
            head2 = head2.next;
        }

        return head2.data;

    }


    // deleting n nodes after m nodes from a LinkedList 
    public static Node deleteNNodes(Node head, int n, int m){

        Node temp = head;
        for(int i=0; i<m; i++){
            temp = temp.next;
        }

        Node temp3 = temp;
        for(int i=0; i<n; i++){
            Node temp2 = temp.next;
            temp.next = null;
            temp = temp2;
        }

        temp3.next = temp.next;
        return head;
    }



    // swaping the two nodes in LL (changes should be done by changing the links not the data)
    public static Node swap(Node head, int x, int y){
        Node temp = head; 
        Node pNode1 = head;
        Node pNode2 = head;
        while(temp.next != null){
            if(temp.next.data == x){
                pNode1 = temp;
            }
            if(temp.next.data == y){
                pNode2 = temp;
            }
            temp = temp.next;
        }

        Node node1 = pNode1.next;
        Node node2 = pNode2.next;

        Node nNode1 = node1.next;
        Node nNode2 = node2.next;

        pNode1.next = node2;
        pNode2.next = node1;

        node1.next = nNode2;
        node2.next = nNode1;

        return head;
    }

    // modifying the LL such that all the even numbers comes before all the odd numbers 
    // order of numbers should be same 
    public static Node oddEvenLL(Node head){
        Node newHead = new Node(0);
        Node temp1 = newHead;
        Node temp2 = head;
        while(temp2 != null){
            if(temp2.data%2 == 0){
                temp1.next = new Node(temp2.data);
                temp1 = temp1.next;
            }
            temp2 = temp2.next;
        }

        while(head != null){
            if(head.data%2 != 0){
                temp1.next = new Node(head.data);
                temp1 = temp1.next;
            }
            head = head.next;
        }

        Node temp3 = newHead.next;
        newHead.next = null;
        newHead = temp3;


        return newHead;
    }



    // shity method
    public static Node merge(Node head1, Node head2){
        Node head = new Node(0);
        Node temp = head;
        while(head1!=null && head2!=null){
            if(head1.data > head2.data){
                head.next = new Node(head2.data);
                head2 = head2.next;
            }else{
                head.next = new Node(head1.data);
                head1 = head1.next;
            }
            head = head.next;
        }   

        while(head1!= null){
            head.next = new Node(head1.data);
            head = head.next;
            head1 = head1.next;
        }

        while(head2 != null){
            head.next = new Node(head2.data);
            head = head.next;
            head2 = head2.next;
        }


        return temp.next;
    }

    static Node mHead;

    // merging k sorted linkedlists of size n each. 
    public static Node mergeSortedLL(int k, int n, ArrayList<Node> heads){
        mHead = merge(heads.get(0), heads.get(1));
        for(int i=2; i<k; i++){
            mHead = merge(mHead, heads.get(i));
        }
        return mHead; 
    }

    // try some efficient method for the Problem
    // merging k sorted LinkedLists of size n each 
    // whats the advantage of having same size of all the lls 

    // merging k sorted linkedlists of size n each (nice method)

    public static Node mergeSortedLL(Node heads[], int last){
        while(last!=0){
            int i=0, j=last;
            while(i<j){
                heads[i] = mergeSortedLLUtil(heads[i], heads[j]);
                i++;
                j--;

                if(i>=j){
                    last = j;
                }
            }
        }

        return heads[0];
    }


    public static Node mergeSortedLLUtil(Node a, Node b){
        Node result = null;

        if(a == null){
            return b;
        }

        if(b == null){
            return a; 
        }


        if(a.data < b.data){
            result = a;
            result.next = mergeSortedLLUtil(a.next, b);
        }

        else{
            result = b;
            result.next = mergeSortedLLUtil(a, b.next);
        }


        return result;
    }
    


    // printing the ll 
    public static void printLL(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String arg[]){

        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(6);


        Node head2 = new Node(4);
        head2.next = new Node(5);
        head2.next.next = head1.next.next.next;
        

        // finding the intersection of 2 LinkedLists 
        System.out.println(intersection(head1, head2));



        Node head3 = new Node(1);
        head3.next = new Node(2);
        head3.next.next = new Node(3);
        head3.next.next.next = new Node(4);
        head3.next.next.next.next = new Node(5);
        head3.next.next.next.next.next = new Node(6);
        head3.next.next.next.next.next.next = new Node(7);
        head3.next.next.next.next.next.next.next = new Node(8);
        head3.next.next.next.next.next.next.next.next = new Node(9);
        head3.next.next.next.next.next.next.next.next.next = new Node(10);



        // delete n nodes after m nodes of a singly LinkedList; 

        printLL(head3);

        head3 = deleteNNodes(head3, 3, 4);

        printLL(head3);



        // swaping nodes in LinkedList 

        printLL(head3);

        head3 = swap(head3, 2, 9);

        printLL(head3);


        // Odd even LinkedList 

        head3 = oddEvenLL(head3);

        printLL(head3);


        // merging k sorted linkedlists of size n each 

        Node mHead1 = new Node(1);
        mHead1.next = new Node(3);

        Node mHead2 = new Node(6);
        mHead2.next = new Node(8);

        Node mHead3 = new Node(9);
        mHead3.next = new Node(10);

        ArrayList<Node> heads = new ArrayList<>();
        heads.add(mHead1);
        heads.add(mHead2);
        heads.add(mHead3);

        Node arr[] = {mHead1, mHead2, mHead3};

        Node newHead = new Node(0);

        printLL(newHead);

        // newHead = mergeSortedLL(3, 2, heads);

        // printLL(newHead);

        newHead = mergeSortedLL(arr, 2);

        printLL(newHead);

    }
}

