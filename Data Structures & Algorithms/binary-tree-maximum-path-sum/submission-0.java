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
    Input: root node of a non empty binary tree
    Output: the maximum path sum of any non empty path
    - A path is a sequence of node when pairs of adjacent nodes are connected
    - Node cannot appear more than once in a path -> no backtracking
    - Path doesn't need to include the root
    - The actual path sum is just the addition of the node values
    - The path must contain at least one node value

    Approach: 
    - Intuitive approach is just brute force, and find every combo of sums
    - DFS to reach the leaf of the tree, and once we start propergating up the call stack,
    we remove that node and calculate the sum without that value
    - At that node remove every single other node as well and caluculate sum
    - Keep track of the maximum sum and keep it updated
    - Basically for every node, remove every other node and calculate the sum
    */ 
    public int maxPathSum(TreeNode root) {
        int currentMaxSum = root.val;
        currentMaxSum = dfs(root, currentMaxSum, currentMaxSum);

        return currentMaxSum;
    }

    private int dfs(TreeNode node, int maxSum, int currentSum) {
        if (node == null) return 0;
        dfs(node.left, maxSum, currentSum + node.val);
        maxSum = Math.max(maxSum, currentSum);
        dfs(node.right, maxSum, currentSum + node.val);
        maxSum = Math.max(maxSum, currentSum);

        return maxSum;
    }
}
