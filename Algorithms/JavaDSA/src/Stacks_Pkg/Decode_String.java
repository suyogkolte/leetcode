// Source: https://leetcode.com/problems/decode-string/description/
package Stacks_Pkg;
import java.util.Stack;

public class Decode_String {
    public static void main(String[] args) {
        String s = "3[ab2[c]]";
        System.out.println("Decoded String is: " + decodeString(s));
    }
    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        for(int idx = 0; idx < s.length(); idx++) {
            if(s.charAt(idx) != ']') {
                // push all chars that are not ']' on top of stack
                stack.push(s.charAt(idx));
            }
            else {
                String subStr = "";
                while(stack.peek() != '[') {
                    // once we reach ']', start popping chars from stack until we reach '['
                    subStr = stack.pop() + subStr;
                }

                // Pop the opening bracket '[' from stack
                stack.pop();

                String k = "";
                while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    // fetch the digits from stack
                    k = stack.pop() + k;
                }
                int num = Integer.valueOf(k);
                for(int count = 0; count < num; count++) {
                    for(char ch : subStr.toCharArray()) {
                        stack.push(ch);
                    }
                }
            }
        }

        String ans = "";
        while(!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }

        return ans;
    }
}