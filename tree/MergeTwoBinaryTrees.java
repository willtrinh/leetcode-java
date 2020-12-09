/* 
Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
Note: The merging process must start from the root nodes of both trees.
*/
public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // if both trees empty
        if (t1 == null && t2 == null) {
            return null;
        }
        // if one of the tree empty, return the other
        if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        }
        TreeNode res = t1;
        res.val = t1.val + t2.val;
        res.left = mergeTrees(t1.left, t2.left);
        res.right = mergeTrees(t1.right, t2.right);
        return res;
    }
}
