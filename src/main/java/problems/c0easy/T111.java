package problems.c0easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111 二叉树的最小深度 https://leetcode.cn/problems/minimum-depth-of-binary-tree/
 * 给定一个二叉树，找到其最小深度
 * 最小深度：根节点到最近叶子节点的最短路径上的节点数量
 * <p>
 * 示例：
 * 输入1：root = [3,9,20,null,null,15,7]
 * 输出1:2
 * <p>
 * 示例
 * 输入2：root = [2,null,3,null,4,null,5,null,6]
 * 输出2:5
 */
public class T111 {
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
     * 官方解法1：深度优先搜索 DFS
     * 遍历整棵树，记录最小深度
     */
    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int min_dept = Integer.MAX_VALUE;

        if (root.left != null) {
            min_dept = Math.min(minDepth1(root.left), min_dept);
        }

        if (root.right != null) {
            min_dept = Math.min(minDepth1(root.right), min_dept);
        }

        return min_dept + 1;
    }

    /**
     * 官方解法2：广度优先搜索 BFS
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(root, 1));

        while (!queue.isEmpty()) {
            QueueNode nodeDepth = queue.poll();
            TreeNode node = nodeDepth.node;
            int depth = nodeDepth.depth;

            if (node.left == null && node.right == null) {
                return depth;
            }
            if (node.left != null) {
                queue.offer(new QueueNode(node.left, depth +1));
            }
            if (node.right != null) {
                queue.offer(new QueueNode(node.right, depth + 1));
            }
        }

        return 0;
    }

    class QueueNode {
        TreeNode node;
        int depth;

        public QueueNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
