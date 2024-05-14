// Source: https://leetcode.com/problems/escape-the-spreading-fire/description/

package Graphs_Pkg;

import java.util.*;

public class Escape_the_Spreading_Fire {
    static class Point{
        int x;
        int y;
        int z; // represents distFromFire while doing BFS to calculate fire spread as well as waitTime while calculating ok to stay at initial position in grid

        public Point(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.z = dist;
        }
    }

    public int maximumMinutes(int[][] grid) {
        int nRows = grid.length;
        int nCols = grid[0].length;
        int[][] dist = new int[nRows][nCols];

        // set dist array values to Integer MAX
        for(int[] row : dist){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // queue to calculate the spread of fire using BFS
        Queue<Point> q = new LinkedList<>();

        // Parse grid and set fire cell to 0 and add to BFS queue
        for(int i = 0; i < nRows; i++){
            for(int j = 0; j < nCols; j++){
                if(grid[i][j] == 1){
                    //fire
                    dist[i][j] = 0;
                    q.add(new Point(i, j, 0));
                }
            }
        }

        // four directions
        int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        // BFS for fire spread
        while(!q.isEmpty()){
            Point curr = q.poll();
            grid[curr.x][curr.y] = -1;

            for(int i = 0; i < 4; i++){
                int newR = curr.x + dir[i][0];
                int newC = curr.y + dir[i][1];

                if(newR >= 0 && newR < nRows && newC >= 0 && newC < nCols && grid[newR][newC] != 2 && grid[newR][newC] != -1){
                    dist[newR][newC] = curr.z + 1;
                    q.add(new Point(newR, newC, curr.z + 1));
                }
            }
        }

        /* Binary search to find the time you can spend in initial position*/
        int ans = -1;
        int left = 0;
        int right =  (nRows * nCols) + 1; // question says 10^9 but we can optimise it to (nRows * nCols) + 1

        while(left <= right){
            int mid = left + (right - left)/2;

            if(ok(grid, dist, mid)){
                ans = mid;
                left = mid + 1;
            }
            else
                right = mid - 1;
        }

        if(ans >= (nRows * nCols) + 1)
            return 1000000000;

        return ans;
    }

    public boolean ok(int[][] grid, int[][] dist, int waitTime){
        // BFS to calculate ok to stay at initial position in grid

        int nRows = grid.length;
        int nCols = grid[0].length;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, waitTime));  // start BFS from grid[0][0] to grid[nRows-1][nCols-1]

        int[][] visited = new int[nRows][nCols];
        visited[0][0] = 1;

        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!q.isEmpty()){
            Point curr = q.poll();

            for(int i = 0; i < 4; i++){
                int newR = curr.x + dir[i][0];
                int newC = curr.y + dir[i][1];

                if(newR >= 0 && newR < nRows && newC >= 0 && newC < nCols && visited[newR][newC] != 1 && grid[newR][newC] != 2){
                    if(newR == nRows - 1 && newC == nCols - 1 && dist[newR][newC] >= curr.z + 1){
                        // you have reached the end of grid before fire reaches you
                        return true;
                    }

                    // Proceed only if fire reaches after you have passed the current cell
                    if (dist[newR][newC] > curr.z + 1) {
                        q.add(new Point(newR, newC, curr.z + 1));
                        visited[newR][newC] = 1;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
    int[][] grid = {{0,2,0,0,0,0,0},{0,0,0,2,2,1,0},{0,2,0,0,1,2,0},{0,0,2,2,2,0,2},{0,0,0,0,0,0,0}};
        Escape_the_Spreading_Fire obj = new Escape_the_Spreading_Fire();
        System.out.println("The maximum number of minutes that you can stay " +
                "in your initial position is " + obj.maximumMinutes(grid));
    }
}