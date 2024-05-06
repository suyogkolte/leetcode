/*
Given an input array of length N and a target number. Write a recursive function
i) which counts the number of subsets of the array which sum to the target.
ii) which prints the subsets of the array which sum to the target
*/
package Recursion_Pkg;
import java.util.ArrayList;

public class Subsets_Of_Array {
    private class Subset{
        int first;
        int second;
    }

    private static ArrayList<Subset> listSubsets = new ArrayList<>();

    public static void main(String[] args) {
        int[] input = {8, 25, 81, 4, 59, 16, 96, 10, 2};
        int target = 12;

        Subsets_Of_Array objSubOfArr = new Subsets_Of_Array();
        objSubOfArr.getSubsets(input, 0, target);

        System.out.println("Number of subsets of the array which sum to the target is " + listSubsets.size());

        System.out.println("The subsets of the array which sum to the target are: ");
        for(Subset sub : listSubsets){
            System.out.println("[" + sub.first + ", " + sub.second + "]");
        }
    }

    private void getSubsets(int[] input, int idx, int target){
        //Base case
        if(idx == input.length)
            return;

        //Self work
        for(int i = idx + 1; i < input.length; i++){
            if(input[idx] + input[i] == target){
                Subset objSubset = new Subset();
                objSubset.first = input[idx];
                objSubset.second = input[i];
                listSubsets.add(objSubset);
            }
        }

        //Recursive task
        getSubsets(input, idx + 1, target);
    }
}
