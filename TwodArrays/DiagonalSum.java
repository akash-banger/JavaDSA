package TwodArrays;

public class DiagonalSum {
    public static void diagonalSum(int matrix[][]){
        int n=0;
        int m=matrix.length-1;
        int pSum = 0;
        int sSum = 0;
        while(n<=matrix.length-1){
            pSum+= matrix[n][n];
            sSum+= matrix[m][m];
            n++;
            m--;
        }
        if(matrix.length%2!=0){
            pSum-= matrix[matrix.length/2][matrix.length/2];
        }
        System.out.println(pSum+sSum);
    }
    public static void main(String arg[]){
        int matrix[][] ={{1,2,3},
                         {5,6,7},
                         {9,10,11},};
        diagonalSum(matrix);
    }
}
