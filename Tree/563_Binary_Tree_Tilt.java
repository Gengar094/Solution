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
    public int sum;
    public int findTilt(TreeNode root) {
        addUp(root);
        return sum;
    }

    // Sum of total vals of left subtree - sum of total vals of right subtree, then add this number into a counter.
    public int addUp(TreeNode root) {
        if (root == null) return 0;
        int left = addUp(root.left);
        int right = addUp(root.right);
        sum += Math.abs(left - right);
        return left + right + root.val;
    }
}