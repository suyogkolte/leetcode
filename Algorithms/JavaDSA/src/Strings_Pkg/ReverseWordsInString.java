// Source : https://leetcode.com/problems/reverse-words-in-a-string/description/
package Strings_Pkg;

public class ReverseWordsInString {
    public String reverseWords(String s) {
        int len = s.length();
        s = s.trim();
        String[] strArray = s.split("\s+");

        StringBuilder ans = new StringBuilder();
        for(int i = strArray.length - 1; i >= 0; i--)
        {
            ans.append(strArray[i]);
            if(i > 0)
                ans.append(" ");
        }
        return ans.toString();
    }
}
