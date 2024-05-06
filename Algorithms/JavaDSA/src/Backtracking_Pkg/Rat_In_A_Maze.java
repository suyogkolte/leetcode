/*
Consider a rat placed at (0, 0) in a square matrix of order N * N.
It has to reach the destination at (N – 1, N – 1).
Find if there exists a path that the rat can take to reach from source to destination.
If there is a path then print it.
The directions in which the rat can move are ‘R’ (right), ‘D'(down).
Value 0 at a cell in the matrix represents that it is blocked and the rat cannot move to it
while value 1 at a cell in the matrix represents that rat can travel through it.
*/
package Backtracking_Pkg;
public class Rat_In_A_Maze {
    private static int[][] op;
    public static void main(String[] args) {
        int[][] maze = {{1, 0, 0, 0}, {1, 1, 1, 1}, {0, 1, 0, 0}, {0, 1, 1, 1}};

        op = new int[maze.length][maze[0].length];

        if(backtrack(maze, 0, 0)) {
            System.out.println("There exists a path from start to finish in the maze");
            for(int[] i : op) {
                for(int j : i){
                    System.out.print(j + "\t");
                }
                System.out.println();
            }
        }
        else
            System.out.println("There does not exist a path from start to finish in the maze");
    }

    public static boolean backtrack(int[][] maze, int row, int col) {
        // Positive base case: we have reached the destination
        if(row == maze.length - 1 && col == maze[0].length - 1) {
            op[row][col] = 1;
            return true;
        }

        // Negative base case
        if(row == maze.length || col == maze[0].length || maze[row][col] == 0)
            return false;

        //do
        // marking the path of exploration
        op[row][col] = 1;

        int[] rowOffset = {0, 1};
        int[] colOffset = {1, 0};

        //recurse
        // d means directions
        // There are 2 directions to explore: right, down
        for(int d = 0; d < 2; d++) {
            if(backtrack(maze, row + rowOffset[d], col + colOffset[d]))
                return true;
        }

        //undo
        op[row][col] = 0;
        return false;
    }
}
