// Source: https://leetcode.com/problems/pacific-atlantic-water-flow/description/

package Graphs_Pkg;

import java.util.*;

public class Pacific_Atlantic_Water_Flow {
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

    private int nRows;
    private int nCols;
    private int[][] heights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // Check if input is empty
        if(heights.length == 0 || heights[0].length == 0)
            return new ArrayList<>();

        this.nRows = heights.length;
        this.nCols = heights[0].length;
        this.heights = heights;

        // Setup each queue with cells adjacent to their respective ocean
        Queue<Point> qPacific = new LinkedList<>();
        Queue<Point> qAtlantic = new LinkedList<>();

        for(int j = 0; j < nCols; j++){
            qPacific.add(new Point(0, j, 0));
            qAtlantic.add(new Point(nRows - 1, j, 0));
        }

        for(int i = 0; i < nRows; i++){
            qPacific.add(new Point(i, 0, 0));
            qAtlantic.add(new Point(i, nCols - 1, 0));
        }

        // Perform a BFS for each ocean to find all cells accessible by each ocean
        boolean[][] pacificReachable = bfs(qPacific);
        boolean[][] atlanticReachable = bfs(qAtlantic);

        // Find all cells that can reach both oceans
        List<List<Integer>> commonCells = new ArrayList<>();
        for(int i = 0; i < nRows; i++){
            for(int j = 0; j < nCols; j++){
                if(pacificReachable[i][j] && atlanticReachable[i][j])
                    commonCells.add(List.of(i, j));
            }
        }

        return commonCells;
    }

    public boolean[][] bfs(Queue<Point> queue){
        boolean[][] reachable = new boolean[nRows][nCols];
        int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        while(!queue.isEmpty()){
            Point curr = queue.poll();
            reachable[curr.x][curr.y] = true;

            for(int i = 0; i < 4; i++){
                int newR = curr.x + dir[i][0];
                int newC = curr.y + dir[i][1];

                if(newR >= 0 && newR < nRows && newC >= 0 && newC < nCols && !reachable[newR][newC] && heights[newR][newC] >= heights[curr.x][curr.y]){
                    queue.add(new Point(newR, newC, curr.dist + 1));
                }
            }
        }

        return reachable;
    }

    public static void main(String[] args) {
        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        Pacific_Atlantic_Water_Flow flow = new Pacific_Atlantic_Water_Flow();
        System.out.println("The list of cells where rain water can flow " +
                "to both the Pacific and Atlantic oceans is ");
        System.out.println(flow.pacificAtlantic(heights));
    }
}