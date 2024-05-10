// Source: https://leetcode.com/problems/as-far-from-land-as-possible/description/
package Graphs_Pkg;

import java.util.*;

public class As_Far_From_Land_As_Possible {
    static class Point{
        int x;
        int y;
        int dist;

        public Point(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static int maxDistance(int[][] grid) {
        int landCount = 0;
        int waterCount = 0;
        int gridCellCount = grid.length * grid[0].length;

        Queue<Point> q = new LinkedList<>();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    grid[i][j] = -1;
                    q.add(new Point(i, j, 0));
                    landCount++;
                }
                else
                    waterCount++;
            }
        }

        if(waterCount == gridCellCount || landCount == gridCellCount)
            return -1;

        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int maxDist = 0;
        while(!q.isEmpty()){
            Point curr = q.poll();
            maxDist = curr.dist;

            for(int i = 0; i < 4; i++){
                int newR = curr.x + dir[i][0];
                int newC = curr.y + dir[i][1];

                if(newR >= 0 && newR < grid.length &&
                        newC >= 0 && newC < grid[0].length &&
                        grid[newR][newC] != -1){
                    grid[newR][newC] = -1;
                    q.add(new Point(newR, newC, maxDist + 1));
                }
            }
        }
        return maxDist;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,0,0},{0,0,0},{0,0,0}};
        System.out.println("Max distance between a water cell and a nearest land cell is " +
                maxDistance(grid));
    }
}