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
    // 第一种实现，从上到下，会重复计算
    // Time Complexity O(n^2) --> LinkedList
    // Space Complexity O(n) --> LinkedList
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (Math.abs(height(root.left) - height(root.right)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);

    }

    // 第二种实现， 从下到上， 只要下层出现不平衡，我们可以马上返回，这样避免了重复的运算
    // Time Complexity O(n)
    // Space Complexity O(n)
    // TODO
    public boolean isBalanced2(TreeNode root) {

    }


    // 每一层的高度由 Max(左右子树)的值+1 表示
    public int height(TreeNode node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }
}