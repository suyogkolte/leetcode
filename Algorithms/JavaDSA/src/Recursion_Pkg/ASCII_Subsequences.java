/*
Take as input str, s string. We are concerned with all possible ascii-subsequences of str
e.g. "ab" has following ascii-subsequences "", "b", "98", "a", "ab", "a98", "97", "97b", "9798".
Write a recursive function which prints all possible ascii-subsequences for a given string (void is the
return type for the function)
*/
package Recursion_Pkg;
public class ASCII_Subsequences {
    public static void main(String[] args) {
        String str = "ab";
        printASCIISubseq(str, 0, "");
    }

    private static void printASCIISubseq(String str, int idx, String output){
        //Base case
        if(idx == str.length()){
            System.out.println(output);
            return;
        }

        //Recursive task
        printASCIISubseq(str, idx + 1, output + ""); //Self work: output + ""
        printASCIISubseq(str, idx + 1, output + str.charAt(idx)); //Self work: output + str.charAt(idx)

        int currCharASCIIValue = str.charAt(idx);
        printASCIISubseq(str, idx + 1, output + currCharASCIIValue); //Self work: output + currCharASCIIValue)
    }
}
