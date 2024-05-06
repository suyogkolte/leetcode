/*
Take as input str, a string. Write a recursive function which moves all 'x' from the string to its end.
e.g. I/P: abexexdexed
     O/P: abeedeedxxx

*/
package Recursion_Pkg;
public class Move_X_To_String_End {
    public static void main(String[] args) {
        String str = "abexexdexed";
        char ch = 'x';

        StringBuilder strRes = new StringBuilder();
        int count = 0;
        count = moveToEnd(str, strRes, ch, 0, count);

        while(count > 0){
            strRes.append(ch);
            count--;
        }

        System.out.println("I/P: " + str);
        System.out.println("O/P: " + strRes.toString());
    }

    private static int moveToEnd(String str, StringBuilder strRes, char ch, int idx, int count){
        //Base case
        if(idx == str.length())
            return count;

        //Self work
        if(str.charAt(idx) == ch)
            count = count + 1;
        else
            strRes.append(str.charAt(idx));


        //Recursive task
        return moveToEnd(str, strRes, ch, idx + 1, count);
    }
}
