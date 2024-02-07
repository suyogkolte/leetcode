// Source : https://leetcode.com/problems/running-sum-of-1d-array/description/

class RunningSumOf1dArray {
    public int[] runningSum(int[] nums) {
        int sum = 0;
        int len = nums.length;

        for(int i = 0; i < len; i++)
        {
            sum = sum + nums[i];
            nums[i] = sum;
        }
        return nums;
    }
}
