// Source: https://leetcode.com/problems/kth-largest-element-in-an-array/
package Heaps_Pkg;
import java.util.PriorityQueue;

public class Kth_Largest_Element {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        int res = findKthLargest(nums, k);
        System.out.println(k + " largest element is " + res);
    }

    public static int findKthLargest(int[] nums, int k) {
        // Use min heap
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int num : nums) {
            heap.add(num);

            if(heap.size() > k)
                heap.remove();
        }

        return heap.peek();
    }
}
