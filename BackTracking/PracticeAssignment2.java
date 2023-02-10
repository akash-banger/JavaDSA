package BackTracking;


public class PracticeAssignment2 {

    static int count = 0;

    // printing the solution
    public static void printSol(int matrix[][]){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    

    public static boolean isSafe(int board[][], int x, int y){ // checking if the position (x,y) is safe or not
        return (x>=0 && y>=0 && x<board.length && y<board.length) && (board[x][y] == -1);
    }

    public static boolean knightsTour(int board[][], int x, int y, int xMove[], int yMove[]){

        if(count == board.length*board.length){ // if count == n*n then return; work done
            return true;
        }

        

        if(isSafe(board, x, y)){      // checking that the current position is safe or not                                               
            board[x][y] = count++;   // if yes then placing the knight there
            for(int i=0; i<xMove.length; i++){ // now checking the next possible moves
                int nextX = x + xMove[i];
                int nextY = y + yMove[i];
                if(knightsTour(board, nextX, nextY, xMove, yMove)){
                    return true;   // if any move is true then return true 
                }
            }
            board[x][y] = -1;  // if no move is possible then BackTrack (pick up the knight from the position)
            count--; // and decrease the count 
            return false;  // and return false
        }

        return false; 
    }


    public static void main(String arg[]){
        int n = 8;
        int board[][] = new int[n][n];

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                board[i][j] = -1;
            }
        }


        int xMove[] = {2, 1, -1, -2, 2, 1, -2, -1};
        int yMove[] = {1, 2, 2, 1, -1, -2, -1, -2};


        if(knightsTour(board, 0, 0, xMove, yMove)){
            printSol(board);
        }else{
            System.out.println("solution does not exist");
        }

        
    }
}
