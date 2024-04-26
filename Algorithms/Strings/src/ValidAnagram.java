// Source: https://leetcode.com/problems/valid-anagram/description/

import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        if(isAnagram(s, t))
            System.out.println("The two input strings are anagrams");
        else
            System.out.println("The two input strings are not anagrams");
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        char[] charArrS = s.toCharArray();
        Arrays.sort(charArrS);
        char[] charArrT = t.toCharArray();
        Arrays.sort(charArrT);

        for(int i = 0; i < charArrS.length; i++){
            if(charArrS[i] != charArrT[i])
                return false;
        }

        return true;
    }
}