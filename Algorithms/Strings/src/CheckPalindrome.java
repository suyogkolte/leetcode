public class CheckPalindrome {
    public static void main(String[] args) {
        String str = "no lemon, no melon";
        String res = checkIfPalindrome(str) ? "is" : "is not";
        System.out.println("The given string " + res + " a palindrome");
    }

    public static boolean checkIfPalindrome(String str) {
        str = str.toLowerCase().replaceAll("[^A-Za-z0-9]", "");
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
