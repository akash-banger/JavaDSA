package OOPS;

// package: A package is a group of similar types of classes, interfaces and sub-packages.

public class BuildingBlocks {
    // some building blocks of a class 

    /*
     Encapsulation: defined as the wrapping up of data and methods into a single entity. It also implements the data hiding.
     data hiding means: making some data private, default or public etc.
     
      
     Inheritance: Inheritance is when properties and methods of a base class ara passed on to a derived class.
     example for the Inheritance is below
     Types of Inheritance:
     * Single level Inheritance: single base class and single derived class from the base class
     * multi level Inheritance: single base class and then derived class from that base class and then again a derived class from the derived class and so on.
     * heirarhical Inheritance: single base class then multiple derived class from that base.
     * hybrid Inheritance: single base class then multiple derived class and then more derived class from that derived class.
     * combination of everything
     
     
     PolyMorphism: similar thing in multiple forms. for example we used different constructors.
     Tow types of PolyMorphism
     * Compile Time PolyMorphism(static): Method overloading (functions with the same name but different parameter type or number of parameters)
     * so this overloading will be known at the compile time only
     
     * Run Time PolyMorphism(dynamic): Method overriding (parent and the child class both contain the same function but with a different definition)
     * example is below
     
     
     Abstraction: Hiding all the unnecesary details and showing only the important parts to the user.
     * Abstract Classes: *cannot create and instance of the abstract class, *can have abstract/non-abstract methods, *can have constructors
     * Interfaces:
     * 
     */
     
    
    
    public static void main(String arg[]){
        Fish shark = new Fish();
        shark.color = "black";
        System.out.println(shark.color);
        shark.breathe();
        shark.swim();
        shark.eat(); // function overridding // this will print the funciton which is in the child class


        // abstract example 
        Dog d = new Dog();
        d.eat();
        d.walk();
        Chicken c = new Chicken();
        c.eat();
        c.walk();

        // Mammals a = new Mammals(); // will give error as we cannot make objects for an abstract class

        //  we can make constructors in an abstract class
        // but what will be the use of the constructors 
        // as we cannot make the objects so why???


        // this constructor will be used by the subclasses. example below
    }

}



// base class 
class Animal{
    String color;
    void eat(){
        System.out.println("eats");
    }
    void breathe(){
        System.out.println("breathes");
    }
}


// derived class
class Fish extends Animal{
    int fins;

    void swim(){
        System.out.println("Swims in water");
    }
    void eat(){
        System.out.println("eats fish food");
    }
}


// abstract class 
abstract class Mammals{
    String color;

    /// constructor
    Mammals(){
        color = "red"; // now the color for all the subclasses will be red until the changeColor function is called.
        System.out.println("mammals constructor called");
    }

    void eat(){
        System.out.println("eats");
    }
    abstract void walk(); // there will be no implementation // the sub class will give the implementation
}

class Dog extends Mammals{
    Dog(){
        System.out.println("dog constructor called");
    }
    void walk(){ // compulsory
        System.out.println("walks on 4 legs");
    }

    void changeColor(){
        color = "dark brown";
    }
}


class Chicken extends Mammals{
    Chicken(){
        System.out.println("Chicken constructor called");
    }
    void walk(){
        System.out.println("walks on 2 legs");
    }

    void changeColor(){
        color = "yellow";
    }
}

