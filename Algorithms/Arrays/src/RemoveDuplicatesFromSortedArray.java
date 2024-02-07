// Source : https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;

        int insertIdx = 1;
        for(int j = 1; j < len; j++)
        {
            if(nums[j] != nums[j-1])
            {
                nums[insertIdx] = nums[j];
                insertIdx++;
            }
        }
        return insertIdx;
    }
}