// Source: https://leetcode.com/problems/surrounded-regions/

package Graphs_Pkg;

public class Surrounded_Regions {
    public static void solve(char[][] board) {
        int nr = board.length;
        int nc = board[0].length;

        // Convert all '0' to '-'
        for(int i = 0; i < nr; i++){
            for(int j = 0; j < nc; j++){
                if(board[i][j] == 'O')
                    board[i][j] = '-';
            }
        }

        // DFS on left boundary (ie first col) to convert '-' to '0'
        for(int i = 0; i < nr; i++){
            if(board[i][0] == '-')
                dfs(board, i, 0, '-', 'O');
        }

        // DFS on right boundary (ie last col) to convert '-' to '0'
        for(int i = 0; i < nr; i++){
            if(board[i][nc - 1] == '-')
                dfs(board, i, nc - 1, '-', 'O');
        }

        // DFS on top boundary (ie first row) to convert '-' to '0'
        for(int j = 0; j < nc; j++){
            if(board[0][j] == '-')
                dfs(board, 0, j, '-', 'O');
        }

        // DFS on bottom boundary (ie last row) to convert '-' to '0'
        for(int j = 0; j < nc; j++){
            if(board[nr - 1][j] == '-')
                dfs(board, nr - 1, j, '-', 'O');
        }

        // rest of cells will be - replaced by X
        for(int i = 0; i < nr; i++){
            for(int j = 0; j < nc; j++){
                if(board[i][j] == '-')
                    board[i][j] = 'X';
            }
        }
    }

    public static void dfs(char[][] board, int r, int c, char prev, char newChar){
        int nr = board.length;
        int nc = board[0].length;

        //Base case
        if(r < 0 || c < 0 || r >= nr || c >= nc)
            return;

        if(board[r][c] != prev)
            return;

        board[r][c] = newChar;

        // Explore all four directions
        dfs(board, r - 1, c, prev, newChar); // up
        dfs(board, r + 1, c, prev, newChar); // down
        dfs(board, r, c - 1, prev, newChar); // left
        dfs(board, r, c + 1, prev, newChar); // right
    }

    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};

        solve(board);

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}