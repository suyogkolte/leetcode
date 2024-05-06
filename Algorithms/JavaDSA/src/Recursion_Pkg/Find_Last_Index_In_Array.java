/*
Given an array of length N and a number M, write a recursive function which returns the last index at which
M is found in the array and -1 if M is not found anywhere
*/
package Recursion_Pkg;
public class Find_Last_Index_In_Array {
    public static void main(String[] args) {
        int[] arr = new int[]{98, 67, 26, 10, 41, 10, 32, 162, 170};
        int m = 10;
        int res = findLastIndex(arr, m, arr.length - 1);

        if(res == -1)
            System.out.println(m + " was not found in the given array");
        else
            System.out.println(m + " was found last at idx: " + res + " in the given array");
    }

    private static int findLastIndex(int[] arr, int m, int idx){
      //Base case
      if(idx < 0)
          return -1;

      //Self work
      if(arr[idx] == m)
          return idx;

      //Recursive task
        return findLastIndex(arr, m, idx - 1);
    }
}
