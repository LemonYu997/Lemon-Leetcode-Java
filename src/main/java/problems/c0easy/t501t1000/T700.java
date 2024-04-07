package problems.c0easy.t501t1000;

/**
 * 700 二叉搜索树中的搜索 https://leetcode.cn/problems/search-in-a-binary-search-tree/description/
 * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val
 * 你需要在 BST 中找到节点值等于 val 的节点。
 * 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
 *
 * 示例：
 * 输入1：root = [4,2,7,1,3], val = 2
 * 输出1：[2,1,3]
 *
 * 输入2：root = [4,2,7,1,3], val = 5
 * 输出2：[]
 */
public class T700 {
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
     * 自己实现：二叉搜索树 循环查找
     * 如果 目标值 < 当前值，查左子树
     * 如果 目标值 > 当前值，查右子树
     */
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (val < root.val) {
                root = root.left;
            } else if (val > root.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }

    /**
     * 官方解法：递归
     */
    public TreeNode searchBST1(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }

        if (val < root.val) {
            return searchBST1(root.left, val);
        } else {
            return searchBST1(root.right, val);
        }
    }
}
