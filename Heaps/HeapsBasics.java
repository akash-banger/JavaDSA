package Heaps;

import java.util.ArrayList;

public class HeapsBasics {

    // heap is a binary tree

    // To be more accurate 
    // heap is a complete binary tree (CBT)

    // CBT is a binary tree in which all the levels are completely filled except possible the last one,
    // which is filled from left to right 

    // Heap order property 
    // Children >= Parent (MinHeap)
    // Children <= Parent (MaxHeap)


    // heap is not implemented as class 
    // because to insert a node the time complexity will be O(n)
    // and even after inserting if the heap propety is not satisfied then again we have to change the heap 
    // to make it efficient, we implement heap using arraylist


    // given index i to the the parent 
    // left child = 2*i + 1
    // right child = 2*i + 2;


    // for the arraylist the time complexity for inserting will be just O(1);

    // inserting in heap 

    static class MinHeap{
        ArrayList<Integer> heap = new ArrayList<>();

        // isEmpty
        public boolean isEmpty(){
            return heap.size()==0;
        }

        // inserting in heap
        public void insert(int data){    // O(logn)
            heap.add(data);
            int i = heap.size() - 1;
            int parentIdx = (i-1)/2;
            while(parentIdx>=0 && heap.get(parentIdx)>heap.get(i)){
                int temp = heap.get(i);
                heap.set(i, heap.get(parentIdx));
                heap.set(parentIdx, temp);
                i = parentIdx;
                parentIdx = (i-1)/2;
            }
        }


        // to get the min value of the minHeap 
         // its just the element present at the zeroth index of the arraylist
        public int peek(){
            return heap.get(0);
        }   


        // to fix the heap
        private void heapify(int i){

            // get the left and right child of current
            int left = 2*i + 1;
            int right = left + 1;
            int minIdx = i;


            // check which is the min among left child and right child and self(parent)
            if(left < heap.size() && heap.get(minIdx) > heap.get(left)){
                minIdx = left;
            }

            if(right < heap.size() && heap.get(minIdx) > heap.get(right)){
                minIdx = right;
            }


            // if min is not parent
            if(minIdx != i){

                // swap with the min (parent should be min as its minHeap)
                int temp = heap.get(i);
                heap.set(i, heap.get(minIdx));
                heap.set(minIdx, temp);

                // call the heapify for the old min element 
                heapify(minIdx);
            }

        }



        /// to remove the min element from the heap
        public int remove(){

            // swap 0th index element and last element (0th element is the min element and we will remove it)
            int temp = heap.get(0);
            heap.set(0, heap.get(heap.size() -1));
            heap.set(heap.size()-1, temp);


            // remove the last element // means technically the first element 
            heap.remove(heap.size() -1);

            // call the heapify to fix the heap
            heapify(0);
            

            // return the deleted element
            return temp;
        }


        public void printHeap(){
            System.out.println(heap);
        }
    }



    
    public static void main(String arg[]){ 

        MinHeap h = new MinHeap();
        h.insert(1);
        h.insert(7);
        h.insert(8);
        h.insert(4);
        h.insert(5);
        h.insert(2);
        h.insert(3);

        while(!h.isEmpty()){  // heap sort O(n*logn)
            System.out.print(h.peek() + " ");
            h.remove();
        }

        // you saw what it printed ??? ??? 
        // if you have eyes and brain thn you will get to know
        // that this heap is a priority list itself


        // you can make the maxHeap also just changing some less thn operator to greater thn operators and vice versa

        System.out.println();

    }   
}
