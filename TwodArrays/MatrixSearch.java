package TwodArrays;

public class MatrixSearch{
    public static Boolean searchMatrixx(int matrix[][],int key){
        int row = 0;
        int col = matrix[0].length-1;
        while(row<=matrix.length-1 && col>=0){
            if(matrix[row][col]==key){
                System.out.println(row+","+col);
                return true;
            }else if(key>matrix[row][col]){
                row++;
            }else{
                col--;
            }
        }
        return false;
    }
    public static void main(String arg[]){
        int matrix[][] ={{1,2,3},
                         {5,6,7},
                         {9,10,11},};
        int key = 8;
        System.out.println(searchMatrixx(matrix,key));
    }



    // time complexity O(n+m);
}
