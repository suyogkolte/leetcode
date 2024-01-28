// Given an array of zeroes and ones, sort it in ascending order
public class SortArrayOf_Zeroes_And_Ones {
    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 0, 1, 1, 0};

        int low = 0;
        int high = nums.length - 1;

        while(low < high)
        {
            if(nums[low] == 0)
                low++;
            else if(nums[low] == 1 && nums[high] == 0)
            {
                int tmp = nums[high];
                nums[high] = nums[low];
                nums[low] = tmp;
                low++;
                high--;
            }
            else
                high--;
        }

        System.out.print("Sorted array is: ");
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
