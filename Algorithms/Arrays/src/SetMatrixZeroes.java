// Source : https://leetcode.com/problems/set-matrix-zeroes/description/

class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean isRow = false;
        boolean isCol = false;

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                if(matrix[i][j] == 0)
                {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                    if(i == 0)
                        isRow = true;

                    if(j == 0)
                        isCol = true;
                }
            }
        }

        for(int i = 1; i < rows; i++)
        {
            for(int j = 1; j < cols; j++)
            {
                if(matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][j] = 0;
            }
        }

        if(isRow)
        {
            for(int j = 0; j < cols; j++)
            {
                matrix[0][j] = 0;
            }
        }

        if(isCol)
        {
            for(int i = 0; i < rows; i++)
            {
                matrix[i][0] = 0;
            }
        }

    }
}