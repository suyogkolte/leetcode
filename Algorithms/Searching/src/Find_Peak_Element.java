// Source : https://leetcode.com/problems/find-peak-element/description/

public class Find_Peak_Element  {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,5,6,4};
        System.out.println("One of the peak elements in the array is " + findPeakElement(nums));
    }

    public static int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while(l < r){
            int mid = l + (r - l)/2;

            if(nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
