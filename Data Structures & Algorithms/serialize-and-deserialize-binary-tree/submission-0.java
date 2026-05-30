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

public class Codec {
    /*
    Input Serialize: Binary Tree root
    Output Serialize: string representing tree meant to be used by deserialize
    Input Deserialize: String to be converted
    Output Deserialize: Original binary tree root/structure

    Approach Serilization:
    - Seperators to determine when numbers are part of two differnet nodes
    - `n` char to represent null, and use `,` as our delimeter
    - Serialize the string to be the binary tree represented level by level left to right
    - Base case is still null node, but you add the `n` to string first
    Ex. 1,2,3,n,n,4,5,n,n,n,n,
          ^   ^ ^

    Approach Deserialization:
    - Number of nodes at each level(including null) doubles for each level -> starts at 1 
    - Keep track of three pointers, two of them always stay together and represent the children nodes
    - These pointers are the children in left -> right order of a given node
    - The first pointer moves to each node one by one, and the gap between this pointer and the two pointer
    should increase by one every time
    - The first pointer should skip any `n` null values, meaning that the gap between the first and last
    two pointers will shrink, which is fine
    - Before checking for null values/any value at first pointer, make the gap increse by 1 first
    */

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder serializedTree = new StringBuilder();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);

        while(!nodes.isEmpty()) {
            for(int i = nodes.size(); i > 0; i--) {
                if (nodes.peek() == null) {
                    nodes.poll();
                    serializedTree.append("n,");
                    continue;
                }
                TreeNode nodeToRemove = nodes.poll();
                serializedTree.append(Integer.toString(nodeToRemove.val) + ",");
                nodes.offer(nodeToRemove.left);
                nodes.offer(nodeToRemove.right);
            }
        }
        System.out.println(serializedTree);
        return serializedTree.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int first = 0;
        TreeNode dummyNode = new TreeNode(data.charAt(first) != 'n' ? Integer.parseInt(String.valueOf(data.charAt(first))) : Integer.MIN_VALUE);
        int second = findNextValue(data, 0, 1);
        int third = findNextValue(data, second, 1);

        while(third < data.length() - 1) {
            TreeNode current = new TreeNode(data.charAt(first) != 'n' ? Integer.parseInt(String.valueOf(data.charAt(first))) : Integer.MIN_VALUE);
            if (first == 0) dummyNode.left = current;
            current.left = new TreeNode(data.charAt(second) != 'n' ? Integer.parseInt(String.valueOf(data.charAt(second))) : Integer.MIN_VALUE);
            current.right = new TreeNode(data.charAt(third) != 'n' ? Integer.parseInt(String.valueOf(data.charAt(third))) : Integer.MIN_VALUE);

            first = findNextValue(data, first, 1);
            while(first < data.length() - 1 && data.charAt(first) == 'n') {
                first = findNextValue(data, first, 1);
            }
            second = findNextValue(data, second, 2);
            third = findNextValue(data, third, 2);
        }

        return dummyNode.left;
    }   

    private int findNextValue(String data, int currentIndex, int times) {
        for(int i = 0; i < times; i++) {
            if (currentIndex >= data.length()) return data.length();
            char currentChar = data.charAt(currentIndex);
            while(currentChar != ',') {
                currentChar = data.charAt(currentIndex++);
                continue;
            }
        }
        return currentIndex;
    }
}
