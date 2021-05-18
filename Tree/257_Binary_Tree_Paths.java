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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList();
        StringBuilder sb = new StringBuilder();
        findPaths(root, res, sb);
        return res;
    }
    public void findPaths(TreeNode root, List<String> res, StringBuilder sb) {
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            res.add(sb.toString());
            return;
        }
        sb.append(root.val);
        sb.append("->");
        StringBuilder temp = new StringBuilder(sb.toString());
        // 加上if防止任意一侧子树为null，在24行判断条件时会抛出错误
        if (root.left != null) findPaths(root.left, res, sb);
        // 在找完左边的leaf之后，要重置stringbuilder
        sb = temp;
        if (root.right != null) findPaths(root.right, res, sb);

    }
}