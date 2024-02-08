/*
Given a number n, print the following pattern for a value of n recursively
e.g. n = 4
****
****
****
****
*/

public class Print_Pattern_1 {
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
        printCols(cols);

        //Self work
        System.out.println();
        printRows(rows - 1, cols);
    }

    private static void printCols(int cols){
        //Base case
        if(cols == 0)
            return;

        //Self work
        System.out.print("*");

        //Recursive task
        printCols(cols - 1);
    }
}
