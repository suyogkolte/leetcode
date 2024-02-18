/*
Source: https://leetcode.com/problems/subsets/

We loop over the length of combination to generate all combinations
for a given length with the help of backtracking technique.

e.g. for nums = {1, 2, 3}
Iterate over all possible lengths from 0 to N => nums.length
all subsets of len = 0: []
all subsets of len = 1: [1], [2], [3]
all subsets of len = 2: [1, 2], [1, 3], [2, 3]
all subsets of len = 3: [1, 2, 3]

*/

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    private static int  len;
    private static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        subsets(nums);

        for(List<Integer> list : ans) {
            if(list.isEmpty())
                System.out.print("[]");
            else{
                for(Integer n : list) {
                    System.out.print("[" + n + "]");
                }
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        for(len = 0; len <= nums.length; len++) {
            backtrack(nums, 0, new ArrayList<>());
        }
        return ans;
    }

    public static void backtrack(int[] nums, int firstCharIdx, ArrayList<Integer> currList) {
        // Base case
        if(len == currList.size()) {
            ans.add(new ArrayList<>(currList));
            return;
        }

        for(int currIdx = firstCharIdx; currIdx < nums.length; currIdx++) {
            //do: add element at currIdx
            currList.add(nums[currIdx]);

            //recurse
            backtrack(nums, currIdx + 1, currList);

            //undo: remove last element in currList
            currList.remove(currList.size() - 1);
        }
    }
}
