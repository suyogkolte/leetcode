/*
Take as input string str, a number in the form of a string. Write a recursive function to convert the number
in string form to number in integer form
e.g. for I/P: "1234"
         O/P: 1234
*/
package Recursion_Pkg;
public class String_To_Number {
    public static void main(String[] args) {
        String str = "1234";

        if(str.matches("[0-9]+")){
            long res = 0;
            res = convertString(str, str.length() - 1, res);
            System.out.println("For I/P: \"" + str + "\", O/P is " + res);
        }
        else
            System.out.println("Input string: " + str + " cannot be converted as it contains non-numeric characters");
    }

    private static long convertString(String str, int idx, long res){
        //Base case
        if(idx < 0)
            return res;

        //Self work
        long currDigit = str.charAt(idx) - '0';
        res = (long) (res + (Math.pow(10, (str.length()-1-idx)) * currDigit));

        //Recursive task
        return convertString(str, idx - 1, res);
    }
}
