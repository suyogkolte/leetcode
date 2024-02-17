// Source: https://leetcode.com/problems/word-search/description/

public class Word_Search {
    private char[][] board;

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";

        Word_Search ws = new Word_Search();
        if(ws.exist(board, word))
            System.out.println(word + " exists in the given board");
        else
            System.out.println(word + " doesn't exist in the given board");
    }

    public boolean exist(char[][] board, String word) {
        this.board = board;

        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[0].length; col++) {
                if(backtrack(row, col, word, 0))
                    return true;
            }
        }
        return false;
    }

    public boolean backtrack(int row, int col, String word, int wordIdx) {
        // Positive base case
        if(wordIdx == word.length())
            return true;

        // Negative base case
        if(row < 0 || row == board.length
                || col < 0 || col == board[0].length
                || board[row][col] != word.charAt(wordIdx)) {
            return false;
        }

        // do
        // marking the path of exploration
        this.board[row][col] = '#';

        int[] rowOffset = {0, 1, 0, -1};
        int[] colOffset = {1, 0, -1, 0};

        // recurse
        // d means directions
        // There are 4 directions to explore: right, down, left, up
        for(int d = 0; d < 4; d++) {
            if(backtrack(row + rowOffset[d], col + colOffset[d], word, wordIdx + 1))
                return true;
        }

        // undo
        this.board[row][col] = word.charAt(wordIdx);
        return false;
    }
}
