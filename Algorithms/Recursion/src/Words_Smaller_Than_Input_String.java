/*
Given an input string str, write a recursive function which prints all the words possible by rearranging
the characters of this string which are in dictionary order smaller than the given string
*/

public class Words_Smaller_Than_Input_String {
    public static void main(String[] args) {
        String str = "cba";
        String origStr = new String(str);
        if(str.length() == 0)
            System.out.println("");
        else
            printSmallerWords(origStr, str, "");
    }

    public static void printSmallerWords(String origInput, String input, String output) {
        //Base case
        if(input.length() == 0) {
            if(!output.isEmpty() && output.charAt(0) < origInput.charAt(0))
                System.out.println(output);

            return;
        }

        if(!output.isEmpty() && output.charAt(0) < origInput.charAt(0))
            System.out.println(output);

        for(int i = 0; i < input.length(); i++) {
            String restOfInput = input.substring(0, i) + input.substring(i+1);
            printSmallerWords(origInput, restOfInput, output + input.charAt(i));
        }
    }
}
