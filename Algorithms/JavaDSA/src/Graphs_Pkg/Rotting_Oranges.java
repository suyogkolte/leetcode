// Source: https://leetcode.com/problems/rotting-oranges/description/

package Graphs_Pkg;

import java.util.Arrays;
import java.util.*;

public class Rotting_Oranges {
    static class Point{
        int x;
        int y;
        int time;

        public Point(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static int orangesRotting(int[][] grid) {
        int nFreshOranges = 0;
        int nRottenOranges = 0;
        int time = 0;

        // BFS queue
        Queue<Point> q = new LinkedList<>();

        // first, we get all rotten oranges at start time and add to BFS queue
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1)
                    nFreshOranges++;

                if(grid[i][j] == 2){
                    nRottenOranges++;
                    q.add(new Point(i, j, 0));
                }
            }
        }

        if(nFreshOranges == 0)
        {
            // No fresh oranges
            return 0;
        }


        if(nRottenOranges == 0){
            // No rotten oranges, so no rotting can happen
            return -1;
        }

        // four directions
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!q.isEmpty()){
            int size = q.size();
            while (size > 0) {
                Point curr = q.poll();
                time = curr.time + 1;

                for (int i = 0; i < 4; i++) {
                    int newR = curr.x + dir[i][0];
                    int newC = curr.y + dir[i][1];

                    if (newR >= 0 && newC >= 0 && newR < grid.length && newC < grid[0].length && grid[newR][newC] == 1) {
                        // Make the fresh orange rotten
                        grid[newR][newC] = 2;

                        // add neighbor to BFS queue
                        q.add(new Point(newR, newC, time));
                    }
                }
                size--;
            }
            time++;
        }
        return time;
    }

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }
}