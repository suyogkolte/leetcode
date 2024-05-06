// Source: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
package Searching_Pkg;
public class Find_Minimum_in_Rotated_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};

        System.out.println("The minimum element in rotated sorted array is " + getMinElement(nums));
    }

    private static int getMinElement(int[] nums){
        int n = nums.length;
        if(n == 1)
            return nums[0];

        int lo = 0;
        int hi = n - 1;

        while(lo <= hi){
            int mid = lo + (hi - lo)/2;

            //If the search space is already sorted then nums[lo] is the min element
            if(nums[lo] < nums[hi])
                return nums[lo];

            if(mid-1 >= 0 && nums[mid] < nums[mid-1])
                return nums[mid];

            if(mid+1 < n && nums[mid] > nums[mid+1])
                return nums[mid+1];

            if(nums[mid] > nums[lo]){
                // mid is on the upper curve, so ans will be in the part of array to mid's right
                lo = mid + 1;
            }
            else {
                // mid is on the lower curve, so ans will be in the part of array to mid's left
                hi = mid - 1;
            }
        }

        return -1;
    }
}
