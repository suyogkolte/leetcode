// Source : https://leetcode.com/problems/largest-substring-between-two-equal-characters/description/
class LargestSubstringBetweenTwoEqualChars {
    public int maxLengthBetweenEqualCharacters(String s) {
        int len = s.length();
        int[] indices = new int[26];
        int maxLen = -1;

        for(int i = 0; i < len; i++)
        {
            int idx = s.charAt(i) - 'a';

            if(indices[idx] > 0)
                maxLen = Math.max(maxLen, i - indices[idx]);
            else
                indices[idx] = i + 1;
        }
        return maxLen;
    }
}