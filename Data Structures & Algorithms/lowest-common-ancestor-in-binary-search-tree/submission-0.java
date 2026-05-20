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
    Input: root node, p and q nodes which are all part of the same tree
    Output: first ancestor that both nodes p and q share (inclusive)
    -assume nodes p and q are not null, and answer is guranteed

    Approach:
    -We have to arrive at nodes p and q, and find out when both nodes cross paths for first time
    -As we traverse the nodes, we store what nodes have been seen so far, each in their own array
    -We look for the first node that both share in common
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> seenNodesP = new ArrayList<>();
        List<TreeNode> seenNodesQ = new ArrayList<>();

        dfs(root, p, seenNodesP);
        dfs(root, q, seenNodesQ);
    }

    public void dfs(TreeNode node, TreeNode nodeToFind, List<TreeNode> seenNodes) {
        if (node == nodeToFind || node == null) return;
        seenNodes.add(node);
        dfs(node.left, nodeToFind, seenNodes);
        dfs(node.right, nodeToFind, seenNodes);
    }
}
