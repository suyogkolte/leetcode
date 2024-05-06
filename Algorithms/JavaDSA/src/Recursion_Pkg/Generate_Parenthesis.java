//Source: https://leetcode.com/problems/generate-parentheses/description/
package Recursion_Pkg;
import java.util.ArrayList;
import java.util.List;

public class Generate_Parenthesis {
    private static ArrayList<String> arrList = new ArrayList<>();

    public static void main(String[] args) {
        int n = 3;
        generateParenthesis(n);

        for(String s : arrList){
            System.out.println(s);
        }
    }

    public static List<String> generateParenthesis(int n) {
        arrList.clear();
        generateParenthesisHelper(n, 0, 0, "");
        return arrList;
    }

    // n: n pairs of parenthesis
    // o: number of opening parenthesis used
    // c: number of closing parenthesis used
    private static void generateParenthesisHelper(int n, int o, int c, String output){
        //Base case
        if(c == n){
            arrList.add(output);
            return;
        }

        //add opening parenthesis
        if(o < n)
            generateParenthesisHelper(n, o + 1, c, output + "(");

        //add closing parenthesis
        if(c < o)
            generateParenthesisHelper(n, o, c + 1, output + ")");
    }
}
