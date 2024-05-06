// Source: https://leetcode.com/problems/number-of-islands/description/
package Graphs_Pkg;

public class Number_Of_Islands {
    public static int numIslands(char[][] grid) {
        //Corner case
        if(grid == null || grid.length == 0)
            return 0;

        int nr = grid.length;
        int nc = grid[0].length;

        int num_islands = 0;

        for(int r = 0; r < nr; r++){
            for(int c = 0; c < nc; c++){
                if(grid[r][c] == '1'){
                    num_islands++;
                    dfs(grid, r, c);
                }
            }
        }

        return num_islands;
    }

    private static void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        //Base case
        if(r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0')
            return;

        // Mark the current cell as visited
        grid[r][c] = '0';

        //Explore all four directions
        dfs(grid, r - 1, c); // up
        dfs(grid, r + 1, c); // down
        dfs(grid, r, c - 1); // left
        dfs(grid, r, c + 1); // right
    }

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'}};

        System.out.println("The number of islands in the grid is " + numIslands(grid));
    }
}
