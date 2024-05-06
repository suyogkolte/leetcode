/*
Given an input string str, write a recursive function which prints all the words possible by rearranging
the characters of this string which are in dictionary order larger than the given string
*/
package Recursion_Pkg;
public class Words_Larger_Than_Input_String {
    public static void main(String[] args) {
        String str = "abc";
        String origStr = new String(str);
        if(str.length() == 0)
            System.out.println("");
        else
            printLargerWords(origStr, str, "");
    }

    public static void printLargerWords(String origInput, String input, String output) {
        //Base case
        if(input.length() == 0) {
            if(output.charAt(0) > origInput.charAt(0))
                System.out.println(output);
            return;
        }

        if(!output.isEmpty() && output.charAt(0) > origInput.charAt(0)){
            System.out.println(output);
        }

        for(int i = 0; i < input.length(); i++) {
            String restOfInput = input.substring(0, i) + input.substring(i+1);
            printLargerWords(origInput, restOfInput, output + input.charAt(i));
        }
    }
}
