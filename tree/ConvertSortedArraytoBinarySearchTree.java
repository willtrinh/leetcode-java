/* 
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
*/
public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;

        TreeNode root = constructBST(nums, 0, nums.length - 1);
        return root;
    }

    public TreeNode constructBST(int[] nums, int low, int high) {
        if (low > high) { // Done constructing
            return null;
        }

        int mid = (low + high) / 2;
        // set the middle element as the root of the tree
        TreeNode node = new TreeNode(nums[mid]);
        // set the left and right subtree of the node recursively
        node.left = constructBST(nums, low, mid - 1);
        node.right = constructBST(nums, mid + 1, high);
        return node;
    }
}
