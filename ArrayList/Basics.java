package ArrayList;
import java.util.ArrayList;
import java.util.Collections;


public class Basics {
    public static void main(String arg[]){
        // ArrayList is a linear data structure 
        // dynamic size 
        // can only store non-primitive data types means Integer, Char ..

        ArrayList<Integer> list = new ArrayList<>();
        // adding an element in ArrayList
        list.add(2); // O(1)
        list.add(3);
        list.add(4);
        list.add(2,8); // O(n)

        System.out.println(list);


        // getting an element from ArrayList
        int element = list.get(2); // O(1)
        System.out.println(element);

        // removing an element from ArrayList
        list.remove(2); // O(n)
        System.out.println(list);

        // set 
        list.set(1, 7); // O(n)
        System.out.println(list);


        // contains element
        System.out.println(list.contains(2));
        System.out.println(list.contains(102));


        /// size of ArrayList
        System.out.println(list.size());

        
        // sorting 
        System.out.println(list);
        Collections.sort(list); // ascending 
        System.out.println(list);

        // descending 
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
        // comparator - fnxn login




        // How ArrayList work in java
        /*
         * At intialization of an ArrayList
         * java make an array of fixed size say n
         * now after that we will add some elements in ArrayList
         * now after this array of size n is full 
         * java will automatically make a new array of double size(2*n) 
         * and it will copy all the elements in this new array
         * this is occur again and again whenever needed;
         */



         // multi dimensional ArrayList

        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        mainList.add(list);
        mainList.add(list);
        mainList.add(list);
        System.out.println(mainList);

        // nice way of printing
        for(int i=0; i<mainList.size(); i++){
            ArrayList<Integer> currList = new ArrayList<>();
            currList = mainList.get(i);
            for(int j=0; j<currList.size(); j++){
                System.out.print(currList.get(j) + " ");
            }
            System.out.println();
        }
    }
}
