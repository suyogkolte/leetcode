/*
Given an array of length N and a number M, write a recursive function which returns an array containing
indices of all items in the array which have value equal to M.
*/

import java.util.ArrayList;

public class Find_All_Indices_In_Array {
    public static void main(String[] args){
        int[] arr = new int[]{98, 67, 26, 10, 41, 10, 32, 162, 170};
        int m = 10;
        ArrayList<Integer> arrList = new ArrayList<>();
        findAllIndices(arr, m, 0, arrList);

        int[] res = new int[arrList.size()];
        for(int i = 0; i < arrList.size(); i++){
            res[i] = arrList.get(i);
        }

        System.out.println(m + " was found at the following indices in the given array: ");
        for(int x : res){
            System.out.print(x + "\t");
        }
    }

    private static void findAllIndices(int[] arr, int m, int idx, ArrayList<Integer> arrList){
        //Base case
        if(idx == arr.length)
            return;

        //Self work
        if(arr[idx] == m)
            arrList.add(idx);

        //Recursive task
        findAllIndices(arr, m, idx + 1, arrList);
    }
}
