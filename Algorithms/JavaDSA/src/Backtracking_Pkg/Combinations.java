//Source: https://leetcode.com/problems/combinations/description/
package Backtracking_Pkg;
import java.util.ArrayList;
import java.util.List;

public class Combinations {
    private static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        // Leetcode remembers any global variable value when running
        //the code between different test cases
        //Hence, have to clear it
        ans.clear();

        combine(4, 2);
        for(List<Integer> list : ans){
            System.out.print("[");
            for(Integer num : list){
                System.out.print(num + ", ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        ArrayList<Integer> currList = new ArrayList<>();
        backtrack(n, k, 1, currList);
        return ans;
    }

    public static void backtrack(int n, int k, int currNum, List<Integer> currList) {
        // base case
        if(currList.size() == k){
            ans.add(new ArrayList<>(currList));
            return;
        }

        int numOfElemNeededInCurrList = k - currList.size();
        int numOfRemainingElemInInput = n - currNum + 1;
        int numOfElemAvailableToCombine = numOfRemainingElemInInput - numOfElemNeededInCurrList + 1;

        for(int num = currNum; num < currNum + numOfElemAvailableToCombine; num++) {
            //do
            currList.add(num);

            //recurse
            backtrack(n, k, num + 1, currList);

            //undo
            currList.remove(currList.size() - 1);
        }
    }
}
