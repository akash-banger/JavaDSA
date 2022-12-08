package BackTracking;

public class Advanced2 {
    // Grid ways
    // you are given a n*m board 
    // you have to find the number of ways in which you can go from (0,0) to (n-1,m-1);
    // allowed moves are only right and down

    public static int gridWays(int n, int m, int i, int j){
        if(i==n-1 && j==m-1){ // you are on the target
            return 1;
        }else if(i==n-1 || j==m-1){ // when you are at the column or row of the target
            return 1;
        }
        int f1 = gridWays(n, m, i+1, j); // go down 
        int f2 = gridWays(n, m, i, j+1); // go right

        return f1 + f2; // possibilities after going right + possibilities after going down
    }
    // the time complexity here is O(2^(m+n))


    // to optimize the code. we can use the permutations.
    // see for going from 0,0 to n-1,m-1 we need n-1 down steps and m-1 right steps 
    // so we just have to arrange these steps 
    

    public static int fact(int n){
        if(n==0 || n==1){
            return 1;
        }
        return n*fact(n-1);
    }
    public static int gridWaysOpt(int n, int m){
        return fact(n+m-2)/(fact(n-1)*fact(m-1));
    }



    public static void main(String arg[]){
        System.out.println(gridWaysOpt(3, 3));
    }
}
