/* 
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
*/
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // while there is at least 1 discovered node in queue
        while (!queue.isEmpty()) {
            // List of integer to store the value of each node in each level of the tree
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // remove the node from the queue and add its value to the list
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null)
                    // add left node to queue
                    queue.add(node.left);
                if (node.right != null)
                    // add right node to queue
                    queue.add(node.right);
            }
            // add the level to the list
            res.add(level);
        }
        return res;
    }
}
