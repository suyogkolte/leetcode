// Source: https://leetcode.com/problems/palindrome-partitioning/description/

/*
Algorithm

In the backtracking algorithm, we recursively traverse over the string in depth-first search fashion.
For each recursive call, the beginning index of the string is given as start.

1] Iteratively generate all possible substrings beginning at index start. The index end increments from start
until the end of the string.

2] For each of the substrings generated, check if it is a palindrome.

3] If the substring is a palindrome, the substring is a potential candidate. Add the substring to the
currentList and perform a depth-first search on the remaining substring. If the current substring
ends at index end, end+1 becomes the start index for the next recursive call.

4] Backtrack if start index is greater than or equal to the string length and add the currentList to the result.

*/

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning {
    private static List<List<String>> ans = new ArrayList<>();

    public static void main(String[] args) {
        String s = "aab";

        partition(s);
        for(List<String> list : ans) {
            System.out.print("[");
            for (String str: list) {
                System.out.print(str + ", ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public static List<List<String>> partition(String s) {
        ans.clear();

        backtrack(s, 0, new ArrayList<String>());
        return ans;
    }

    public static void backtrack(String s, int currIdx, ArrayList<String> currList) {
        //base case
        if(currIdx == s.length()) {
            ans.add(new ArrayList<String>(currList));
            return;
        }

        for(int i = currIdx; i < s.length(); i++) {
            if(isPalindrome(s, currIdx, i)) {
                //do
                currList.add(s.substring(currIdx, i + 1));

                //recurse
                backtrack(s, i + 1, currList);

                //undo
                currList.remove(currList.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start) != s.charAt(end))
                return false;

            start++;
            end--;
        }
        return true;
    }
}
