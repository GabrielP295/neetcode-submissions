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
       Input: root of a binary search tree and int k
       Output: the kth smallest node value
       For BST:
       - Every single node to the left is smaller than the current node and vice versa for right
       - This has to remain true for every subtree while respeceting ancestor nodes

       Approach: 
       - DFS to get to the smallest possible node in order traversal
       - Just move up k amount of nodes
    */ 
    public int kthSmallest(TreeNode root, int k) {
       if (root == null) return 1;


       if (kthSmallest(root.left, k) + kthSmallest(root.right, k) + 1 == k) {
        return root.val;
       }
       return 0;
    }
}
