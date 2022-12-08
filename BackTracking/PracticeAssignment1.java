package BackTracking;

public class PracticeAssignment1 {

    // checking the safety
    public static boolean isSafe(int maze[][], int x, int y){
        return (x>=0 && y>=0 && x<maze.length && y<maze.length) && (maze[x][y] == 1);
    }


    // nothing just sending the solMaze and (0,0) to main ratMaze function
    public static void ratMazeHelp(int maze[][]){
        int solMaze[][] = new int[maze.length][maze.length];
        if(ratMaze(maze, 0, 0, solMaze)){
            printSol(solMaze);
        }else{
            System.out.println("Solution Does Not Exist");
        }

    }


    // the real function which will work on the problem
    public static boolean ratMaze(int maze[][], int x, int y, int solMaze[][]){
        if(isSafe(maze,x,y) && x==maze.length-1 && y==maze.length-1){ // if we are on the destination and the destination is safe then update the solution maze and return true;
            solMaze[x][y] = 1;
            return true;
        }

        if(isSafe(maze, x, y)){ // otherwise check that the current position is safe or not
            solMaze[x][y] = 1;  // if safe then update the solution maze
            if(ratMaze(maze, x+1, y, solMaze)){ // Go to the write direction and check if we are going correct
                return true;
            }
            if(ratMaze(maze, x, y+1, solMaze)){ // Go down and check if we are correct
                return true;
            }
            solMaze[x][y] = 0;  // if there is no way, means we took a wrong step before so delete that step // right or down
            return false;  
        }


        return false; // if there is no way then return false solution does'nt exist 
    }



    public static void printSol(int matrix[][]){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String arg[]){
        int maze[][] = {{1,0,0,0},
                        {1,1,0,1},
                        {0,1,0,0},
                        {1,1,1,1}};

        ratMazeHelp(maze);
    }
}
