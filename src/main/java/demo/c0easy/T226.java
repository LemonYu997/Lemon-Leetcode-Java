package demo.c0easy;

/**
 * 226 翻转二叉树 https://leetcode.cn/problems/invert-binary-tree/
 * 给定一个二叉树的根节点root，翻转这棵二叉树，并返回其根节点
 *
 * 示例：
 * 输入1：root = [4,2,7,1,3,6,9]
 * 输出1：[4,7,2,9,6,3,1]
 *
 * 输入2：root = [2,1,3]
 * 输出2：[2,3,1]
 *
 * 输入3：root = []
 * 输出3：[]
 */
public class T226 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 官方解法：递归
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //先翻转左节点
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;
        return root;
    }
}
