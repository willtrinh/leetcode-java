/* 
Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
 

Constraints:

1 <= nums.length <= 2500
-104 <= nums[i] <= 104
*/
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        // array to store the longest increasing subsequence from 0-i
        int[] dp = new int[nums.length];
        // LIS from 0-0 is 1
        dp[0] = 1;
        // store the LIS of the entire array
        int maxSeq = 1;

        for (int i = 1; i < nums.length; i++) {
            int maxVal = 0;
            // for each i, start j from 0 to i
            for (int j = 0; j < i; j++) {
                // if nums[j] < nums[i] -> left num < right num -> increasing subsequence
                if (nums[i] > nums[j]) {
                    // update maxVal
                    maxVal = Math.max(maxVal, dp[j]);
                }
            }
            dp[i] = maxVal + 1;
            maxSeq = Math.max(maxSeq, dp[i]);
        }
        return maxSeq;
    }
}
