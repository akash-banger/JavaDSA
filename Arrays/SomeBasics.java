package Arrays;
public class SomeBasics {

    public static void update(int array[]){
        for(int i=0; i<array.length; i++){
            array[i]++;
        }
    }
    public static void main(String arg[]){
        // Array: list of the elements of same type placed in contiguous memory location.
        
        // creating an array: 
        // datatype arrayName[] = new datatype[size];
        // int marks[] = new int[5];
        // int numbers[] = {1,2,3};
        // Scanner sc = new Scanner(System.in);
        
        // // input 
        // System.out.println("Physics Marks:");
        // marks[0] = sc.nextInt();


        // // output
        // System.out.println(marks[0]);


        // passing arrays as argument to function 
        // arrays will pass by reference 
        // means if you change the array in some other function 
        // then the original array in the main function will also change;

        int mark[] = {98,76,77,88,99};
        update(mark);

        for(int i=0; i<mark.length; i++){
            System.out.print(mark[i] + " ");
        } /// run this and see the result; 


        // linear search : going through every element of an array one by one;
        // time complexity : O(n);


        // Integer.MIN_VALUE; // min value existing in java;
    }
}
