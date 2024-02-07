// Source : https://leetcode.com/problems/contains-duplicate/description/

import java.util.HashSet;
class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++)
        {
            if(!set.add(nums[i]))
                return true;
        }
        return false;
    }
}