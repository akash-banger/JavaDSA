package JavaBasics;

public class AdvancedPatterns {
    // Some Advanced Patterns
    // Hollow Rectangle 
    public static void hollowRectange(int n){
        int b = n*4/5;
        for(int i=1; i<=b; i++){
            for(int j=1; j<=n; j++){
                if((j==1 || j==n) || (i==1 || i==b)){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }
    }


    // half-pyramid
    public static void invertedPyramid(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n-i; j++){
                System.out.print("  ");
            }
            for(int j=1; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println("");
        }
    }

    // half-pyramid with numbers
    public static void invertedPyramidWithNum(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n-i; j++){
                System.out.print("  ");
            }
            for(int j=1; j<=i; j++){
                System.out.print(j+ " ");
            }
            System.out.println("");
        }
    }

    //Floyd's triangle
    public static void floydsTriangle(int n){
        int m=1;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(m + " ");
                m++;
            }
            System.out.println("");
        }
    }

    // 0-1 triangle
    public static int boolToInt(boolean a){
        if(a==true){
            return 1;
        }
        return 0;
    }
    public static void zeroOneTriangle(int n){
        boolean m = true;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(boolToInt(m) + " ");
                m = !m;
            }
            System.out.println("");
        }
    }
    // another method to do this is to consider the sum of i and j for the matrix.
    // if i+j is odd thn print 0 otherwise print 1;



    // butterfly structure
    public static void butterfly(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print("* ");
            }
            for(int j=1; j<=2*(n-i); j++){
                System.out.print("  ");
            }
            for(int j=1; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println("");
        }
        for(int i=n; i>=1; i--){
            for(int j=1; j<=i; j++){
                System.out.print("* ");
            }
            for(int j=1; j<=2*(n-i); j++){
                System.out.print("  ");
            }
            for(int j=1; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println("");
        }
    }



    // Solid rhombus
    public static void solidRhombus(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=2*n-i; j++){
                if(j<=n-i){
                    System.out.print("  ");
                }else{
                    System.out.print("* ");
                }
            }
            System.out.println("");
        }
    }




    // hollow Solid rhombus
    public static void hollowSolidRhombus(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=2*n-i; j++){
                if(j<=n-i){
                    System.out.print("  ");
                }else{
                    if(i==1 || i==n || j==n-i+1 || j==2*n-i){
                        System.out.print("* ");
                    }else{
                        System.out.print("  ");
                    }
                }
            }
            System.out.println("");
        }
    }



    // Diamond
    public static void diamond(int n){
        int m = 1;
        for(int i=1; i<=2*n; i+=2){
            for(int j=1; j<=n-m; j++){
                System.out.print("  ");
            }
            for(int j=1; j<=i; j++){
                System.out.print("* ");
            }
            m++;
            System.out.println("");
        }
        int m1 = n;
        for(int i=2*n-1; i>=1; i-=2){
            for(int j=1; j<=n-m1; j++){
                System.out.print("  ");
            }
            for(int j=1; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println("");
            m1--;
        }

        
    }

    // number pyramid;
    public static void numberPyramid(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=(n-i); j++){
                System.out.print(" ");
            }
            for(int j=1; j<=i; j++){
                System.out.print(i+" ");
            }
            System.out.println("");
        }
    }

    // palindrome pattern with numbers 
    public static void palindrome(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n-i; j++){
                System.out.print("  ");
            }
            for(int j=i; j>=1; j--){
                System.out.print(j + " ");
            }
            for(int j=2; j<=i; j++){
                System.out.print(j + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String arg[]){
        hollowRectange(5);
        invertedPyramid(5);
        invertedPyramidWithNum(5);
        floydsTriangle(5);
        zeroOneTriangle(5);
        butterfly(5);
        solidRhombus(6);
        hollowSolidRhombus(5);
        diamond(5);
        numberPyramid(7);
        palindrome(6);
    }
}
