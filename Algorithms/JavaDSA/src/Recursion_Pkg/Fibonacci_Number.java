//https://leetcode.com/problems/fibonacci-number/description/
package Recursion_Pkg;
public class Fibonacci_Number {
    public int fib(int n) {
        //Base case
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;

        //recursive task
        int tmp1 = fib(n - 1);
        int tmp2 = fib(n - 2);

        //Self work
        return tmp1 + tmp2;
    }
}
