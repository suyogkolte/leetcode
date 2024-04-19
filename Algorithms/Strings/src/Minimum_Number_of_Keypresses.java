// Source: https://leetcode.com/problems/minimum-number-of-keypresses/

import java.util.Arrays;

public class Minimum_Number_of_Keypresses {
    public static void main(String[] args) {
        String s = "abcdefghijkl";
        System.out.println("Minimum number of keypresses needed to type s using your keypad is " + minimumKeypresses(s));
    }

    public static int minimumKeypresses(String s) {
        int[] count = new int[26];
        for(char ch : s.toCharArray()){
            count[ch - 'a']++;
        }

        Arrays.sort(count);
        int result = 0;
        for(int i = 25; i >= 0 && count[i] != 0; i--){
            int times = 1 + (25 -i)/9;
            result += count[i] * times;
        }
        return result;
    }
}
