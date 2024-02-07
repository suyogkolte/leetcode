// Source : https://leetcode.com/problems/spiral-matrix/description/

import java.util.List;
import java.util.ArrayList;

class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int sr = 0;
        int er = m - 1;
        int sc = 0;
        int ec = n - 1;
        int count = m * n;

        while(count > 0)
        {
            for(int i = sc; i <= ec; i++)
            {
                ans.add(matrix[sr][i]);
                count--;
            }
            sr++;
            if(count == 0) break;

            for(int j = sr; j <= er; j++)
            {
                ans.add(matrix[j][ec]);
                count--;
            }
            ec--;
            if(count == 0) break;

            for(int i = ec; i >= sc; i--)
            {
                ans.add(matrix[er][i]);
                count--;
            }
            er--;
            if(count == 0) break;

            for(int j = er; j >= sr; j--)
            {
                ans.add(matrix[j][sc]);
                count--;
            }
            sc++;
            if(count == 0) break;
        }

        return ans;
    }
}