package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problems {

    static class CarsInfo implements Comparable<CarsInfo> {
        int x;
        int y;
        int dist;
        int idx;

        CarsInfo(int x, int y, int dist, int idx){
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.idx = idx;
        }

        @Override
        public int compareTo(CarsInfo c){
            return this.dist - c.dist;
        }
    }



    public static void heapify(int array[], int i, int n){
        int left = 2*i + 1;
        int right = left + 1;
        int maxIdx = i;

        if(left < n && array[left] > array[maxIdx]){
            maxIdx = left;
        }

        if(right < n && array[right] > array[maxIdx]){
            maxIdx = right;
        }

        if(maxIdx != i){
            int temp = array[i];
            array[i] = array[maxIdx];
            array[maxIdx] = temp;

            heapify(array, maxIdx, n);
        }

    }

    static int cost = 0;



    // you can do it using a PriorityQueue also
    public static int connectRopes(int ropes[]){
        int n = ropes.length;
        for(int i=n/2; i>=0; i--){
            heapify(ropes,i,n);
        }

        for(int i=n-1; i>=1; i--){
            int temp = ropes[i] + ropes[i-1];
            cost+= temp;

            ropes[i-1] = temp;

            heapify(ropes, 0, i);
        }

        return cost;
    }

    public static int connectRopes2(int ropes[]){
        int n = ropes.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=n-1; i>=0; i--){
            pq.add(ropes[i]);
        }

        for(int i=0; i<n-1; i++){
            int min = pq.remove();
            int min2 = pq.remove();
            int temp = min + min2;
            cost+= temp;
            pq.add(temp);
        }

        return cost;
    }


    static class rowInfo implements Comparable<rowInfo>{
        int soldiers;
        int rowNo;

        rowInfo(int soldiers, int rowNo){
            this.soldiers = soldiers;
            this.rowNo = rowNo;
        }

        @Override 
        public int compareTo(rowInfo r){
            if(r.soldiers == this.soldiers){
                return this.rowNo - r.rowNo;
            }
            return this.soldiers - r.soldiers;
        }
    }


    static class WinInfo implements Comparable<WinInfo>{ 
        int val; 
        int idx;

        WinInfo(int val, int i){
            this.val = val;
            this.idx = i;
        }

        @Override
        public int compareTo(WinInfo w){
            return this.val - w.val;
        }
    }



    public static void slidingWinMax(int array[], int sol[], int k){
        PriorityQueue<WinInfo> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0; i<k; i++){
            pq.add(new WinInfo(array[i], i));
        }

        sol[0] = pq.peek().val;

        for(int i=k; i<array.length; i++){
            while(pq.peek().idx <= i-k){
                pq.remove();
            }

            pq.add(new WinInfo(array[i], i));
            sol[i-k+1] = pq.peek().val;
        }
    }

    public static void main(String arg[]){
        // given n points of location of cars, you are at origin, find k nearest cars 
        int points[][] = {{1,2},{3,4},{2,1},{4,5}};
        int k = 3;
        PriorityQueue<CarsInfo> pq = new PriorityQueue<>();

        for(int i=0; i<points.length; i++){
            int x = points[i][0];
            int y = points[i][1];
            int dist = x*x + y*y;
            pq.add(new CarsInfo(x, y, dist, i));
        }

        for(int i=0; i<k; i++){
            System.out.println("C" + pq.remove().idx);
        }


        // Given n ropes of different length. connect the ropes with the min cost. cost is equal to the lenght of the connecting ropes. return the min cost as ans 
        int ropes[] = {4,3,2,6};
        System.out.println(connectRopes(ropes));
        System.out.println(connectRopes2(ropes));


        // given a binary matrix. here 1 is repersenting a soldier and 0 is representing a civilian 
        // all the civilians are at the right of the soldiers in each row (all 1 at left of all the zeros in each row)
        // find the k weakest rows
        // a row is weak from another row if numbers of soldiers are less 
        // and its weak from another row if the row number is less (in case of equal soldiers)

        int matrix[][] = {{1,0,0,0},
                          {1,1,1,1},
                          {1,0,0,0},
                          {1,0,0,0}};
        int k1 =2;
        PriorityQueue<rowInfo> soldr = new PriorityQueue<>();

        for(int i=0; i<matrix.length; i++){
            int count = 0;
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 1){
                    count++;
                }
            }
            soldr.add(new rowInfo(count, i));
        }

        for(int i=0; i<k1; i++){
            System.out.println("R"+ (soldr.remove().rowNo + 1));
        }



        // sliding window maximum 
        // take k elements in an array continuosly starting from index 0 
        // meas 0-k-1 thn 1-k thn so on 
        // and return the maximum of k numbers everytime 

        int array[] = {1,3,-1,-3,5,3,6,7};
        int k2 = 3;
        int sol[] = new int[array.length - k2 + 1];

        slidingWinMax(array, sol, k2);
        for(int i=0; i<sol.length; i++){
            System.out.print(sol[i] + " ");
        }
    }   


}
