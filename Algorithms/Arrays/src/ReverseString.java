// Source : https://leetcode.com/problems/reverse-string/description/

/**********************************************************************************
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * You must do this by modifying the input array in-place with O(1) extra memory.
 **********************************************************************************/

class Solution {
    public void reverseString(char[] s) {
        int len = s.length;
        int p1 = 0;
        int p2 = len-1;

        while(p1 <= p2)
        {
            char tmp = s[p2];
            s[p2] = s[p1];
            s[p1] = tmp;
            p1++;
            p2--;
        }
    }
}