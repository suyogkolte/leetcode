/*
Take as input string str. Write a recursive function which tests if the string is a palindrome or not and
returns a boolean value.
Print the value returned.
*/

public class Check_Palindrome {
    public static void main(String[] args) {
        String str = "No, it is open on one position.";
        str = str.replaceAll("\\s+", "");
        str = str.replaceAll("[^a-zA-Z0-9]+", "");
        str = str.toLowerCase();

        if(checkPalindrome(str, 0, str.length()-1))
            System.out.println("The given string is a palindrome");
        else
            System.out.println("The given string is not a palindrome");

    }

    private static boolean checkPalindrome(String str, int startIdx, int endIdx){
        //Base case
        if(startIdx >= endIdx)
            return true;

        //Self work
        if(str.charAt(startIdx) != str.charAt(endIdx))
            return false;

        //Recursive task
        return checkPalindrome(str, startIdx+1, endIdx-1);
    }
}
