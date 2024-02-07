//Find the sum of all elements in an array recursively

public class Sum_Of_Elem_In_Array {
    public static void main(String[] args) {
        int[] arr = new int[]{6, 3, 9, 1, 2};
        if(arr.length == 0)
            System.out.println("The given array is empty");

        int res = findSum(0, 0, arr);
        System.out.println("Sum of all elements in the given array is " + res);
    }

    private static int findSum(int idx, int sum, int[] arr){
        //Base case
        if(idx >= arr.length)
            return sum;

        //Self work
        sum = sum + arr[idx];

        //Recursive task
        return findSum(idx + 1, sum, arr);
    }
}
