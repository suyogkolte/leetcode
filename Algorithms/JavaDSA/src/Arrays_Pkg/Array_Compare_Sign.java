/*
Given an array nums and a non-zero variable pivot, compare each element in nums and return an array output where
1] if nums[i] and pivot have the same sign then output[i] = 1
2] if nums[i] and pivot have different sign then output[i] = -1
3] if nums[i] = 0 then output[i] = 0
*/
package Arrays_Pkg;

public class Array_Compare_Sign {
    public static void main(String[] args) {
        int[] nums = {2, 8, -9, 0, 3, 5, -4};
        int pivot = 3;

        int[] res = compareSign(nums, pivot);
        for (int n : res) {
            System.out.print(n + "\t");
        }
    }

    public static int[] compareSign(int[] nums, int pivot){
        int[] output = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0)
                output[i] = 0;
            else if (nums[i] > 0 && pivot > 0)
                output[i] = 1;
            else if (nums[i] > 0 && pivot < 0)
                output[i] = -1;
            else if (nums[i] < 0 && pivot > 0)
                output[i] = -1;
            else if (nums[i] < 0 && pivot < 0)
                output[i] = 1;
            }
        return output;
    }
}
