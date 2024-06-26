//https://leetcode.com/problems/n-th-tribonacci-number/description/
package Recursion_Pkg;
public class Nth_Tribonacci_Number {
    public int tribonacci(int n) {
        if(n == 0)
            return 0;
        if(n <= 2)
            return 1;

        int result = 0;
        int t0 = 0, t1 = 1, t2 = 1;
        for(int i = 3; i <= n; i++){
            result = t0 + t1 + t2;

            t0 = t1;
            t1 = t2;
            t2 = result;
        }

        return result;
    }
}
