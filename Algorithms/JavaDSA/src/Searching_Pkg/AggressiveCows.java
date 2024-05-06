// Source: https://www.spoj.com/problems/AGGRCOW/
package Searching_Pkg;
import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int n = 5;  // number of stalls
        int c = 3;  // number of cows
        int[] arr = {1, 2, 8, 4, 9};    // positions of the stalls

        System.out.println("The largest minimum distance between two cows is " + distributeCows(arr, n, c));
    }

    private static int distributeCows(int[] arr, int n, int c) {
        Arrays.sort(arr);
        int lo = 0;
        int hi = arr[n-1];
        int ans = 0;
        
        while(lo <= hi){
            int mid = lo + (hi - lo)/2; // minimum distance between two cows

            
            if(isGood(arr, n, c, mid)){
                ans = mid;
                lo = mid + 1;
            }
            else
                hi = mid - 1;
        }
        return ans;
    }

    private static boolean isGood(int[] arr, int n, int c, int mid) {
        // Objective: Decide whether the cows can be placed at least mid distance apart

        int count = 1;  // position of the first cow;
        int last_pos = arr[0];  // last position of the last cow placed in stall

        for(int i = 1; i < arr.length; i++){
            if(arr[i] - last_pos >= mid){
                last_pos = arr[i];
                count++;
            }

            if(count == c)
                return true;
        }
        return false;
    }
}
