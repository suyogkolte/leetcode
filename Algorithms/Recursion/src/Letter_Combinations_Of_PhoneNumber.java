// Source: https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

import java.util.ArrayList;
import java.util.List;

public class Letter_Combinations_Of_PhoneNumber {
    private static String[] arrMapDigits = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private static ArrayList<String> listAns = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        listAns.clear();

        if(digits.length() == 0)
            return listAns;

        findLetterCombinations(digits, 0, "");
        return listAns;
    }

    private static void findLetterCombinations(String digits, int idx, String output){
        //Base case
        if(idx >= digits.length()){
            listAns.add(output);
            return;
        }

        //Self work
        int nCurrDigit = digits.charAt(idx) - '0';
        String strCurrDigitMapping = arrMapDigits[nCurrDigit];

        //Recursive task
        for(int i = 0; i < strCurrDigitMapping.length(); i++){
            findLetterCombinations(digits, idx + 1, output + strCurrDigitMapping.charAt(i));
        }
    }
}
