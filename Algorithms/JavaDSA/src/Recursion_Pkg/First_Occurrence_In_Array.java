// Given an array and an element x, find the index where the index where the first occurrence of x is
// Return -1 if there is no occurrence
package Recursion_Pkg;
public class First_Occurrence_In_Array {
    public static void main(String[] args) {
        int[] arr = new int[]{32, 45, 67, 98, 12, 156};
        int x = 98;
        int res = findOcc(0, x, arr);
        System.out.println(x + " can be found in the given array at index " + res);
    }

    private static int findOcc(int idx, int x, int[] arr){
        //Base case
        if(idx >= arr.length)
            return -1;

        //Self work
        if(arr[idx] == x)
            return idx;

        //Recursive task
        return findOcc(idx + 1, x, arr);
    }
}
