// Source : https://leetcode.com/problems/custom-sort-string/description/
package Strings_Pkg;

import java.util.HashMap;

public class CustomSortString{
    public String customSortString(String order, String s) {
        // Hashmap<character, freq> in String s
        HashMap<Character, Integer> map = new HashMap<>();

        //Parse String s and put the char and freq in map
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Parse String order and append the char to StringBuilder freq
        // number of times which we got above
        StringBuilder sb = new StringBuilder();
        for(char ch : order.toCharArray()){
            if(map.containsKey(ch)){
                int freq = map.get(ch);
                while(freq > 0){
                    sb.append(ch);
                    freq--;
                }
                map.put(ch, 0);
            }
        }

        // Now, we are done adding the chars to StringBuilder which
        // were common to order and s.
        // Now, we add the remaining chars from s to StringBuilder
        for(Character ch : map.keySet()){
            if(map.get(ch) > 0){
                int freq = map.get(ch);
                while(freq > 0){
                    sb.append(ch);
                    freq--;
                }
                map.put(ch, 0);
            }
        }
        return sb.toString();
    }
}