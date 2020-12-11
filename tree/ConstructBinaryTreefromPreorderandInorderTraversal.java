/* 
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
*/
public class ConstructBinaryTreefromPreorderandInorderTraversal {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return buildTree(0, 0, inorder.length - 1, preorder, inorder);
  }

  public TreeNode buildTree(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
    if (preStart > preorder.length - 1 || inStart > inEnd)
      return null;

    // root node
    TreeNode root = new TreeNode(preorder[preStart]);
    int inIndex = 0;
    for (int i = inStart; i <= inEnd; i++) {
      // found the root element in inorder array
      if (inorder[i] == root.val) {
        inIndex = i;
      }
    }
    // all elements left of inIndex (root in inorder array) is from left subtree
    root.left = buildTree(preStart + 1, inStart, inIndex - 1, preorder, inorder);
    // all elements right of inIndex is from right subtree
    root.right = buildTree(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
    return root;
  }
}
