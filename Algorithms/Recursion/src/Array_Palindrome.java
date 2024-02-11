/*
For a given array of length N, write a recursive function which tests if the array is a palindrome
and returns a boolean value
*/

public class Array_Palindrome {
    public static void main(String[] args) {
        int[] arr = new int[]{18, 2, 3, 3, 2, 18};
        boolean bAns = checkPalindrome(arr, 0, arr.length - 1);

        if(bAns)
            System.out.println("The given array is a palindrome");
        else
            System.out.println("The given array is not a palindrome");
    }

    private static boolean checkPalindrome(int[] arr, int startIdx, int endIdx){
        //Base case
        if(startIdx >= endIdx)
            return true;

        //Self work
        if(arr[startIdx] != arr[endIdx])
            return false;

        //Recursive task
        return checkPalindrome(arr, startIdx + 1, endIdx - 1);
    }
}
