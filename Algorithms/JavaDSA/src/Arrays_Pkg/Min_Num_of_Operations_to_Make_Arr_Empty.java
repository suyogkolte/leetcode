// Source: https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/description/
package Arrays_Pkg;
import java.util.HashMap;

public class Min_Num_of_Operations_to_Make_Arr_Empty {
    public static void main(String[] args) {
        int[] nums = {2,3,3,2,2,4,2,3,4};
        System.out.println("Min number of steps is: " + minOperations(nums));
    }

    public static int minOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int n : nums)
            map.put(n, map.getOrDefault(n, 0) + 1);

        for (int val : map.values()) {
            if (val == 1) return -1;

            count += val / 3;
            if (val % 3 != 0)
                count++;
        }
        return count;
    }
}
