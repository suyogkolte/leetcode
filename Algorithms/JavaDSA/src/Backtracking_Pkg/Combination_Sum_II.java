package Backtracking_Pkg;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum_II {
    private static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        int[] candidates = {2,5,2,1,2};
        int target = 5;

        combinationSum2(candidates, target);

        for(List<Integer> list : ans) {
            System.out.print("[");
            for(Integer num : list) {
                System.out.print(num + ", ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans.clear();

        backtrack(candidates, target, 0, new ArrayList<Integer>());
        return ans;
    }

    public static void backtrack(int[] candidates, int remain, int currIdx, ArrayList<Integer> currList) {
        //positive base case
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
            backtrack(candidates, remain - candidates[i], currIdx + 1, currList);

            //undo
            currList.remove(currList.size() - 1);
        }
    }
}
