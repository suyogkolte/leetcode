// Source: https://leetcode.com/problems/sqrtx/description/

public class Sqrt_Of_x {
    public static void main(String[] args) {
        int x = 2147395599;
        System.out.println("Sqrt of " + x + " is " + findSqrt(x));
    }

    private static int findSqrt(int x) {
        if (x < 2)
            return x;

        long num;
        int lo = 2;
        int hi = x / 2;
        int mid;

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            num = (long)mid * mid;

            if (num > x)
                hi = mid - 1;
            else if (num < x)
                lo = mid + 1;
            else
                return mid;
        }
        return hi;
    }
}
