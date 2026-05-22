/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    /*
    Input: binary tree root
    Output: list of nodes in each binary tree level (BFS) -> List<List<Integer>>

    Approach:
    - Queue data structure and pop from it until it's original nodes are gone -> we add the next level to it
    - To pop only original nodes and add at the same time -> take size of queue before adding
    - For each node that was originally in the queue, add it's left and right children if non null
    - Keep the whole algorithm running until queue empty, this means that the end of the tree
    - When were popping original nodes, add it to a new sublist
     */

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> nodesByLevel = new ArrayList<>();
        Queue<TreeNode> nodes = new ArrayDeque<>();
        if (root == null) return nodesByLevel;
        nodes.offer(root);

        while (!nodes.isEmpty()) {
            List<Integer> sublist = new ArrayList<>();
            for (int i = nodes.size(); i > 0; i--) {
                TreeNode currentNode = nodes.poll();
                if (currentNode.left != null) {
                    nodes.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    nodes.offer(currentNode.right);
                }
                sublist.add(currentNode.val);
            }
            nodesByLevel.add(sublist);
        }

        return nodesByLevel;
    }
}
