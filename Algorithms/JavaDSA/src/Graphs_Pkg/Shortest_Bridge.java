// Source: https://leetcode.com/problems/shortest-bridge/description/

package Graphs_Pkg;

import java.util.LinkedList;
import java.util.Queue;

public class Shortest_Bridge {
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

    private static Queue<Point> qToIdentifyFirstIsland = new LinkedList<>();
    private static Queue<Point> qToStartMultiSourceBFSFirstIsland = new LinkedList<>();

    public static void printGrid(int[][] grid){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void findFirstIsland_BFS(int[][] grid){
        boolean bFoundFirstIsland = false;

        for(int i = 0; i < grid.length; i++){
            for(int j= 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    grid[i][j] = -1;
                    qToIdentifyFirstIsland.add(new Point(i, j, 0));
                    qToStartMultiSourceBFSFirstIsland.add(new Point(i, j, 0));
                    bFoundFirstIsland = true;
                    break;
                }
            }

            if(bFoundFirstIsland)
                break;
        }

        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!qToIdentifyFirstIsland.isEmpty()){
            Point curr = qToIdentifyFirstIsland.poll();

            for(int i = 0; i < 4; i++){
                int newR = curr.x + dir[i][0];
                int newC = curr.y + dir[i][1];

                if(newR >= 0 && newR < grid.length && newC >= 0 && newC < grid[0].length && grid[newR][newC] == 1){
                    grid[newR][newC] = -1;
                    qToIdentifyFirstIsland.add(new Point(newR, newC, 0));
                    qToStartMultiSourceBFSFirstIsland.add(new Point(newR, newC, 0));
                }
            }
        }
    }

    public static int shortestBridge(int[][] grid) {
        // Clearing queues for leetcode
        qToIdentifyFirstIsland.clear();
        qToStartMultiSourceBFSFirstIsland.clear();

        // Find the first island
        findFirstIsland_BFS(grid);
        int shortestDist = 0;

        // four directions
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // multi-source BFS from all points in the first island
        while(!qToStartMultiSourceBFSFirstIsland.isEmpty()){
            Point curr = qToStartMultiSourceBFSFirstIsland.poll();
            shortestDist = curr.dist;

            for(int i = 0; i < 4; i++){
                int newR = curr.x + dir[i][0];
                int newC = curr.y + dir[i][1];

                if(newR >= 0 && newR < grid.length && newC >= 0 && newC < grid[0].length && grid[newR][newC] != -1){
                    if(grid[newR][newC] == 1)
                        return shortestDist;

                    grid[newR][newC] = -1;
                    qToStartMultiSourceBFSFirstIsland.add(new Point(newR, newC, curr.dist + 1));
                }
            }
        }

        return shortestDist;
    }

    public static void main(String[] args) {
        //int[][] grid = {{1,0,0,0,0,1}, {1,1,0,0,1,1}, {1,1,0,0,1,1}, {0,1,1,0,0,0}, {0,1,0,0,0,0}};
        int[][] grid = {{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}};
        System.out.println("Input grid");
        printGrid(grid);
        System.out.println();

        System.out.println("Shortest bridge distance is " + shortestBridge(grid));
        //printGrid(grid);
    }
}
