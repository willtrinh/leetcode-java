/* 
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
 

Constraints:

-10^9 <= nums1[i], nums2[i] <= 10^9
nums1.length == m + n
nums2.length == n
*/
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // last non-zero index of nums1
        int i = m - 1;
        // last non-zero index of nums2
        int j = n - 1;
        // last index of nums1 (size = m + n)
        int k = m + n - 1;
        // traverse nums1 and nums2 backwards, time = O(m+n) terminate early if nums2
        // reaches the end.
        while (j >= 0) {
            if (i < 0 || nums2[j] >= nums1[i]) {
                // move the largest element to the last index in nums1
                nums1[k--] = nums2[j--];
            } else {
                nums1[k--] = nums1[i--];
            }
        }
    }
}
