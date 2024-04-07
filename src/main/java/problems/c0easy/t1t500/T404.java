package problems.c0easy.t1t500;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 404 左叶子之和 https://leetcode.cn/problems/sum-of-left-leaves/
 * 给定二叉树根节点root，返回所有左叶子之和
 *
 * 示例：
 * 输入1：root = [3,9,20,null,null,15,7]
 * 输出1：24
 * 备注：在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * 输入2：root=[1]
 * 输出2:0
 */
public class T404 {
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
     * 官方解法1：深度优先搜索DFS
     */
    public int sumOfLeftLeaves1(TreeNode root) {
        return root != null ? dfs(root) : 0;
    }

    public int dfs(TreeNode node) {
        int ans = 0;
        if (node.left != null) {
            ans += isLeafNode(node.left) ? node.left.val : dfs(node.left);
        }
        if (node.right != null && !isLeafNode(node.right)) {
            ans += dfs(node.right);
        }
        return ans;
    }

    //判断是否为叶子节点
    public boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

    /**
     * 官方解法2:广度优先搜索 BFS
     */
    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (isLeafNode(node.left)) {
                    ans += node.left.val;
                } else {
                    queue.offer(node.left);
                }
            }

            if (node.right != null) {
                if (!isLeafNode(node.right)) {
                    queue.offer(node.right);
                }
            }
        }

        return ans;
    }
}
