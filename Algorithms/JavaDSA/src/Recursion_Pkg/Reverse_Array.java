/*
Given an array of length N, write a recursive function which reverses the array
*/
package Recursion_Pkg;
public class Reverse_Array {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 30, 40, 50};

        System.out.println("For I/P array: ");
        for (int num : arr){
            System.out.print(num + " ");
        }

        reverseArr(arr, 0, arr.length - 1);
        System.out.println();
        System.out.println("It's reverse is O/P: ");
        for (int num : arr){
            System.out.print(num + " ");
        }
    }

    private static void reverseArr(int[] arr, int startIdx, int endIdx){
        //Base case
        if(startIdx >= endIdx)
            return;

        //Self work
        int tmp = arr[startIdx];
        arr[startIdx] = arr[endIdx];
        arr[endIdx] = tmp;

        //Recursive task
        reverseArr(arr, startIdx + 1, endIdx - 1);
    }
}
