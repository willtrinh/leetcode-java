/* 
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
Find all the elements of [1, n] inclusive that do not appear in this array.
Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space. 

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
*/

class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // Time: O(n), Space: O(n)
        List<Integer> missingNumbers = new ArrayList<>();
        HashSet<Integer> numbers = new HashSet<>();

        for (int num : nums) {
            numbers.add(num);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!numbers.contains(i)) {
                missingNumbers.add(i);
            }
        }
        return missingNumbers;
    }

    // Better solution Time: O(n), Space: O(1)
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<Integer>();
        // Negate each number while traversing
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }
        // Run again and find the index that is not negated.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missingNumbers.add(i + 1);
            }
        }
        return missingNumbers;
    }
}
