/*
This class covers basic heap operations like:
1] Inserting an element to a min heap
2] Delete an element from a min heap
*/

public class MinHeap {
    // A pointer pointing to the elements in the array in the heap.
    int[] arr;

    // Number of elements in the Min heap currently.
    int heapSize;

    // Maximum possible size of he Max Heap.
    int maxSize;

    public MinHeap(int maxSize) {
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
            System.out.println("Overflow error: Cannot insert key");
            return;
        }

        // The new key is initially inserted at the end.
        heapSize++;
        int idx = heapSize - 1;
        arr[idx] = key;

        // The max heap property is checked and if violation occurs it is restored.
        while(idx != 0 && arr[parent(idx)] > arr[idx]) {
            int tmp = arr[idx];
            arr[idx] = arr[parent(idx)];
            arr[parent(idx)] = tmp;
            idx = parent(idx);
        }
    }

    // Deletes a key at given index idx
    public void deleteKey(int idx) {
        // It decreases the value of the key to negative infinity and then removes the min value.
        decreaseValue(idx, Integer.MIN_VALUE);
        removeMin();
    }

    // Decreases value of key at index 'i' to new_val.
    private void decreaseValue(int idx, int newValue) {
        arr[idx] = newValue;
        while(idx != 0 && arr[parent(idx)] > arr[idx]) {
            int tmp = arr[idx];
            arr[idx] = arr[parent(idx)];
            arr[parent(idx)] = tmp;
            idx = parent(idx);
        }
    }

    // Removes the root which in this case contains the min element
    private int removeMin() {
        // Checking whether the heap array is empty or not.
        if(heapSize <= 0)
            return Integer.MAX_VALUE;
        if(heapSize == 1) {
            heapSize--;
            return arr[0];
        }

        // Storing the min element to remove it.
        int root = arr[0];
        arr[0] = arr[heapSize - 1];
        heapSize--;

        // To restore the property of the min heap.
        minHeapify(0);

        return root;
    }

    // Heapifies a sub-tree taking the given index as the root.
    private void minHeapify(int idx) {
        int l = lChild(idx);
        int r = rChild(idx);
        int smallest = idx;

        if(l < heapSize && arr[l] < arr[idx])
            smallest = l;
        if(r < heapSize && arr[r] < arr[idx])
            smallest = r;

        if(smallest != idx) {
            int tmp = arr[idx];
            arr[idx] = arr[smallest];
            arr[smallest] = tmp;
            minHeapify(smallest);
        }
    }

    private void printHeap() {
        System.out.println("\n---------------------------");

        if(heapSize == 0) {
            System.out.println("The given heap is empty");
            return;
        }

        for(int idx = 0; idx < heapSize; idx++) {
            System.out.print(arr[idx] + " ");
        }
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap(5);
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
        heap.deleteKey(2);
        heap.printHeap();
    }
}
