/* 
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
*/

public class MaximumProductSubArray {
    public int maxProduct(int[] nums) {
        if (nums.length == 0)
            return 0;
        int minProduct = nums[0];
        int maxProduct = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // new MinProduct
            int newMin = Math.min(nums[i] * minProduct, nums[i] * maxProduct);
            // new MaxProduct
            int newMax = Math.max(nums[i] * minProduct, nums[i] * maxProduct);
            minProduct = Math.min(newMin, nums[i]);
            maxProduct = Math.max(newMax, nums[i]);
            res = Math.max(res, maxProduct);
        }
        return res;
    }
}
