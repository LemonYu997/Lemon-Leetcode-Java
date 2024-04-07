package problems.c0easy.t501t1000;

/**
 * 783 二叉搜索树节点最小距离 https://leetcode.cn/problems/minimum-distance-between-bst-nodes/
 * 给定一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * 差值是一个正数，其数值等于两值之差的绝对值。
 *
 * 示例：
 * 输入1：root = [4,2,6,1,3]
 * 输出1：1
 *
 * 输入2：root = [1,0,48,null,null,12,49]
 * 输出2：1
 */
public class T783 {
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
     * 官方解法：利用二叉搜索树中序遍历为有序数组的性质
     * 即求相邻两节点差的最小值
     */
    int pre;
    int ans;
    public int minDiffInBST(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        // 中序遍历 左 -> 根 -> 右
        dfs(root.left);
        // 如果是初始根节点，赋值
        if (pre == -1) {
            pre = root.val;
        } else {
            // 当前节点值 > 上一个节点值
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }
}
