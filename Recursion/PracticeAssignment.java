package Recursion;

public class PracticeAssignment {
    
    // finding all the occurences of a given element and print them
    public static void occurences(int array[], int k, int i, boolean count){
        if(i==array.length){
            if(!count){
                System.out.println("-1");
            }
            return;
        }
        if(array[i]==k){
            count = true;
            System.out.print(i + " ");
        }
        occurences(array, k, i+1, count);
    }


    // finding the length of a String 
    public static void lenString(String s, int count){
        if(s==""){
            System.out.println(count);
            return;
        }
        s = s.substring(1);
        lenString(s, ++count);
    }



    // Tower of Hanoi (important)
    public static void towerHanoi(int n, String src, String helper, String dest){
        if(n==1){
            System.out.println("Transfer disk "+n+" from "+src+" to "+dest);
            return;
        }

        // Transfer disks (n-1) from src to helper using dest as helper
        towerHanoi(n-1, src, dest, helper);

        // Transfer nth from src to destination
        System.out.println("Transfer disk "+n+" from "+src+" to "+dest);

        // Transfer disks (n-1) from helper to dest using sourse as helper 
        towerHanoi(n-1, helper, src, dest);
    }


    public static void main(String arg[]){
        int array[] = {3,2,4,5,6,2,7,2,2};
        occurences(array, 2, 0, false);
        System.out.println();
        lenString("dfasf", 0);
        towerHanoi(2, "A", "B", "C");
    }
}
