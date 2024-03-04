// Source: https://leetcode.com/problems/two-city-scheduling/description/

import java.util.Arrays;

public class Two_City_Scheduling {
    public static void main(String[] args) {
        int[][] costs = {{10,20},{30,200},{400,50},{30,20}};
        System.out.println("Min cost will be " + twoCitySchedCost(costs));
    }

    public static int twoCitySchedCost(int[][] costs) {
        int minCost = 0;
        int[] refund = new int[costs.length];

        int idx = 0;
        for(int[] cost : costs) {
            refund[idx] = cost[1] - cost[0];
            idx++;
            minCost = minCost + cost[0];
        }

        Arrays.sort(refund);
        for(int i = 0; i < costs.length/2; i++) {
            minCost = minCost + refund[i];
        }

        return minCost;
    }
}
