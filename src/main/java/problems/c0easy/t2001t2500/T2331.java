package problems.c0easy.t2001t2500;

/**
 * 2331 计算布尔二叉树的值 https://leetcode.cn/problems/evaluate-boolean-binary-tree/description/
 * 给你一棵 完整二叉树 的根，这棵树有以下特征：
 * 叶子节点 要么值为 0 要么值为 1 ，其中 0 表示 False ，1 表示 True 。
 * 非叶子节点 要么值为 2 要么值为 3 ，其中 2 表示逻辑或 OR ，3 表示逻辑与 AND 。
 * 计算 一个节点的值方式如下：
 * 如果节点是个叶子节点，那么节点的 值 为它本身，即 True 或者 False 。
 * 否则，计算 两个孩子的节点值，然后将该节点的运算符对两个孩子值进行 运算 。
 * 返回根节点 root 的布尔运算值。
 * 完整二叉树 是每个节点有 0 个或者 2 个孩子的二叉树。
 * 叶子节点 是没有孩子的节点。
 *
 * 输入1：root = [2,1,3,null,null,0,1]
 * 输出1：true
 *
 * 输入2：root = [0]
 * 输出2：false
 */
public class T2331 {
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
     * 自己实现：根据题意模拟
     */
    public boolean evaluateTree(TreeNode root) {
        // 如果当前节点为叶子节点，则值为其本身
        if (root.left == null || root.right == null) {
            // 0 为 false  1 为 true
            return root.val == 1;
        }

        // 如果为非叶子节点，则进行 or 或 and 运算
        if (root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        } else {
            return evaluateTree(root.left) && evaluateTree(root.right);
        }
    }
}
