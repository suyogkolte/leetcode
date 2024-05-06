// Source : https://leetcode.com/problems/transpose-matrix/description/
package Arrays_Pkg;

class TransposeMatrix {
    public int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] ans = new int[cols][rows];
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                ans[j][i] = matrix[i][j];
            }
        }
        return ans;
    }
}