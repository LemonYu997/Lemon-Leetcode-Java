package problems.c0easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104 二叉树的最大深度 https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 * 给定一个二叉树，返回其最大深度
 *
 * 示例：
 * 输入1：root = [3,9,20,null,null,15,7]
 * 输出1：3
 *
 * 输入2：root = [1,null,2]
 * 输出2：2
 */
public class T104 {
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
     * 先递归算出其左子树和右子树的最大深度
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth1(root.left);
            int rightHeight = maxDepth1(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    /**
     * 官方解法2：广度优先搜索 BFS
     * 层数就是最大深度
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //深度
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            //只要该层还有数据，就往下走
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }

        return ans;
    }
}
