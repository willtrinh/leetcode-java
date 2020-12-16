/* 
Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example: 

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
Follow up:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 
*/
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0 || nums == null)
            return 0;
        int res = Integer.MAX_VALUE, sum = 0, left = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            while (sum >= s) {
                // res store the min length of contiguous subarray where sum >= s
                res = Math.min(res, i + 1 - left); // i + 1 - left is the size of current subarray
                // subtract nums[left] from sum then move left pointer forward until condition
                // of while loop no longer true
                sum -= nums[left++];
            }
        }
        return (res != Integer.MAX_VALUE) ? res : 0;
    }
}
