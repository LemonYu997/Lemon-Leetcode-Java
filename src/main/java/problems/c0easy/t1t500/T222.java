package problems.c0easy.t1t500;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 222 完全二叉树的节点个数 https://leetcode.cn/problems/count-complete-tree-nodes/
 * 给定一棵完全二叉树的根节点 root ，求出该树的节点个数。
 *
 * 示例：
 * 输入1：root = [1,2,3,4,5,6]
 * 输出1：6
 *
 * 输入2：root = []
 * 输出2：0
 *
 * 输入3：root = [1]
 * 输出3：1
 */
public class T222 {
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
     * 自己实现：BFS
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        // 使用队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ans++;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return ans;
    }

    /**
     * 自己实现：DFS
     */
    private int count = 0;
    public int countNodes1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return count;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        count++;
        dfs(root.left);
        dfs(root.right);
    }

    /**
     * 官方解法：二分查找加位运算
     * 利用完全二叉树特性
     */
    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;  //层数
        TreeNode node = root;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        // 可能得最小值和最大值 2^h ~ 2^(h+1)-1
        // 使用位运算计算幂
        int low = 1 << level;
        int high = (1 << (level + 1)) - 1;

        // 二分查找
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            // 如果该节点存在
            if (exist(root, level, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean exist(TreeNode root, int level, int k) {
        int bits = 1 << (level - 1);
        TreeNode node = root;
        // 判断路径上的每个节点是否存在
        while (node != null && bits > 0) {
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }
}
