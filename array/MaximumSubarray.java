package array;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums.length < 2)
            return nums[0];
        int acc = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (acc < 0) {
                acc = 0;
            }
            acc += nums[i];
            max = Math.max(max, acc);
        }
        return max;
    }
}
