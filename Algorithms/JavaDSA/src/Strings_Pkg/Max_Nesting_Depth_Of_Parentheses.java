//Source: https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/
package Strings_Pkg;

public class Max_Nesting_Depth_Of_Parentheses {
    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        int res = maxDepth(s);

        System.out.println("The max depth is " + res);
    }

    private static int maxDepth(String s) {
        int ans = 0;
        int tmp = 0;

        for(char ch : s.toCharArray()) {
            if(ch == '(')
                tmp++;
            else if(ch == ')')
                tmp--;

            ans = tmp > ans ? tmp : ans;
        }

        return ans;
    }
}
