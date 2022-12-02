package OOPS;

public class Definitions {
    // OBJECTS 

    // objects are the entities in the real world 
    // for example: a pen
    // a pen is an object which have some property say colour
    // now this colour can be changed also 
    // so this pen object will store the property colour 
    // and a function changeColor to change the colour of the pen object



    // CLASSES 

    // class is a group of entities means objects 
    // by convention we use the first letter of our class name as capital 


    // when we run a program. then the java compiler will look for the public classs first 
    // and then in public class it will look the main function;
    /// the main funciton has to be public and static both;


    public static void main(String arg[]){
        Pen p1 = new Pen(); // created a pen object called p1
        p1.setColor("Blue");
        System.out.println(p1.color);

        p1.color = "red"; // can change the color without even using changeColor function;



        /// here we are changing the properties of the object of a class from the main function;
        // but what if we don't want to allow main function to make changes to the class objects;
        // take a case of a bankAccount class;

        // in this case we use the "Access Modifiers"
        
        // four types of access modifiers 

        /*
         * Private: access within the class(yes); within package (no); within package by subclass only(No); within package(No)
         * Default: access within the class(yes); within package (Yes); within package by subclass only(No); within package(No)
         * Protected: access within the class(yes); within package (Yes); within package by subclass only(Yes); within package(No)
         * Public: access within the class(yes); within package (yes); within package by subclass only(Yes); within package(Yes)
         */


        BankAccount myAcc = new BankAccount();
        myAcc.userName = "Akash";
        myAcc.setPassword("7278");
        
        System.out.println(myAcc.getPasswod());

    }




}

class BankAccount{
    public String userName;
    private String password;

    // Getters and setters: if some of our properties are private, then we will have to make some function
    // to get and set the value of that property 

    String getPasswod(){     // get funciton
        return this.password;
    }


    public void setPassword(String pwd){      // set funciton
        this.password = pwd;
    }
}

class Pen{
    String color;
    int tip;

    void setColor(String newColor){
        this.color = newColor;
    }
    void setTip(int newTip){
        this.tip = newTip;    // this is used to refer to the current object
    }

}




