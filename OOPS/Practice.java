package OOPS;
public class Practice{
    public static void main(String arg[]){
        // we can write
        Vehicle c = new Car();

        // Car v = new Vehicle(); // cannot write this


        Complex c1 = new Complex(5,6);
        Complex c2 = new Complex(3, 2);
        c1.sum(c2);
    }
}

// a class cannot be private and protected in java

// parent reference  = child object (true)
// child reference = parent object (false)
// example 

class Vehicle{}
class Car extends Vehicle{}


// varibles in the class will be initialized with null value if you don't give any value to it.

class Complex{
    int real;
    int imag;
    Complex(int real, int imag){
        this.real = real;
        this.imag = imag;
    }
    void sum(Complex c){
        System.out.println((this.real+c.real)+"+"+"i"+(this.imag+c.imag));
    }
}