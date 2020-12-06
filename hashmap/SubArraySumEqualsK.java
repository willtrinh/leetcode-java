/* 
Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
*/
public class SubArraySumEqualsK {
    // Using Hashmap, Time O(n), Space O(n)
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // preSum, happens when sum - k = 0, increment count
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // encounter same sum, increment its count
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            // encounter new sum, make a new entry with that sum as key and num of
            // occurrences as value
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    // Using start and end point, Time O(n^2), Space O(1)
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            // reset sum to 0 when update start point
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }
}