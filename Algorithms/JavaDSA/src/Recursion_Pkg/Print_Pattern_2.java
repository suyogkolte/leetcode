/*
Given a number n, print the following pattern for a value of n recursively
e.g. n = 4
****
***
**
*

*/
package Recursion_Pkg;
public class Print_Pattern_2 {
    public static void main(String[] args) {
        int n = 4;
        int rows = n, cols = n;
        printRows(rows, cols);
    }

    private static void printRows(int rows, int cols){
        //Base case
        if(rows == 0)
            return;

        //Recursive task
        printCols(cols, 0);

        //Self work
        System.out.println();
        printRows(rows - 1, cols - 1);
    }

    private static void printCols(int cols, int colsCount){
        //Base case
        if(colsCount == cols)
            return;

        //Self work
        System.out.print("*");

        //Recursive task
        printCols(cols, colsCount + 1);
    }
}
