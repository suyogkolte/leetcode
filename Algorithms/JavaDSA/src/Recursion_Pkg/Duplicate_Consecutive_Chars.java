/*
Take as input string str. Write a recursive function which returns a new string in which all duplicate
consecutive characters are separated by a '*'
e.g. for I/P: "hello"
         O/P: "hel*lo"

Print the value returned
*/
package Recursion_Pkg;
public class Duplicate_Consecutive_Chars {
    public static void main(String[] args) {
        String str = "zzzzzAAAAhellllo";
        StringBuilder strRes = new StringBuilder();
        if(str.length() <= 1)
            System.out.println("For I/P: " + str + " O/P is " + str);
        else {
            checkDuplicateChars(str, strRes, 0);
            System.out.println("For I/P: " + str + " O/P is " + strRes);
        }
    }

    private static void checkDuplicateChars(String str, StringBuilder strRes, int idx){
        //Base case
        if(idx == str.length() - 1){
            strRes.append(str.charAt(idx));
            return;
        }

        //Self work
        strRes.append(str.charAt(idx));
        if(str.charAt(idx) == str.charAt(idx + 1))
            strRes.append('*');

        //Recursive task
        checkDuplicateChars(str, strRes, idx + 1);
    }
}
