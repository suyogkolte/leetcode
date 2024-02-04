// Source : https://leetcode.com/problems/richest-customer-wealth/description/

class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int ans = 0;
        int rows = accounts.length;
        int cols = accounts[0].length;

        for(int i = 0; i < rows; i++)
        {
            int sum = 0;
            for(int j = 0; j < cols; j++)
            {
                sum = sum + accounts[i][j];
            }

            ans = Math.max(sum, ans);
        }
        return ans;
    }
}