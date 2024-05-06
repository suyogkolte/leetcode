// Source : https://leetcode.com/problems/search-in-rotated-sorted-array/description/
package Searching_Pkg;
public class Search_in_Rotated_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println("Target: " + target + " can be found at index " + searchArray(nums, target) + " in nums");
    }

    private static int searchArray(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while(lo <= hi){
            int mid = lo + ((hi - lo) / 2);

            if(nums[mid] == target)
                return mid;

            // Check if mid lies in upper curve or lower curve
            if(nums[mid] >= nums[lo]){
                // upper curve

                // left part always sorted, so compare there
                if(target >= nums[lo] && target < nums[mid])
                    // target is in left part
                    hi = mid - 1;   // discard right
                else
                    // target is in right part
                    lo = mid + 1;   // discard left
            }
            else{
                //  lower curve

                // right part always sorted, so compare there
                if(target > nums[mid] && target <= nums[hi])
                    // target is in right part
                    lo = mid + 1;   // discard left
                else
                    // target is in left part
                    hi = mid - 1;   // discard right
            }
        }
        return -1;
    }
}
