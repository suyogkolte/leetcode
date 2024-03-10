/*
Given an array nums find the K largest elements in it without sorting the array
*/

import java.util.PriorityQueue;

public class K_Largest_Elements {
    static int[] res;

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 3;
        res = new int[k];
        fetchKLargestElems(nums, k);

        System.out.println(k + " largest elements are ");
        for(int a : res) {
            System.out.print(a + " ");
        }
    }

    private static void fetchKLargestElems(int[] nums, int k) {
        // Use min heap
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int num : nums) {
            heap.add(num);

            if(heap.size() > k) {
                heap.remove();
            }
        }

        int idx = k - 1;
        while(heap.size() > 0) {
            res[idx] = heap.remove();
            idx--;
        }
    }
}
