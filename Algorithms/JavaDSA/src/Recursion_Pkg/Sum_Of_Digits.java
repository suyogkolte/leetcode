/*
Take as input str, a number in form of a string. Write a recursive function to find the sum of digits in the
string. Print the value returned
e.g.
    I/P: str = "4123"
    O/P: 4 + 1 + 2 + 3 = 10
*/
package Recursion_Pkg;
public class Sum_Of_Digits {
    public static void main(String[] args) {
        String str = "4123";
        int res = 0;
        res = printSum(str, 0, res);
        System.out.println("Sum of digits for input: " + str + " is O/P: " + res);
    }

    private static int printSum(String str, int idx, int sum){
        //Base case
        if(idx == str.length())
            return sum;

        //Self work
        int currDigit = str.charAt(idx) - '0';
        sum = sum + currDigit;

        //Recursive task
        return printSum(str, idx + 1, sum);
    }
}
