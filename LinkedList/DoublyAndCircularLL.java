package LinkedList;

public class DoublyAndCircularLL {

    // doubly linkedList Node
    class Node{
        int data;
        Node next;
        Node prev;
        // constructor
        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }   

    public static Node head;
    public static Node tail;

    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }

        newNode.next = head;         
        head.prev = newNode;
        head = newNode;
    }


    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public int removeLast(){
        if(head == null){
            System.out.println("Dll is empty");
            return Integer.MIN_VALUE;
        }

        if(head.next == null){
            int val = tail.data;
            head = tail = null;
            return val;
        }

        int val = tail.data;
        Node newTail = tail.prev;
        newTail.next = null;
        tail.prev = null;
        tail = newTail;
        return val;
    }


    // reverse a dll  
    public void reverse(){
        Node prev = null;
        Node curr = head;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }


    public void printlist(){
        Node temp = head;
        if(head == null){
            System.out.println("dll is empty");
            return;
        }
        System.out.print("null <--> ");
        while(temp != null){
            System.out.print(temp.data + " <--> ");
            temp = temp.next;
        }
        System.out.println("null");
    }



    public static void main(String arg[]){
        // doubly linked list is connected in both the directions 
        // the flow is in both the directions forward and backward
        // unline single LinkedList in which the flow is only in forward direction.

        DoublyAndCircularLL dLL = new DoublyAndCircularLL();

        dLL.addFirst(2);
        dLL.addFirst(1);
        dLL.addLast(3);
        dLL.addLast(4);
        dLL.addLast(5); 
        dLL.removeLast();
        dLL.reverse();
        dLL.printlist();

    }
}
