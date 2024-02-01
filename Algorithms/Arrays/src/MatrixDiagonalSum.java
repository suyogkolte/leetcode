// Source : https://leetcode.com/problems/matrix-diagonal-sum/description/

class MatrixDiagonalSum {
    public int diagonalSum(int[][] mat) {
        int ans = 0;
        int rows = mat.length;
        int cols = mat[0].length;

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                if(i == j || (cols-1-i) == j)
                    ans = ans + mat[i][j];
            }
        }
        return ans;
    }
}