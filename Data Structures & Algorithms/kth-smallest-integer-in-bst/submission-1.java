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
   private int kthSmallest(TreeNode root, int k) {
      List<TreeNode> nodes = new ArrayList<>();
      dfs(root, nodes);
      return nodes.get(k - 1).val;
   }
    
   private void dfs(TreeNode node, List<TreeNode> nodes) {
      if (node == null) return;
      
      dfs(node.left, nodes);
      nodes.add(node);
      dfs(node.right, nodes);
   }
}
