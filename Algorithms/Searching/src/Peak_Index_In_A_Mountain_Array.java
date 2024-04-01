// Source : https://leetcode.com/problems/peak-index-in-a-mountain-array/description/

public class Peak_Index_In_A_Mountain_Array {
    public static void main(String[] args) {
        int[] arr = {0, 10, 5, 2};
        System.out.println("The peak index in the given array is " + peakIndexInMountainArray(arr));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while(left < right){
            int mid = left + ((right - left) / 2);

            if(arr[mid] > arr[mid + 1])
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }
}
