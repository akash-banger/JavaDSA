package OOPS;

public class StaticSuperKeyword {
    public static void main(String arg[]){
        
        // static keyword is used to share the same varible or method of a given class among all the objects
        /*  which can be made static 
         * Properties
         * functions
         * blocks
         * nested classes
        */ 

        Student s1 = new Student();
        Student s2 = new Student();
        s1.name = "akash";
        s2.name = "banger";


        Student.school = "bcs"; // if any object change a static varible then that will change for all the objects

        System.out.println(Student.school);


        // super keyword
        // used to refer the immediate parent class object
        // to access parents Properties
        // to access parents functions
        // to access parent's constructor

        Horse mustang = new Horse();
        System.out.println(mustang.color);
    }


}

class Student{
    String name;
    int roll;
    static String school;
}


class Animal{
    String color;
    Animal(){
        System.out.println("Animal constructor called");
    }
}

class Horse extends Animal{
    Horse(){
        super();
        super.color = "red";
        System.out.println("Horse constructor called");
    }
}