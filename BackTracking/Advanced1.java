package BackTracking;

public class Advanced1 {
    // n queens problem
    // n*n board and n queens 
    // print all the poosible ways in which these n queens with no queen attacking each other 

    // just for the solution is posssible or not
    public static boolean nQueensProblem(int board[][], int i){
        int n = board.length;
        if(i==n){
            count++;
            // System.out.println("---------chess board-----------");
            // printMatrix(board);
            return true;
        }
        int j=0;
        while(j<n){
            if(queenSafe(board, i, j)){
                board[i][j] = 1;
                if(nQueensProblem(board, i+1)){
                    return true;
                }
                board[i][j] = 0;
            }
            j++;
        }
        return false;
    }
    // time complexity is O(n!)




    // public static void nQueensProblem(int board[][], int i){
    //     int n = board.length;
    //     if(i==n){
    //         count++;
    //         printMatrix(board);
    //         System.out.println("---------chess board-----------");
    //         return;
    //     }
    //     int j=0;
    //     while(j<n){
    //         if(queenSafe(board, i, j)){
    //             board[i][j] = 1;
    //             nQueensProblem(board, i+1);
    //             board[i][j] = 0;
    //         }
    //         j++;
    //     }
    // }





    public static boolean queenSafe(int board[][], int i, int j){
        // coloumn
        for(int k=i-1; k>=0; k--){
            if(board[k][j]==1){
                return false;
            }
        }

        // left diagonal
        for(int n = i-1,m = j-1; (m>=0 && n>=0); m--,n--){
            if(board[n][m]==1){
                return false;
            }
        }

        // right diagonal
        for(int n = i-1,m = j+1; (n>=0 && m<board.length); m++,n--){
            if(board[n][m]==1){
                return false;
            }
        }
        return true;
    }






    public static void printMatrix(int matrix[][]){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }






    static int count = 0;
    public static void main(String arg[]){
        int n = 4;
        int board[][] = new int[n][n];
        // nQueensProblem(board, 0);
        // System.out.println(count);

        if(nQueensProblem(board, 0)){
            System.out.println("yes solution is possible");
            System.out.println("---------chess board-----------");
            printMatrix(board);
        }else{
            System.out.println("solution is not possible");
        }
    }
}
