// Source : https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
package Arrays_Pkg;

class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;

        while(low < high)
        {
            int sum = numbers[low] + numbers[high];

            if(sum == target)
                return new int[]{low+1, high+1};
            else if(sum < target)
                low++;
            else
                high--;
        }
        return new int[]{-1, -1};
    }
}