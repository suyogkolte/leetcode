/*
Given a binary matrix mat[][] containing 0’s and 1’s.
Each row of the matrix is sorted in the non-decreasing order, the task is to find the
left-most column of the matrix with at least one 1 in it.
Note: If no such column exists return -1.

e.g.
Example 1
mat[][] = {{0, 0, 0, 1}
           {0, 1, 1, 1}
           {0, 0, 1, 1}}

Output: 1 [The 2nd column of the matrix contains a 1]

Example 2
mat[][] = {{0, 0}
           {0, 0}}
Output: -1 [There is no such column which contains 1]
*/

public class Matrix_Find_Leftmost_Col_Having_One {
    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0, 1}, {1, 1, 1, 1}, {0, 0, 1, 1}};
        int res = findLeftmostColHaving1(matrix);
        if(res == -1)
            System.out.println("No column in the matrix has 1");
        else
            System.out.println("First col having value:1 can be found at " + res);

    }

    private static int findLeftmostColHaving1(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int leftmostCol = cols;

        for(int row = 0; row < rows; row++) {
            int left = 0;
            int right = cols - 1;
            while(left <= right) {
                int mid =  left + (right - left) / 2;

                if(matrix[row][mid] == 1) {
                    leftmostCol = Math.min(leftmostCol, mid);
                    right = mid - 1;
                }
                else
                    left = mid + 1;
            }
        }
        return leftmostCol < cols ? leftmostCol : -1;
    }
}
