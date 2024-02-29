//Source: https://leetcode.com/problems/first-unique-character-in-a-string/description/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class First_Unique_Char {
    public static void main(String[] args) {
        String s = "aabb";
        int res = firstUniqChar(s);

        if(res >= 0)
            System.out.println("First unique char in string is " + s.charAt(res));
        else
            System.out.println("There is no unique char in string");
    }

    public static int firstUniqChar(String s) {
        Set<Character> setUniqChars = new HashSet<>();
        Map<Character, Integer> mapCharPos = new HashMap<>();

        for(int idx = 0; idx < s.length(); idx++) {
            char currChar = s.charAt(idx);
            if(!setUniqChars.contains(currChar)) {
                setUniqChars.add(currChar);
                mapCharPos.put(currChar, idx);
            }
            else {
                if(mapCharPos.containsKey(currChar))
                    mapCharPos.remove(currChar);
            }
        }

        if(mapCharPos.isEmpty())
            return -1;

        int ans = Integer.MAX_VALUE;
        for(Character ch : mapCharPos.keySet()) {
            if(mapCharPos.get(ch) < ans)
                ans = mapCharPos.get(ch);
        }

        return ans;
    }
}
