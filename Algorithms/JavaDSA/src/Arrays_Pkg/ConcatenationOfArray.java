// Source : https://leetcode.com/problems/concatenation-of-array/
package Arrays_Pkg;
class ConcatenationOfArray {
    public int[] getConcatenation(int[] nums) {
        int len = nums.length;
        int[] ans = new int[2*len];

        for(int i = 0; i < len; i++)
        {
            ans[i] = nums[i];
            ans[i+len] = nums[i];
        }
        return ans;
    }
}