/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
 
class Solution {
    //For int maxPathUtility method // recursive function
    public int maxPathUtility(TreeNode root, int max[]) {
        //Base case:
        if (root == null)
            return 0; // null tree is not having any impact on max sum path
        int left = Math.max(0, maxPathUtility(root.left, max)); //compute the maximum path sum of left subtree by ignoring the negative weight values.
        int right = Math.max(0, maxPathUtility(root.right, max)); //compute the maximum path sum of right subtree by ignoring the negative weight values.

        // how we can update the max[0] that will represent the maxsum path.
        max[0] = Math.max(max[0], left + right + root.val);
        return Math.max(left, right) + root.val; //return the max sum path including the current node and the greater of its left or right subtrees.
    }
    
    public int maxPathSum(TreeNode root) {
        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxPathUtility(root, max);
        return max[0];
    }
}
