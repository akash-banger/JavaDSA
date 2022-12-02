package OOPS;

public class Interfaces {
    // just like the class is the blueprint of object.

    // Interface is a blueprint of class

    // first use of interface is multiple Inheritance
    // multiple Inheritance means two base class and one derived class from both the classes 
    // and the second thing is 100% Abstraction (total abstraction)



    /* Interfaces
     * All the method are public, abstract and withoud implementation
     * Used to achieve total abstraction
     * Varibles in interface are final, public and static
     */

    // to extend an interface we use the keyword "implements"


    public static void main(String arg[]){
        Queen q = new Queen();
        q.moves();
    }
}

interface ChessPlayer{
    void moves(); // by default public and abstract;
}

class Queen implements ChessPlayer{
    public void moves(){
        System.out.println("up, down, left, right, diagonal - (any number of steps)");
    }
}

class king implements ChessPlayer{
    public void moves(){
        System.out.println("up, down, left, right, diagonal - (one step)");
    }
}