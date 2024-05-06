//Source: https://leetcode.com/problems/plates-between-candles/description/
//Good explanation: https://www.youtube.com/watch?v=4Ch3Zt5qGeA
package Strings_Pkg;

public class Plates_Between_Candles {
    public static void main(String[] args) {
        String  s = "**|**|***|";
        int[][] queries = {{2,5}, {5,9}};
        System.out.println("The number of plates between candles is ");
        int[] result = platesBetweenCandles(s, queries);

        for (int i = 0; i < result.length; i++) {
            System.out.println("query: [" + queries[i][0] + "][" + queries[i][1] + "]: "+ result[i]);
        }
    }

    public static int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] prefixSum = new int[n];
        int[] candle_left = new int[n];
        int[] candle_right = new int[n];

        prefixSum[0] = s.charAt(0) == '*' ? 1 : 0;
        candle_left[0] = s.charAt(0) == '|' ? 0 : -1;
        for(int i = 1; i < n; i++){
            // time complexity: O(n) where n is length of s
            prefixSum[i] = prefixSum[i - 1] + (s.charAt(i) == '*' ? 1 : 0);
            candle_left[i] = s.charAt(i) == '|' ? i : candle_left[i - 1];
        }

        candle_right[n - 1] = s.charAt(n - 1) == '|' ? n - 1 : n;
        for(int i = n - 2; i >= 0; i--){
            // time complexity: O(n) where n is length of s
            candle_right[i] = s.charAt(i) == '|' ? i : candle_right[i + 1];
        }

        int[] result = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            // time complexity: O(q) where q is length of queries
            int start = candle_right[queries[i][0]];
            int end = candle_left[queries[i][1]];
            result[i] = start >= end ? 0 : prefixSum[end] - prefixSum[start];
        }
        return result;
    }
}
