/* 
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
*/
public class ProductofArrayExceptSelf {
    // O(n) space using 2 product lists (left and right)
    public int[] productExceptSelf1(int[] nums) {
        int len = nums.length;
        int[] leftProduct = new int[len];
        int[] rightProduct = new int[len];
        int[] product = new int[len];
        // leftProduct contains all elements to the left
        leftProduct[0] = 1;
        for (int i = 1; i < len; i++) {
            leftProduct[i] = nums[i - 1] * leftProduct[i - 1]; // leftProduct[i-1] contains the product of elements left
                                                               // of i-1
        }
        rightProduct[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            rightProduct[i] = nums[i + 1] * rightProduct[i + 1]; // rightProduct[i+1] contains product of elements right
                                                                 // of i+1
        }
        // constructing res array
        for (int i = 0; i < len; i++) {
            product[i] = leftProduct[i] * rightProduct[i];
        }
        return product;
    }

    // O(1) space
    public int[] productExceptSelf2(int[] nums) {
        if (nums.length == 0)
            return new int[0];
        int[] res = new int[nums.length];
        res[0] = 1;
        // calculate left product and store in res
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int rightProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= rightProduct; // multiple right product with left product
            rightProduct *= nums[i];
        }
        return res;
    }
}
