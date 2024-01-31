// Source : https://leetcode.com/problems/reverse-only-letters/description/
public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {
        // convert string to char array
        char[] charArr = s.toCharArray();
        int i = 0;
        int j = charArr.length - 1;

        while(i < j)
        {
            //check if char at i is a letter else increment i
            while(i < j && !Character.isLetter(charArr[i]))
                i++;

            //check if char at j is a letter else increment j
            while(i < j && !Character.isLetter(charArr[j]))
                j--;

            // exchange elements at i and j
            char tmp = charArr[i];
            charArr[i] = charArr[j];
            charArr[j] = tmp;
            i++;
            j--;
        }

        // return charArr converted to a string
        return new String(charArr);
    }
}