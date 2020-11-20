// Given an array of size n, find the majority element. The majority element is
// the element that appears more than ⌊ n/2 ⌋ times.
// You may assume that the array is non-empty and the majority element always
// exist in the array.

class MajorityElement {
    public int majorityElement(int[] nums) {
        // Moore's voting algorithm
        // Time: O(n), Space: 0(1)
        int majorityElement = nums[0];
        int count = 1;
        for (int num : nums) {
            if (count == 0) {
                count++;
                majorityElement = num;
            } else if (majorityElement == num) {
                count++;
            } else
                count--;
        }
        return majorityElement;

    }
}