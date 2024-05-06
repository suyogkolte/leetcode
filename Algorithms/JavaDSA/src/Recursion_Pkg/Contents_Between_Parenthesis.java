/*
Take as input string str. The string contains a single pair of parenthesis ""(...)
Write a recursive function which returns the content between the parenthesis
e.g. for I/P: "xyz(abc)def"
         O/P: "abc"

Print the value returned
*/
package Recursion_Pkg;
public class Contents_Between_Parenthesis {
    public static void main(String[] args) {
        String str = "xyz(abc)def";
        StringBuilder strRes = new StringBuilder();
        boolean bStartPar = false;

        parenthesisSubstring(str, strRes, 0, bStartPar);
        System.out.println("For input: " + str + " , output is " + strRes.toString());
    }

    private static void parenthesisSubstring(String str, StringBuilder strRes, int idx, boolean bStartingParenthesis){
        //Base case
        if(str.charAt(idx) == ')' || idx == str.length())
            return;

        //Self work
        if(bStartingParenthesis)
            strRes.append(str.charAt(idx));
        if(str.charAt(idx) == '(')
            bStartingParenthesis = true;


        //Recursive task
        parenthesisSubstring(str, strRes, idx + 1, bStartingParenthesis);
    }
}
