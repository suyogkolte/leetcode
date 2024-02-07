// Find the max element in an array recursively

public class Max_Element_In_Array {
    public static void main(String[] args) {
        int[] arr = new int[]{13, 67, 12, 89, 93, 5};
        int res = findMax(0, Integer.MIN_VALUE, arr);
        System.out.println("Max element in the given array is " + res);
    }

    private static int findMax(int idx, int maxElem, int[] arr){
        //Base case
        if(idx >= arr.length)
            return maxElem;

        //Self work
        if(arr[idx] > maxElem)
            maxElem = arr[idx];

        //Recursive task
        return findMax(idx + 1, maxElem, arr);
    }
}
