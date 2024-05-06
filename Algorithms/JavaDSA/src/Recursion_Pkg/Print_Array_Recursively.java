// Given an array, print the elements inside it recursively
package Recursion_Pkg;
public class Print_Array_Recursively {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        if(arr.length == 0)
            System.out.println("The given array is empty");

        System.out.println("Printing array elements from start: ");
        printArrFromStart(0, arr);
        System.out.println();
        System.out.println("Printing array elements from end: ");
        printArrFromEnd(arr.length-1, arr);
    }

    private static void printArrFromStart(int idx, int[] arr) {
        //Base case
        if(idx >= arr.length)
            return;

        //Self work
        System.out.println(arr[idx]);

        //Recursive task
        printArrFromStart(idx + 1, arr);
    }

    private static void printArrFromEnd(int idx, int[] arr) {
        //Base case
        if(idx < 0)
            return;

        //Self work
        System.out.println(arr[idx]);

        //Recursive task
        printArrFromEnd(idx - 1, arr);
    }
}
