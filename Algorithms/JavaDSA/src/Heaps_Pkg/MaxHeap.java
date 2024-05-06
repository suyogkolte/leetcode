/*
This class covers basic heap operations like:
1] Inserting an element to a max heap
2] Delete an element from a max heap
*/
package Heaps_Pkg;
public class MaxHeap {
    // A pointer pointing to the elements in the array in the heap.
    int[] arr;

    // Maximum possible size of he Max Heap.
    int maxSize;

    // Number of elements in the Max heap currently.
    int heapSize;

    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        heapSize = 0;
    }

    // returns index of the parent
    private int parent(int idx) {
        return (idx-1) / 2;
    }

    // returns index of the lChild
    private int lChild(int idx) {
        return (2*idx + 1);
    }

    // returns index of the rChild
    private int rChild(int idx) {
        return (2*idx + 2);
    }

    public void insertKey(int key) {
        // To check whether the key can be inserted or not.
        if(heapSize == maxSize) {
            System.out.println("Overflow: could not insert key");
            return;
        }

        // The new key is initially inserted at the end.
        heapSize++;
        int i = heapSize - 1;
        arr[i] = key;

        // The max heap property is checked and if violation occurs it is restored.
        while(i != 0 && arr[parent(i)] < arr[i]) {
            int tmp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)] = tmp;
            i = parent(i);
        }
    }

    // Deletes a key at given index idx
    public void deleteKey(int idx) {
        // It increases the value of the key to infinity and then removes the maximum value.
        increaseKey(idx, Integer.MAX_VALUE);
        removeMax();
    }

    // Increases value of key at index 'i' to new_val.
    private void increaseKey(int idx, int newVal) {
        arr[idx] = newVal;
        while (idx != 0 && arr[parent(idx)] < arr[idx]) {
            int temp = arr[idx];
            arr[idx] = arr[parent(idx)];
            arr[parent(idx)] = temp;
            idx = parent(idx);
        }
    }

    // Removes the root which in this case contains the max element
    private int removeMax() {
        // Checking whether the heap array is empty or not.
        if (heapSize <= 0)
            return Integer.MIN_VALUE;
        if (heapSize == 1) {
            heapSize--;
            return arr[0];
        }

        // Storing the max element to remove it.
        int root = arr[0];
        arr[0] = arr[heapSize - 1];
        heapSize--;

        // To restore the property of the Max heap.
        maxHeapify(0);

        return root;
    }

    // Heapifies a sub-tree taking the given index as the root.
    private void maxHeapify(int idx) {
        int l = lChild(idx);
        int r = rChild(idx);
        int largest = idx;
        if (l < heapSize && arr[l] > arr[idx])
            largest = l;
        if (r < heapSize && arr[r] > arr[largest])
            largest = r;
        if (largest != idx) {
            int temp = arr[idx];
            arr[idx] = arr[largest];
            arr[largest] = temp;
            maxHeapify(largest);
        }
    }

    public void printHeap() {
        System.out.println("\n-------------------------------------");

        if(heapSize == 0){
            System.out.println("The given heap is empty");
            return;
        }

        for(int i = 0; i < heapSize; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(5);
        heap.printHeap();
        heap.insertKey(4);
        heap.printHeap();
        heap.insertKey(2);
        heap.printHeap();
        heap.insertKey(5);
        heap.printHeap();
        heap.insertKey(7);
        heap.printHeap();
        heap.insertKey(9);
        heap.printHeap();
        heap.deleteKey(4);
        heap.printHeap();
    }
}
