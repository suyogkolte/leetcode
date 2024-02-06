//https://leetcode.com/problems/climbing-stairs/description/

// This is a modified version of Fibonacci sequence
// for n = 2: 2 ways => 1+1, 2
// for n = 3: 3 ways => 1+1+1, 1+2, 2+1
// for n = 4: 5 ways => 1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2
// for n = 5: 8 ways => 1+1+1+1+1, 1+1+1+2, 1+1+2+1, 1+2+1+1, 2+1+1+1, 2+2+1, 2+1+2, 1+2+2

/* Recursion tree
                    f(5)
                  /      \
              f(4)        f(3)
             /    \       /   \
        f(3)      f(2)   f(2)  f(1)
       /    \
     f(2)   f(1)
*/

public class Climbing_Stairs {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return climbStairsHelper(n, memo);
    }

    public static int climbStairsHelper(int n, int[] memo) {
        //Memoization: we can store the result at each step in
        //memo array and directly returning the result
        // from the memo array whenever that function is called again.
        //In this way we are pruning recursion tree with the help of memo array and reducing the size of recursion tree upto n.
        if(memo[n] > 0)
            return memo[n];

        //Base case
        if(n == 1){
            memo[n] = 1;
            return memo[n];
        }
        if(n == 2){
            memo[n] = 2;
            return memo[n];
        }

        // Recursive task: climbStairs(n - 1) & climbStairs(n - 2)
        //Self work: climbStairs(n - 1) + climbStairs(n - 2)
        memo[n] = climbStairsHelper(n - 1, memo) + climbStairsHelper(n - 2, memo);
        return memo[n];
    }
}