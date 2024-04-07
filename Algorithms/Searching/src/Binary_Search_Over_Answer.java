/*
Given a value x, tell if x is a square of an integer or not
Note: In other search problems, the search space like an array is given.
Here, we have to determine the search space

e.g if x = 16 then 16 = (4)^2;
             sqrt(16) = 4;

That means the sqrt(x) will lie in between 0 and x
*/

public class Binary_Search_Over_Answer {
    public static void main(String[] args) {
        int x = 2147395600;
        if(checkIfSquare(x, 0, x))
            System.out.println("The given number x is a square of an int");
        else
            System.out.println("The given number x is not a square of an int");
    }

    private static boolean checkIfSquare(int x, int l, int r) {
        while(l <= r){
            int mid = l + (r - l)/2;
            long midSquare = (long)mid * mid;

            if(midSquare == x)
                return true;
            else if(midSquare > x)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return false;
    }
}
