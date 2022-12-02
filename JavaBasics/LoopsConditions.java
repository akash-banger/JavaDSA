package JavaBasics;
import java.util.*;
public class LoopsConditions {
    public static void main(String arg[]){
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("working");

            // operators 
            // postincrement operator a++ : 1) value use 2) value change
            // preincrement operator ++a : 1) value change 2) value use

            System.out.println("operators");

            int a = 10;
            int b  = ++a;
            int x = 10;
            int y = x++;

            System.out.println(a);
            System.out.println(b);
            System.out.println(x);
            System.out.println(y);

            // &&: logical and ||: logical or !: not




            // ternary operator; 

            // varible = condition? statement1 : statement2
            // if the condition is true then, statemen1 will run otherwise statement2 will run
            

            System.out.println("Ternary operator");


            int u = 8;
            int v = 9;
            int c = (u>v)? u:v;
            System.out.println(c);

            System.out.println("Switch statement");


            // switch statement
            int number = 2;
            switch(number){
                case 1: System.out.println("samosa");
                        break; // to avoid the below cases to run; bcz after one case becomes true, all the cases below that case will also become true;
                case 2: System.out.println("anda");
                        break;
                case 3: System.out.println("nothing");
                        break;
                default: System.out.println("kismat kharab");

                // the case can be anything. it can be a character, string, bool also eg. case 'a', case "samosa";
            }


            // printing the reverse of a number
            System.out.println("printing reverse of a number");
            int n = sc.nextInt();
            while(n>0){
                int r = n%10;
                n/=10;
                System.out.print(r);
            }
            System.out.println(" ");

            // reversing a given number
            System.out.println("reversing a given number"); // rev = rev*10 + lastdigit;


            int n1 = sc.nextInt();
            int rev = 0;
            while(n1>0){
                int r = n1%10;
                rev = rev*10 + r;
                n1/=10;
            }
            System.out.println(rev);


            // checking a number is prime or not 
            System.out.println("checking prime number");

            int n2 = sc.nextInt();
            boolean test = true;
            for(int i=2; i<=Math.sqrt(n); i++){
                if(n2%i==0){
                    System.out.println("non prime");
                    test = false;
                    break;
                }
            }
            if(test == true){
                System.out.println("prime");
            }


            // Some patterns

            System.out.println("some patterns");
            int s = sc.nextInt();
            for(int i=1; i<=s; i++){
                for(int j=1; j<=i; j++){
                    System.out.print("*");
                }
                System.out.println("");
            }


            for(int i=s; i>=1; i--){
                for(int j=1; j<=i; j++){
                    System.out.print("*");
                }
                System.out.println("");
            }

            for(int i=1; i<=s; i++){
                if(i%2==0){
                    continue;
                }
                for(int j=1; j<=(s-i)/2; j++){
                    System.out.print(" ");
                }
                for(int j=1; j<=i; j++){
                    System.out.print("*");
                }
                for(int j=1; j<=(s-i)/2; j++){
                    System.out.print(" ");
                }
                System.out.println("");
            }

            for(int i=s; i>=1; i--){
                if(i%2==0){
                    continue;
                }
                for(int j=1; j<=(s-i)/2; j++){
                    System.out.print(" ");
                }
                for(int j=1; j<=i; j++){
                    System.out.print("*");
                }
                for(int j=1; j<=(s-i)/2; j++){
                    System.out.print(" ");
                }
                System.out.println("");
            }
            
            // just to make a design

            for(int i=1; i<=s; i++){
                for(int j=1; j<=i; j++){
                    System.out.print("*");
                }
                System.out.println("");
            }


            for(int i=s; i>=1; i--){
                for(int j=1; j<=i; j++){
                    System.out.print("*");
                }
                System.out.println("");
            }


            // Character pattern

            System.out.println("charater pattern");

            int g = sc.nextInt();
            char ch = 'A';
            for(int i=0; i<g; i++){
                for(int j=0; j<=i; j++){
                    System.out.print(ch);
                    ch++;
                }
                System.out.println("");
            }
        }
        








    }

}