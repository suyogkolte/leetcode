//Source: https://leetcode.com/problems/lexicographical-numbers/
package Recursion_Pkg;
import java.util.ArrayList;
import java.util.List;

public class Lexicographical_Numbers {
    private static ArrayList<Integer> listAns = new ArrayList<>();

    public static void main(String[] args) {
        //Comment main() to run code in LeetCode
        int n = 13;
        lexicalOrder(n);

        for(int num : listAns){
            System.out.println(num);
        }
    }

    public static List<Integer> lexicalOrder(int n) {
        listAns.clear();
        getLexicalOrder(0, n);
        return listAns;
    }

    private static void getLexicalOrder(int i, int n){
        if(i <= n){
            //Self work
            if(i != 0)
                listAns.add(i);
        }
        else //Base case
            return;

        //Recursive task
        for(int k = 0; k <= 9; k++){
            if(i == 0 && k == 0)
                continue;

            getLexicalOrder((10 * i) + k, n);
        }
    }
}