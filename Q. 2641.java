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
    static final TreeNode[] nodes = new TreeNode[50_000];
    
    public TreeNode replaceValueInTree(TreeNode root) {
        nodes[0] = root;
        int sumL = root.val;
        int sumR = 0;
        final int startL = 0;
        final int startR = nodes.length - 1;
        int lastL = startL + 1;
        int lastR = startR;
        TreeNode node = null;
        
        while (lastL != 0) {
            sumR = 0;
            while (lastL > 0) {
                node = nodes[--lastL];
                node.val = sumL - node.val;
                if (node.left != null) {
                    if (node.right != null) {    // If two children.
                        sumR += node.left.val = node.right.val = 
                                    node.left.val + node.right.val;
                        nodes[lastR--] = node.left;
                        nodes[lastR--] = node.right;
                    } else {                     // If left child only.
                        sumR += node.left.val;
                        nodes[lastR--] = node.left;
                    }
                } else if (node.right != null) { // If right child only.
                    sumR += node.right.val;
                    nodes[lastR--] = node.right;
                }
            }
            if (lastR == startR)  break;    // If no more levels.
            // Process the list of nodes on the right side of 
            // nodes[] while building the list of the next level's 
            // nodes on the left side of nodes[].
            sumL = 0;
            while (lastR < startR) {
                node = nodes[++lastR];
                node.val = sumR - node.val;
                if (node.left != null) {
                    if (node.right != null) {    // If two children.
                        sumL += node.left.val = node.right.val = 
                                    node.left.val + node.right.val;
                        nodes[lastL++] = node.left;
                        nodes[lastL++] = node.right;
                    } else {                     // If left child only.
                        sumL += node.left.val;
                        nodes[lastL++] = node.left;
                    }
                } else if (node.right != null) { // If right child only.
                    sumL += node.right.val;
                    nodes[lastL++] = node.right;
                }
            }
        }
        return root;
    }
}
