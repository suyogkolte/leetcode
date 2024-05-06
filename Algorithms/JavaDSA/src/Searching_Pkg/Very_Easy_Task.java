/*
This morning the jury decided to add one more, very easy problem to the problem set of the olympiad.
The executive secretary of the organizing committee has printed it's statement in one copy, and now
they need to make n more copies before the start of the olympiad. They have two copiers at his
disposal, one of which copies a sheet in x seconds and the other in y seconds. (It is allowed to use
one copier or both at the same time. You can copy not only from the original but also from the copy.)
Help them find out what is the minimum time they need to make n copies of the statement.

Input:
This program receives three integers n, x, and y
(1 <= n <= 2*10^8, 1 <= x, y <= 10)

Output:
Print one integer, the minimum time in seconds required to get n copies

e.g.
Input: 4 1 1
Output: 3

Input: 5 1 2
Output: 4

*/
package Searching_Pkg;
import java.util.Scanner;

public class Very_Easy_Task {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int x = scan.nextInt();
        int y = scan.nextInt();

        System.out.println("The minimum time required to print " + n + " copies is " + getMinTime(n, x, y));
    }

    private static int getMinTime(int n, int x, int y) {
        if(n == 1){
            // if only one copy is needed then print from the faster copier
            return Math.min(x, y);
        }

        // The search space is between 0 second and max(x, y) * n seconds
        // max(x, y) * n means the amount of time needed to print n copies from the slower copier
        int left = 0;
        int right = Math.max(x, y) * n;

        int ans = 0;

        while(left <= right){
            //time
            int mid = left + ((right - left) / 2);

            // isGood() checks if the  mid time range is enough or not to make n-1 copies
            if(isGood(n, x, y, mid)){
                ans = mid;
                right = mid - 1;
            }
            else
                left = mid + 1;
        }
        return ans + Math.min(x, y);
    }

    private static boolean isGood(int n, int x, int y, int mid) {
        /*
        Objective:
        If in mid amount of time, I am able to make n - 1 copies then my mid value is good,
        hence I should return true.

        In other words, check how many copies can be made in mid amount of time.
        If number of copies >= n - 1, return true otherwise return false

        c1 copier can make mid/x copies in mid time
        c2 copier can make mid/y copies in mid time
        */

        return (mid/x) + (mid/y) >= n - 1;
    }
}
