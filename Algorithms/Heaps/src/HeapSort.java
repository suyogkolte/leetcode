/*
Sort the given array nums in ascending order using HeapSort

Note:
1] To sort an array in asc order, we use max heap
2] To sort an array in desc order, we use min heap

https://builtin.com/data-science/heap-sort#
*/

public class HeapSort {
    int[] arr;
    int heapSize;
    int maxSize;

    public HeapSort(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        this.heapSize = 0;
    }

    private int parent(int idx) {
        return (idx - 1) / 2;
    }

    private int lChild(int idx) {
        return (2 * idx) + 1;
    }

    private int rChild(int idx) {
        return (2 * idx) + 2;
    }

    public void insertInMaxHeap(int key) {
        if(heapSize == maxSize) {
            System.out.println("Overflow error: the given key cannot be inserted");
            return;
        }

        heapSize++;
        int i = heapSize - 1;
        arr[i] = key;

        while(i != 0 && arr[i] > arr[parent(i)]) {
            int tmp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)] = tmp;
            i = parent(i);
        }
    }

    private void maxHeapify(int[] nums, int idx) {
        int l = lChild(idx);
        int r = rChild(idx);
        int largest = idx;

        if(l < heapSize && nums[l] > nums[largest])
            largest = l;
        if(r < heapSize && nums[r] > nums[largest])
            largest = r;

        if(largest != idx) {
            int tmp = nums[idx];
            nums[idx] = nums[largest];
            nums[largest] = tmp;
            maxHeapify(nums, largest);
        }
    }

    public void sort() {
        System.out.println("-----------------------------------------------");
        if(heapSize == 0) {
            System.out.println("The given heap cannot be sorted as it is empty");
            return;
        }

        while(heapSize > 0) {
            int tmp = arr[heapSize - 1];
            arr[heapSize - 1] = arr[0];
            arr[0] = tmp;
            heapSize = heapSize - 1;
            maxHeapify(arr, 0);
        }

        System.out.println("\nThe array sorted in ascending order is: ");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public void print() {
        System.out.println("\n--------------------------------");
        if(heapSize == 0) {
            System.out.println("The given heap is empty");
            return;
        }

        for(int i = 0; i < heapSize; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        //int[] nums = {45, 2, 98, 10, 3, 6};
        int[] nums = {4, 25, 36, 9, 15};
        HeapSort heap = new HeapSort(nums.length);
        heap.print();

        for(int num : nums){
            heap.insertInMaxHeap(num);
        }
        heap.print();
        heap.sort();

    }
}
