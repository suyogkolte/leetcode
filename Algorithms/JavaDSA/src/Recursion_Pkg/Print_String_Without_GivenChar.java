/*
Given a string str of alphabets, write a recursive function that prints a new string which has
all characters of str except any occurrence of x
e.g. str: abcxxadxacxe
     char: x
     o/p: abcadace
 */
package Recursion_Pkg;
public class Print_String_Without_GivenChar {
    public static void main(String[] args) {
        String str = "abcxxadxacxe";
        char ch = 'x';
        StringBuilder res = new StringBuilder(str);

        removeOcc(res.length() - 1, ch, res);
        System.out.println("I/P string: " + str);
        System.out.println("O/P string: " + res.toString());
    }

    private static void removeOcc(int idx, int ch, StringBuilder res){
        //Base case
        if(idx < 0)
            return;

        //Self work
        if(res.charAt(idx) == ch)
            res.deleteCharAt(idx);

        //Recursive task
        removeOcc(idx - 1, ch, res);
    }
}
