//Source: https://leetcode.com/problems/furthest-building-you-can-reach/description/?envType=daily-question&envId=2024-02-17
/*
There are many ways to solve this problem
Here, we are using backtracking. This approach causes time limit exceeded error for large input
values but works for smaller input values
*/
public class Furthest_Building_You_Can_Reach {
    private static int max = 0;

    public static void main(String[] args) {
        int[] heights = {4,2,7,6,9,14,12};
        int bricks = 5;
        int ladders = 1;
        System.out.println("The furthest building you can reach is " + furthestBuilding(heights, bricks, ladders));
    }

    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        backtrack(0, heights, bricks, ladders);
        return max;
    }

    public static void backtrack(int currIdx, int[] heights, int bricks, int ladders) {
        // Positive base case
        if(currIdx == heights.length - 1) {
            max = Math.max(currIdx, max);
            return;
        }

        // Negative base case
        if(ladders == 0 && (heights[currIdx+1] - heights[currIdx] > bricks)) {
            max = Math.max(currIdx, max);
            return;
        }

        if(heights[currIdx] > heights[currIdx+1])
            backtrack(currIdx+1, heights, bricks, ladders);
        else {
            int heightDiff = heights[currIdx+1] - heights[currIdx];
            if(heightDiff <= bricks)
                backtrack(currIdx+1, heights, bricks - heightDiff, ladders);

            if(ladders > 0)
                backtrack(currIdx+1, heights, bricks, ladders - 1);
        }
    }
}
