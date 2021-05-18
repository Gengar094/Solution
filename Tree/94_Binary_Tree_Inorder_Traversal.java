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
	// Instead of using global variable to store result, the more common way to store the result is to create another function which calls the inorderTraversal
	// Time Complexity O(n), go through every node once
	// Space Complexity O(n), recursion, worst when tree is linkedlist
	public void inorder(TreeNode root, List<Integer> res) {
		if (root == null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorderTraversal(root.right, res);
	}

    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> res = new ArrayList();
        inorder(res);
        return res;
    }


    // Solution - 2 Morris Traverse --> Advanced inorder traversal
    // TODO
}