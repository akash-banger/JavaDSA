package LinkedList;
import java.util.LinkedList;

import javax.print.event.PrintJobListener;
import javax.swing.plaf.synth.SynthOptionPaneUI;

public class LinkedlistJCF {

    static Node head;
    static Node tail;
    static int size;

    class Node{
        int data;
        Node next;
    
        // constructor 
        public Node(int data){
            this.data = data;
            this.next = null; // by default it should be null
        }
    }   


    public void addLast(int data){
        // creating the node 
        Node newNode = new Node(data);
        
        // if the LinkedList is empty
        if(head == null){
            head = tail = newNode;
            size++;
            return;
        }

        // tail.next = newNode
        tail.next = newNode;

        // tail = newNode 
        tail = newNode;
        
        size++;
    }


    public Node findMidNode(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }



    // merge sort on a LinkedList 
    public Node mergeSort(Node head){

        if(head == null || head.next == null){
            return head;
        }

        Node mid = findMidNode(head);
        Node rightHead = mid.next;
        mid.next = null;

        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        return merge(newLeft, newRight);
    }


    public Node merge(Node head1, Node head2){
        Node mergedList = new Node(-1);
        Node temp = mergedList;
        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedList.next;
    }


    // zig zag LinkedList 
    public void zigZag(Node head){
        Node midNode = findMidNode(head); // finding the mid node 
        Node curr = midNode.next; // storing the value next to mid 
        midNode.next = null; // breaking the linkeklist from mid
        Node prev = null; 
        Node next;
        while(true){   // reversing the second half
            if(curr == null){
                break;
            }
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node righthead = prev;
        Node lefthead = head;
        
        while(righthead != null && lefthead != null){ // making the zigzag
            Node nextL = lefthead.next;   // storing the next left and right head 
            Node nextR = righthead.next;
            lefthead.next = righthead;        // join left head and right head
            righthead.next = nextL;             // join the prev next of left head to this right head
            lefthead = nextL;                // move to the next element
            righthead = nextR;
        }

        // this is enough for both odd and even case;

    }


    public void printList(){ // O(n)
        if(head == null){
            System.out.println("null");
            return;
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }



    public static void main(String arg[]){
        // create 
        LinkedList<Integer> ll = new LinkedList<>();


        // add 
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(3);
        ll.addFirst(1);
        ll.addFirst(2);

        System.out.println(ll);

        // remove 
        // ll.removeLast();
        // ll.removeFirst();


        LinkedlistJCF ll2 = new LinkedlistJCF();
        ll2.addLast(5);
        ll2.addLast(4);
        ll2.addLast(3);
        ll2.addLast(2);
        // ll2.addLast(1);

        ll2.printList();
        ll2.head = ll2.mergeSort(head);
        ll2.printList();
        ll2.zigZag(head);
        ll2.printList();
    }   
}
