// Source : https://leetcode.com/problems/rotate-image/description/
package Arrays_Pkg;

class RotateImage {
    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        transpose(matrix, rows, cols);
        reverseCols(matrix, rows, cols);
    }

    public void transpose(int[][] matrix, int rows, int cols)
    {
        for(int i = 0; i < rows; i++)
        {
            for(int j = i; j < cols; j++)
            {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    public void reverseCols(int[][] matrix, int rows, int cols)
    {
        for(int p = 0; p < rows; p++)
        {
            int i = 0, j = cols-1;
            while(i < j)
            {
                int tmp = matrix[p][i];
                matrix[p][i] = matrix[p][j];
                matrix[p][j] = tmp;
                i++;
                j--;
            }
        }
    }
}