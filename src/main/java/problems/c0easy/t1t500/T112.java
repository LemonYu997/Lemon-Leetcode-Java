package problems.c0easy.t1t500;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 112 路径总和 https://leetcode.cn/problems/path-sum/
 * 给定一个二叉树的根节点root和一个表示 目标和 整数tarhetSum，判断该树中是否存在根节点到叶子节点的路径
 * 这个路径上所有的节点值相加等于目标和 targetSum，如果存在返回true，不存在返回false
 * <p>
 * 示例：
 * 输入1：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出1：true
 * 备注：5+4+11+2 = 22
 * <p>
 * 输入2：root = [1,2,3], targetSum = 5
 * 输出2：false
 * <p>
 * 输入3：root = [], targetSum = 0
 * 输出3：0
 */
public class T112 {
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
     * 官方解法1：广度优先搜索 BFS
     */
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queNode = new LinkedList<>();
        Queue<Integer> queVal = new LinkedList<>();
        queNode.offer(root);
        queVal.offer(root.val);

        while (!queNode.isEmpty()) {
            TreeNode now = queNode.poll();
            int temp = queVal.poll();
            if (now.left == null && now.right == null) {
                if (temp == targetSum) {
                    return true;
                }
                continue;
            }

            if (now.left != null) {
                queNode.offer(now.left);
                queVal.offer(now.left.val + temp);
            }

            if (now.right != null) {
                queNode.offer(now.right);
                queVal.offer(now.right.val + temp);
            }
        }

        return false;
    }

    /**
     * 官方解法2：递归
     */
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        return hasPathSum2(root.left, targetSum - root.val) || hasPathSum2(root.right, targetSum - root.val);
    }
}
