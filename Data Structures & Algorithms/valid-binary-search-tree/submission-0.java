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
    Input: root of a binary tree
    Output: boolean value of valid binary search tree
    Valid BST Def:
    - Every single node in the left subtree must have a value less than the root
    - Every single node in the right subtree must have a value greater than the root
    - Every single child node from root must be a valid subtree when considering it's children as well

    - DFS in order traversal to validate binary search tree
    - Going all the way to left node until leaf is found
    - Moving in order (left, node, right) 
    - At each step, check if left child is less than node, and right child is more than node

    For DFS:
    - Base case of node == null
    1. Make a recursive call to left
    2. Check if left child is greater than node -> return false
    3. Make a recursive call to right
    4. Check if right child is less than node -> return false
    5. return true
    */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        isValidBST(root.left);
        if (root.left != null && root.left.val > root.val) return false;
        isValidBST(root.right);
        if(root.right != null && root.right.val < root.val) return false;
        return true;
    }
}
