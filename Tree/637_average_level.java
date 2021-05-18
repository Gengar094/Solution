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
    public List<Double> averageOfLevels(TreeNode root) {
        // BFS --> 分层遍历
        // 如何知道每一层的个数？26行，在遍历前计算当前层的个数，然后在遍历时加入下一层的元素
        List<Double> res = new ArrayList();
        if (root == null) return res;

        // 在java 中， Queue由linkedlist实现
        Queue<TreeNode> q = new LinkedList();
        // Queue中一般用offer和poll来添加，删除元素，用peek可以查看头部元素
        // add和remove也可以用，但是不安全
        q.offer(root);
        while (q.size() > 0){
            int len = q.size(); 
            double avg = 0;
            for (int i = 0; i < len; i++) {
                TreeNode node = q.poll();
                avg += node.val;
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            res.add(avg/len);
        }

        return res;

    } 
}