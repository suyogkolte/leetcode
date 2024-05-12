//Source:

package Graphs_Pkg;

import java.util.*;

public class Number_of_Enclaves{
    static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    int nRows;
    int nCols;
    int[][] grid;

    public int numEnclaves(int[][] grid) {
        this.nRows = grid.length;
        this.nCols = grid[0].length;
        this.grid = grid;

        // BFS queue for grid left column
        Queue<Point> qLeft = new LinkedList<>();
        for(int i = 0; i < nRows; i++){
            if(grid[i][0] == 1){
                grid[i][0] = -1;
                qLeft.add(new Point(i, 0));
                bfs(qLeft);
            }
        }

        // BFS queue for grid right column
        Queue<Point> qRight = new LinkedList<>();
        for(int i = 0; i < nRows; i++){
            if(grid[i][nCols - 1] == 1){
                grid[i][nCols - 1] = -1;
                qRight.add(new Point(i, nCols - 1));
                bfs(qRight);
            }
        }

        // BFS queue for grid top row
        Queue<Point> qTop = new LinkedList<>();
        for(int j = 0; j < nCols; j++){
            if(grid[0][j] == 1){
                grid[0][j] = -1;
                qTop.add(new Point(0, j));
                bfs(qTop);
            }
        }

        // BFS queue for grid bottom row
        Queue<Point> qBottom = new LinkedList<>();
        for(int j = 0; j < nCols; j++){
            if(grid[nRows - 1][j] == 1){
                grid[nRows - 1][j] = -1;
                qBottom.add(new Point(nRows - 1, j));
                bfs(qBottom);
            }
        }

        // Once done with all BFS then count the number of remaining 1
        int ans = 0;
        for(int i = 0; i < nRows; i++){
            for(int j = 0; j < nCols; j++){
                if(grid[i][j] == 1)
                    ans++;
            }
        }

        return ans;
    }

    public void bfs(Queue<Point> q){
        // BFS will mark all grid cells with value as -1 which are reachable from the grid borders
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!q.isEmpty()){
            Point curr = q.poll();

            for(int i = 0; i < 4; i++){
                int newR = curr.x + dir[i][0];
                int newC = curr.y + dir[i][1];

                if(newR >= 0 && newR < nRows && newC >= 0 && newC < nCols && grid[newR][newC] == 1){
                    grid[newR][newC] = -1;
                    q.add(new Point(newR, newC));
                }
            }
        }
    }

    public static void main(String[] args) {
        Number_of_Enclaves obj = new Number_of_Enclaves();
        int[][] grid = {{0,1,1,0,0,0,0,1,1,0,0,0},
                        {1,0,1,1,1,0,1,0,1,1,1,0},
                        {1,1,0,1,0,0,1,1,0,1,1,1},
                        {1,0,0,1,1,0,1,0,1,0,1,0},
                        {1,0,0,0,0,1,0,0,1,1,0,1},
                        {1,1,1,0,0,0,1,0,0,1,1,1},
                        {1,1,1,0,0,0,0,1,0,1,0,1},
                        {0,1,1,1,1,0,0,1,1,0,0,0},
                        {0,1,0,1,0,1,0,1,0,0,0,1},
                        {0,0,1,0,1,1,0,0,0,1,1,1}};

        System.out.println("The number of land cells in grid for which we cannot walk off the " +
                "boundary of the grid in any number of moves is ");
        System.out.println(obj.numEnclaves(grid));
    }
}