// Source : https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/
class Solution {
    public int countNegatives(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int ans = 0;

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                if(grid[i][j] < 0)
                    ans++;
            }
        }
        return ans;
    }
}