package OOPS;

public class Constructors {
    /*
    Constructors are the special methods which is invoked automatically at 
    the time of the object creation.

    * Constructors have the same name as the class or structure
    * Constructors don't have a return type (not even void);
    * Constructors are only called once ( at the time of the object creation)
    * memory allocation happens when the Constructor is called

    * we can make multiple Constructors also;
    
    */

    public static void main(String arg[]){
        Student s1 = new Student();
        new Student(8);
        new Student("Akash Banger");

        // Constructor overloading : when we make a number of Constructors, and then suitable Constructor is called at the time of the object creation
        // polymorphism 



        /*
         Types of Constructors

         * Non-parameterized: no argument/ parameter.
         * Parameterized: we will take parameter/ parameters.
    
         * Copy Constructor: when we want to make a new object wih all the properties of an old object.
         * there is no by default copy Constructor. we have to make our own everytime.
         */


        // copy Constructor
        s1.name = "akash";
        s1.roll = 56; 
        s1.password = "fadfasd";
        s1.marks[0] = 78;
        s1.marks[1] = 80;
        s1.marks[2] = 100;

        Student s4 = new Student(s1);   // new object with the properties of old objects
        s4.password = "aksf";


        // marks copied from s1;
        for(int i=0; i<3; i++){
            System.out.print(s4.marks[i]+ " ");
        }

        // lets change the marks of s1 now 
        s1.marks[1] = 100;   // marks[1] changed from 80 to 100 for s1 

        // now s4 marks should'nt change right??
        for(int i=0; i<3; i++){
            System.out.print(s4.marks[i]+ " ");
        }
        // but it will change(in case of shallow copy constructor) as it is an array 
        // and array will be passed by reference 
        // so if we change the some value in old array
        // our new array will also changed which is just pointing to the old array.


        // so this is an issue in the copy Constructor.
        // to solve this we have to study about 

        /*
         * Shallow copy: we are just copying the reference. we are not making any new copy. for array or class etc.
         * Deep copy: we will make a completely new copy of the old property
         */
        
    }
}


class Student{
    String name;
    int roll;
    String password;
    int marks[];
    
    // If we do not create any Constructor function. then java will automatically create a Constructor.
    // but in that case there will be no initialization 
    // so for initialization. we will make a Constructor now


    // Non-parameterized Constructor
    Student(){
        marks = new int[3];
        System.out.println("Non-Parametrized Constructor is called");
    }

    // parameterized Constructor1
    Student(int roll){
        marks = new int[3];
        this.roll = roll;
        System.out.println("Parameterized Constructor1 is called");
    }

    // Parameterized Constructor2
    Student(String initialName){
        marks = new int[3];
        this.name = initialName; 
        System.out.println("Parameterized Constructor2 is called");
    }


    // Shallow copy Constructor
    // Student(Student s1){
    //     marks = new int[3];
    //     this.name = s1.name;
    //     this.roll = s1.roll;
    //     this.marks = s1.marks;
    //     System.out.println("Shallow Copy Constructor is called");
    // }


    // Deep copy Constructor
    Student(Student s1){
        marks = new int[3];
        this.name = s1.name;
        this.roll = s1.roll;
        for(int i=0; i<3; i++){
            this.marks[i] = s1.marks[i];
        }
        System.out.println("Deep copy constructor is called");
    }



    /* Destructors 
    In C++ we have to make Destructors to destroy the objects from the memory
    
    but in java we don't need to make any Destructors as the garbage collector of java will automatically
    delete the objects which are not used in the program.
    */  

}


// lazy copy 

// this is the combination of both the copies (shallow and deep)
// google it and know about this.




