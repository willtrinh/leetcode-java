/* 
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
*/
public class TwoSum {
    // Time: O(n), Space: O(n)
    public int[] twoSum(int[] nums, int target) {
        // create a map of complements
        HashMap<Integer, Integer> map = new HashMap<>();
        // indices array to store indexes of 2 numbers that add up to target
        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // check if current element's complement is in the table
            if (map.containsKey(complement)) {
                arr[0] = map.get(complement);
                arr[1] = i;
                return arr;
            } else {
                map.put(nums[i], i);
            }
        }
        return arr;
    }
}
