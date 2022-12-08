package LinkedList;

public class Linkedlist2 {
    static Node head;
    static Node tail;
    static int size;

    class Node{
        int data;
        Node next;
    
        // constructor 
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }


    // addLast function
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


    
    // floyd's cycle finding algorithm
    // detect a loop/cycle in a LL 
    public boolean isLooped(){
        Node slow = head;
        Node fast = head;
        boolean test = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                test = true;
                break;
            }
        }
        return test;
    }


    // remove the loop
    public void removeLoop(){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                break;
            }
        }

        slow = head;
        Node prev = fast;
        while(slow!=fast){
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }

        prev.next = null;
    }

    public void creatLoop(){
        tail.next = head.next;
    }


    public static void main(String arg[]){
        Linkedlist2 ll = new Linkedlist2();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.printList();
        ll.creatLoop();

        System.out.println(ll.isLooped());
        ll.removeLoop(); // only work when not fully looped( head connected with tail is not considered)

        System.out.println(ll.isLooped());
        ll.printList();

    }   
}

// Java Collection Framework is a Collection of inbuilt data structures like array, arraylist etc.

