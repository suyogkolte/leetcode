// Given a number N, print first N natural numbers in decreasing order
package Recursion_Pkg;
public class Print_N_Natural_Nums {
    public static void main(String[] args) {
        int n = 10;
        System.out.println( n + " natural numbers in decreasing order: ");
        printNumsDecreasing(n);

        System.out.println();

        System.out.println( n + " natural numbers in increasing order: ");
        printNumsIncreasing(n);
    }

    public static void printNumsDecreasing(int n){
        //base case
        if(n == 0)
            return;

        //self work
        System.out.println(n);
        
        //recursive call
        printNumsDecreasing(n - 1);
    }

    public static void printNumsIncreasing(int n){
        //base case
        if(n == 0)
            return;

        //recursive call
        printNumsIncreasing(n - 1);

        //self work
        System.out.println(n);
    }
}
