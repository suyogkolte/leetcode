// Source : https://leetcode.com/problems/remove-element/
package Arrays_Pkg;

class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;

        while(i <= j)
        {
            if(nums[i] != val)
                i++;
            else
            {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                j--;
            }
        }
        return i;
    }
}