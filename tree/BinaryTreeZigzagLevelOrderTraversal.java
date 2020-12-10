/* 
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
*/
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // keep track of odd/even level
        boolean zigzag = false;
        // while there is at least 1 discovered node in queue
        while (!queue.isEmpty()) {
            // List of integer to store the value of each node in each level of the tree
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // remove the node from the queue and add its value to the list
                TreeNode node = queue.poll();
                // if zigzag, add the node value at index 0 of the level list, this would shift
                // the previous node.val to the right
                if (zigzag) {
                    level.add(0, node.val);
                } else {
                    level.add(node.val);
                }
                if (node.left != null)
                    // add left node to queue
                    queue.add(node.left);
                if (node.right != null)
                    // add right node to queue
                    queue.add(node.right);
            }
            // add the level to the list
            res.add(level);
            zigzag = !zigzag;
        }
        return res;
    }
}
