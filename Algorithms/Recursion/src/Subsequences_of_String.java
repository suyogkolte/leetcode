/*
Given a string str, print all possible subsequences of the string (order of output does not matter)
e.g.
str = "abc"
ans = "abc", "ab", "ac", "bc", "a", "b", "c", ""
*/

public class Subsequences_of_String {
    public static void main(String[] args) {
        String str = "abc";
        printSubsequence(str, 0, "");
    }

    private static void printSubsequence(String str, int idx, String output){
        //base case
        if(idx == str.length()){
            System.out.println("[" + output + "]");
            return;
        }

        printSubsequence(str, idx + 1, output + str.charAt(idx));
        printSubsequence(str, idx + 1, output);
    }
}
