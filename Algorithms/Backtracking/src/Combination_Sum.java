//Source: https://leetcode.com/problems/combination-sum/description/

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum {
    private static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        combinationSum(candidates, target);

        for(List<Integer> list : ans) {
            System.out.print("[");
            for(Integer num : list) {
                System.out.print(num + ", ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans.clear();
        ArrayList<Integer> currList = new ArrayList<>();
        int currIdx = 0;
        backtrack(candidates, target, currIdx, currList);
        return ans;

    }

    public static void backtrack(int[] candidates, int remain, int currIdx, ArrayList<Integer> currList) {
        // positive base case
        if(remain == 0) {
            ans.add(new ArrayList<Integer>(currList));
            return;
        }

        // negative base case
        if(remain < 0)
            return;

        for(int i = currIdx; i < candidates.length; i++) {
            //do
            currList.add(candidates[i]);

            //recurse
            backtrack(candidates, remain - candidates[i], i, currList);

            //undo
            currList.remove(currList.size() - 1);
        }
    }
}
