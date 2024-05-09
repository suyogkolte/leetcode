// Source: https://leetcode.com/problems/walls-and-gates/
package Graphs_Pkg;

import java.util.*;

public class Walls_and_Gates  {
    static class Point{
        private int x;
        private int y;
        private int dist;

        public Point(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        int gridSize = m * n;

        int roomCount = 0;
        int gateCount = 0;
        int wallCount = 0;

        Queue<Point> q = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(rooms[i][j] == 0){
                    gateCount++;
                    q.add(new Point(i, j, 0));
                }
                else if(rooms[i][j] == -1)
                    wallCount++;
                else
                    roomCount++;
            }
        }

        if(gateCount < 0 || gateCount == gridSize ||
                roomCount < 0 || roomCount == gridSize ||
                wallCount == gridSize)
            return;

        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!q.isEmpty()){
            Point curr = q.poll();
            int dist = curr.dist + 1;

            for(int i = 0; i < 4; i++){
                int newR = curr.x + dir[i][0];
                int newC = curr.y + dir[i][1];

                if(newR >= 0 && newC >= 0 && newR < m && newC < n && rooms[newR][newC] != -1){
                    if(dist < rooms[newR][newC]){
                        rooms[newR][newC] = dist;
                        q.add(new Point(newR, newC, dist));
                    }

                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] rooms = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};

        System.out.println("Input:");
        for (int[] r : rooms) {
            for(int c : r){
                System.out.print(c + ", ");
            }
            System.out.println();
        }
        wallsAndGates(rooms);

        System.out.println();
        System.out.println("Output:");
        for (int[] r : rooms) {
            for(int c : r){
                System.out.print(c + ", ");
            }
            System.out.println();
        }
    }
}
