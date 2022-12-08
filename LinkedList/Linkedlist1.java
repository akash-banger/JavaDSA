package LinkedList;


public class Linkedlist1 {
    // LinkedList contains number of nodes and each node has two things
    // first is data and second is next(reference to the next node)
    // for making a LinkedList we have to make a classs

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

    // Methods 

    // add in LinkedList

    /* Add first
     * create new Node
     * new Node's next = head
     * head = new Node 
     */

    public void addFirst(int data){
        // step 1 = creating new node
        Node newNode = new Node(data);

        // if LinkedList is empty 
        if(head == null){
            head = tail = newNode;
            size++;
            return;
        }

        // step 2 = adding head to next 
        newNode.next = head;

        // step 3 = changing the head 
        head = newNode;
        size++;
    }

    /* add last 
     * create the node 
     * point tail's next to the newNode tail.next = newNode
     * tail = newNode
    */


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

    // adding at an index i;

    public void addMiddle(int data, int idx){
        if(idx == 0){
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;
        int i =0;
        while(i<idx-1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    // removing an element from LinkedList

    // remove first 
    public int removeFirst(){
        if(size == 0){
            System.out.println("List is already empty");
            return Integer.MIN_VALUE;
        }

        else if(size == 1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }

        int val = head.data;
        head = head.next; // garbage collector will delete prev head automatically
        size--;
        return val;
    }

    // remove last 
    public int removeLast(){
        if(size == 0){
            System.out.println("list is already empty");
        }

        else if(size == 1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }

        Node prev = head;
        for(int i=1; i<=size-2; i++){
            prev = prev.next;  // last second element 
        }

        int val = tail.data;
        prev.next = null;
        prev = tail;
        size--;
        return val;
    }

    // find and remove nth node from the last // iterative approach
    public int removeNthNodeLast(int n){
        if(n == size){
            return removeFirst();
        }

        Node temp = head;
        int i = 1;
        while(i<(size-n)){
            temp = temp.next;
            i++;
        }

        Node prev = temp;
        Node curr = temp.next;

        int val = curr.data;
        prev.next = curr.next;
        size--;
        return val;

    }





    /// search in an LinkedList // iterativeSearch
    public int iterativeSearch(int key){
        Node iterator = head;
        for(int i=0; i<size; i++){
            if(iterator.data == key){
                return i;
            }
            iterator = iterator.next;
        }
        return -1;
    }



    // recursive search

    public int recursiveSearch(int key){
        return helper(head, key, 0);
    }

    public int helper(Node head, int key, int idx){

        if(head == null){
            return -1;
        }

        if(head.data == key){
            return idx;
        }

        return helper(head.next, key, idx+1);
    }


    // reversing a LinkedList

    public void reverse(){
        Node prev = null;
        Node curr = tail = head; // this head will become the tail so assigning the value of head to tail also
        Node next;
        while(curr!=null){      // at tail out next will be null so our our curr will become null at last
            next = curr.next;    // next will be the curr.next
            curr.next = prev;    // change the pointing link from next to prev
            prev = curr;           // now move one step so your curr become prev
            curr = next;        // and your curr become next
        }

        head = prev;    // curr is null and prev is tail (old tail)
    }
    

    // fast-slow trick to calculate the mid of a LinkedList
    public Node findMidNode(Node head){
        Node slow = head;
        Node fast = head;
        while(true){
            if(fast == null || fast.next == null){
                break;
            }   
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    // checking if our ll is palindrome or not 
    public boolean isPalindrome(){
        if(head == null || head.next==null){
            return true;
        }
        
        Node midNode = findMidNode(head);
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;

        while(right!=null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }


    // printing the LinkedList
    
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
        Linkedlist1 ll = new Linkedlist1();

        ll.addFirst(1);
        ll.printList();
        ll.addFirst(0);
        ll.printList();
        ll.addLast(2);
        ll.printList();
        ll.addLast(3);
        ll.printList();
        ll.addMiddle(9, 2);
        ll.printList();
        // System.out.println(ll.size);
        ll.removeFirst();
        ll.printList();
        ll.removeLast();
        ll.printList();
        // System.out.println(ll.size);
        System.out.println(ll.iterativeSearch(9));
        System.out.println(ll.recursiveSearch(9));
        ll.reverse();
        ll.printList();
        // System.out.println(ll.size);

        ll.addLast(2);
        ll.addLast(1);
        ll.addLast(2);
        ll.printList();

        ll.removeNthNodeLast(5);

        ll.printList();

        System.out.println(ll.isPalindrome());
    }
}


