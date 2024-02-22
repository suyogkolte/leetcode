// Source: https://leetcode.com/problems/n-queens/description/

public class N_Queens {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        solveNQueens(board, 0, 0, 0, n, "");
    }

    private static void solveNQueens(boolean[][] board, int row, int col, int qpsf, int tq, String ans) {
        // qpsf means queens placed so far on the board
        //tq means total queens to be placed

        // positive base case
        if(qpsf == tq) {
            System.out.println(ans);
            return;
        }

        // manually changing the row
        if(col == board[0].length) {
            row = row + 1;
            col = 0;
        }

        if(row == board.length)
            return;

        if(isSafeToPlaceQueen(board, row, col)) {
            // It is safe to place the current queen at the current row and col

            //do
            board[row][col] = true;

            //recurse
            // Once a queen is placed on a row, the next queen cannot be placed on the same row
            // Hence, we pass row + 1 and col below
            solveNQueens(board, row + 1, 0, qpsf + 1, tq, ans + "{" + row + "-" + col + "}");

            //undo
            board[row][col] = false;
        }

        // It is not safe to place the current queen at the current row and col
        // so, we pass row and col+1
        solveNQueens(board, row, col + 1, qpsf, tq, ans);
    }

    private static boolean isSafeToPlaceQueen(boolean[][] board, int row, int col) {
        //we check four directions
        //vertically upward
        int r = row - 1;
        int c = col;
        while(r >= 0){
            if(board[r][c])
                return false;

            r--;
        }

        //horizontally left
        r = row;
        c = col - 1;
        while (c >= 0) {
            if(board[r][c])
                return false;

            c--;
        }

        //diagonally left
        r = row - 1;
        c = col - 1;
        while(r >= 0 && c >= 0) {
            if(board[r][c])
                return false;

            r--;
            c--;
        }

        //diagonally right
        r = row - 1;
        c = col + 1;
        while(r >= 0 && c < board[0].length) {
            if(board[r][c])
                return false;

            r--;
            c++;
        }

        return true;
    }
}
