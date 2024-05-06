package Strings_Pkg;

import java.util.ArrayList;

public class GetSubstrings {
    public static void main(String[] args) {
        String str = "code";

        ArrayList<String> res = getSubstrings(str);
        for(String s : res){
            System.out.println(s);
        }
    }

    public static ArrayList<String> getSubstrings(String str){
        ArrayList<String> resList = new ArrayList<>();
        int len = str.length();

        for(int startIdx = 0; startIdx < len; startIdx++){
            for(int endIdx = startIdx + 1; endIdx <= len; endIdx++){
                resList.add(str.substring(startIdx, endIdx));
            }
        }
        return resList;
    }
}
