/* 
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
 

Constraints:

0 <= nums.length <= 100
0 <= nums[i] <= 400
*/

public class HouseRobber {
    // reduce the problem into 1. rob current house or 2. don't rob current house
    public int rob(int[] nums) {
        // if no house, nothing to rob
        if (nums.length == 0 || nums == null)
            return 0;
        // if only 1 house, rob that one.
        if (nums.length == 1)
            return nums[0];
        // if 2 houses, pick the max amount between the 2.
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        // using dp array to store max amount of money at each position abiding by the
        // contraints
        int[] dp = new int[nums.length];
        // max amount considering only 1 house is that house
        dp[0] = nums[0];
        // max amount between 2 houses
        dp[1] = Math.max(nums[0], nums[1]);
        // iterate and add max amount we can rob starting from 3rd house.
        for (int i = 2; i < dp.length; i++) {
            // num[i] + dp[i -2] = amount of current house + sum of prev prev houses
            // dp[i-1] = sum of prev houses
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        // the last element in dp array is the max amount of money we can rob
        return dp[nums.length - 1];
    }

    // using 2 variables
    public int rob2(int[] nums) {
        if (nums.length == 0)
            return 0;
        int prev1 = 0, prev2 = 0;
        for (int num : nums) {
            int temp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = temp;
        }
        return prev1;
    }
}
