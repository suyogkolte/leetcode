/* Given a number x, calculate the number of binary strings of length x which has no consecutive  one
 e.g.
 for n = 1, ans = 2 => 0, 1
 for n = 2, ans = 3 => 00, 01, 10
 for n = 3, ans = 5 => 000, 001, 010, 100, 101
 for n = 4, ans = 8 => 0000, 0001, 0010, 0100, 1000, 0101, 1001, 1010

 Note: This is a variation of Fibonacci sequence
 */
package Recursion_Pkg;
public class Binary_Strings_With_No_Consecutive_1s {
    public static void main(String[] args) {
        int n = 4;
        int[] memo = new int[n + 1];
        System.out.println("Number of binary strings with no consecutive ones is " + calcNumBinaryStr(n, memo));
    }

    public static int calcNumBinaryStr(int n, int[] memo){
        if(memo[n] > 0)
            return memo[n];

        //Base case
        if(n == 1)
            return 2;
        if(n == 2)
            return 3;

        memo[n] = calcNumBinaryStr(n-1, memo) + calcNumBinaryStr(n-2, memo);
        return memo[n];
    }
}
