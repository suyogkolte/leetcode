// Source: https://leetcode.com/problems/map-of-highest-peak/
package Graphs_Pkg;

import java.util.*;

public class Map_of_Highest_Peak {
    static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static int[][] highestPeak(int[][] isWater) {
        int rows = isWater.length;
        int cols = isWater[0].length;
        int waterCount = 0;
        int landCount = 0;
        int cellCount = rows * cols;
        int[][] res = new int[rows][cols];

        Queue<Point> q = new LinkedList<>();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(isWater[i][j] == 1){
                    res[i][j] = 0;
                    isWater[i][j] = -1;
                    q.add(new Point(i, j));
                    waterCount++;
                }
                else
                    landCount++;
            }
        }

        if(waterCount == cellCount)
            return res;

        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int maxHt = 0;

        while(!q.isEmpty()){
            Point curr = q.poll();
            maxHt = res[curr.x][curr.y];

            for(int i = 0; i < 4; i++){
                int newR = curr.x + dir[i][0];
                int newC = curr.y + dir[i][1];

                if(newR >= 0 && newR < rows
                        && newC >= 0 && newC < cols
                        && isWater[newR][newC] != -1){
                    res[newR][newC] = maxHt + 1;
                    q.add(new Point(newR, newC));
                    isWater[newR][newC] = -1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] isWater = {{0,1},{0,0}};
        int[][] res = highestPeak(isWater);

        for(int i = 0; i < res.length; i++){
            for(int j = 0; j < res[0].length; j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
