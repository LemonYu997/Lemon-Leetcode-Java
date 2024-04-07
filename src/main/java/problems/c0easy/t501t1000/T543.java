package problems.c0easy.t501t1000;

/**
 * 543 二叉树的直径 https://leetcode.cn/problems/diameter-of-binary-tree/
 * 返回二叉树的直径：任意两个节点之间的最长路径长度
 * 示例：
 * 输入1：root = [1,2,3,4,5]
 * 输出1:3
 * 备注：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
 *
 * 输入2：root = [1,2]
 * 输出2：1
 */
public class T543 {
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

    int ans;

    /**
     * 官方解法：深度优先搜索
     */
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return  0;
        }
        //左子树深度
        int L = depth(node.left);
        //右子树深度
        int R = depth(node.right);
        //更新结果
        ans = Math.max(ans, L + R + 1);
        //返回该节点的深度
        return Math.max(L, R) + 1;
    }
}
