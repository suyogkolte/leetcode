//Source: https://leetcode.com/problems/minimum-adjacent-swaps-to-make-a-valid-array/description/

public class Minimum_Adjacent_Swaps_to_Make_a_Valid_Array {
    public static void main(String[] args) {
        //int[] nums = {3,4,5,5,3,1};
        int[] nums = {10,10,10};

        int minIdx = 0;
        int maxIdx = nums.length - 1;

        for (int i = 1; i < nums.length; i++){
            if(nums[i] < nums[minIdx])
                minIdx = i;
        }

        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] > nums[maxIdx])
                maxIdx = i;
        }

        int minSwaps = minIdx + (nums.length - 1 - maxIdx);
        if(minIdx > maxIdx)
            minSwaps = minSwaps - 1;

        System.out.println("Minimum number of swaps needed to make a valid array is: " + minSwaps);
    }
}
