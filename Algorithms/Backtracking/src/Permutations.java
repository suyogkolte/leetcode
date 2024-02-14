// Given an input string ques, print all possible permutations of it

public class Permutations {
    public static void main(String[] args) {
        String str = "abc";
        printPermutationsBacktracking(str, 0, str.length() - 1);
    }

    public static void printPermutationsBacktracking(String str, int l, int r) {
        if(l == r) {
            //Here, when we reach the last char, we don't swap because it is redundant.
            // If you want to swap then the condition will be if(l > r)
            System.out.println(str);
        }
        else {
            for(int i = l; i <= r; i++) {
                //do
                str = swap(str, l, i);

                //recurse
                printPermutationsBacktracking(str, l + 1, r);

                //undo
                str = swap(str, l, i);
            }

        }

    }

    public static String swap(String a, int i, int j) {
        char[] ch = a.toCharArray();

        char tmp;
        tmp = ch[i];
        ch[i] = ch[j];
        ch[j] = tmp;

        return String.valueOf(ch);
    }
}
