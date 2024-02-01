// Source : https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/description/
class FindTicTacToeWinner {
    public String tictactoe(int[][] moves) {
        int mvRows = moves.length;
        int mvCols = moves[0].length;

        char[][] grid = new char[3][3];

        // Fill the 3x3 grid with 'N'
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                grid[i][j] = 'N';
            }
        }

        // Parse the moves array and fill the grid with 'A'/'B'
        int iMov = 0;
        while(iMov < mvRows)
        {
            int r = moves[iMov][0];
            int c = moves[iMov][1];

            if(iMov % 2 == 0)
                grid[r][c] = 'A';
            else
                grid[r][c] = 'B';

            iMov++;
        }

        //If A wins
        for(int i = 0; i < 3; i++)
        {
            if(grid[i][0] == 'A' && grid[i][1] == 'A' && grid[i][2] == 'A')
                return "A";
            if(grid[0][i] == 'A' && grid[1][i] == 'A' && grid[2][i] == 'A')
                return "A";
        }
        if(grid[0][0] == 'A' && grid[1][1] == 'A' && grid[2][2] == 'A')
            return "A";
        if(grid[2][0] == 'A' && grid[1][1] == 'A' && grid[0][2] == 'A')
            return "A";

        //If B wins
        for(int i = 0; i < 3; i++)
        {
            if(grid[i][0] == 'B' && grid[i][1] == 'B' && grid[i][2] == 'B')
                return "B";
            if(grid[0][i] == 'B' && grid[1][i] == 'B' && grid[2][i] == 'B')
                return "B";
        }
        if(grid[0][0] == 'B' && grid[1][1] == 'B' && grid[2][2] == 'B')
            return "B";
        if(grid[2][0] == 'B' && grid[1][1] == 'B' && grid[0][2] == 'B')
            return "B";

        // For Pending
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                if(grid[i][j] == 'N')
                    return "Pending";
            }
        }

        return "Draw";
    }
}