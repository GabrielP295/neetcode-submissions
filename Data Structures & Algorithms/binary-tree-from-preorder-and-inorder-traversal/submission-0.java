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
    Input: two integer arrays representing in order and preorder traversals of same binary tree
    Output: the original binary tree represented as a TreeNode object
    - Integer arrays only include node values, no nulls or other metadata
    - Both arrays are same size and contain the same unique values(diff order)

    Approach: 
    - First value of preorder traversal array will be our root node
    - First value of inorder will be the left most node
    - Everything to the left of the root node in the inorder array will be the left subtree, and vice versa
    - Apply this to the "root" of each subtree as well, in order to see the split of the nodes
    - Using the inorder traversal in order to split problem into smaller subtrees
    - Find the same segment in the preorder array, and then add the nodes to the tree in that exact
    order following -> root, left, right
    */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
    }
}
