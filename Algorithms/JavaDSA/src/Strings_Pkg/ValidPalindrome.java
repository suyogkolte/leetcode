// Source : https://leetcode.com/problems/valid-palindrome/description/
package Strings_Pkg;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.trim(); // remove leading and trailing whitespace
        s = s.replaceAll("[^A-Za-z0-9]", ""); //remove all non-alphanumeric characters
        s = s.toLowerCase();

        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
