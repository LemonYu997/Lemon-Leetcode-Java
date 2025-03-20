package problems.c0easy.t2001t2500;

/**
 * 2236 判断根结点是否等于子结点之和 https://leetcode.cn/problems/root-equals-sum-of-children/description/
 * 给你一个 二叉树 的根结点 root，该二叉树由恰好 3 个结点组成：根结点、左子结点和右子结点。
 * 如果根结点值等于两个子结点值之和，返回 true ，否则返回 false 。
 *
 * 示例：
 * 输入1：root = [10,4,6]
 * 输出1：true
 *
 * 输入2：root = [5,3,1]
 * 输出2：false
 */
public class T2236 {
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
     * 自己实现：递归
     */
    public boolean checkTree(TreeNode root) {
        // 结束条件：一路通过就意味着符号要求
        if (root.left == null || root.right == null) {
            return true;
        }
        // 不符合条件
        if (root.val != root.right.val + root.left.val) {
            return false;
        }

        // 所有子节点都必须符合条件
        return checkTree(root.left) && checkTree(root.right);
    }

    /**
     * 官方解法：注意题目，只有三个节点
     */
    public boolean checkTree1(TreeNode root) {
        return root.val == root.right.val + root.left.val;
    }
}