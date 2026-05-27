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
    Input: root node of a tree, and another tree
    Output: boolean value if the first input tree contains the second input as a subtree
    - It has to be a full subtree all the way to a leaf node
    - Trees that are the exact same are considered subtrees of each other
    
    Approach:
    - Brute force: traverse the tree to get every single subtree, and compare to subtree input
    - Traversing the original tree recursively and making a comparison at every subtree
    - There's no point in checking subtrees that don't have the same root as the subtree input, so instead
    find root in original tree first then run sameTree compared to input subtree
    - In order to find root of subtree in og tree, use helper to traverse the tree dfs and find root -> if
    root is never found, then cant be subtree -> false
    - for sameTree helper consider 3 cases:
        - two nulls -> true
        - one null and one value -> false
        - two values -> compare actual values -> either true or false  <---- Recursion happens here
     */
    public boolean isSubtree(TreeNode root, TreeNode subtree) {
        TreeNode subtreeRoot = findRootOfSubtree(root, subtree);
        if (subtreeRoot == null) return false;
        return sameTree(subtree, subtreeRoot);
    }

    public TreeNode findRootOfSubtree(TreeNode root, TreeNode subtree) {
        if (root == null) return null;
        if (root.val == subtree.val) return root;
        TreeNode leftNode = findRootOfSubtree(root.left, subtree);
        if (leftNode != null) return leftNode;
        return findRootOfSubtree(root.right, subtree);
    }
    
    public static boolean sameTree(TreeNode original, TreeNode subtree) {
        if (original == null && subtree == null) return true;
        if (original == null || subtree == null || original.val != subtree.val) return false;
        
        return sameTree(original.left, subtree.left) && sameTree(original.right, subtree.right);
    }
}
