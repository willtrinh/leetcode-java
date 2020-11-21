// Given an array nums, write a function to move all 0's to the end of it
// while maintaining the relative order of the non-zero elements.
/* 
Example:
Input: [0,1,0,3,12]
Output: [1,3,12,0,0]

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.

*/
class MoveZeroes {
    public void moveZeroes(int[] nums) {
        // If empty array then return
        if (nums == null || nums.length == 0)
            return;
        int index = 0;
        // Shift non-zero values as far forward as possible
        // Fill remaining space with zeros
        for (int num : nums) {
            if (num != 0)
                nums[index++] = num;
        }

        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    // Alternative Solution with less operations & 1 loop
    public void moveZeroes2(int[] nums) {
        // If empty array then return
        if (nums == null || nums.length == 0)
            return;
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }
}
