package demo.c0easy;

/**
 * 572 另一棵树的子树 https://leetcode.cn/problems/subtree-of-another-tree/
 * 给定两棵二叉树root和subRoot，检验root中是否包含和subRoot具有相同结构和节点值的子树
 * 如果存在返回true，否则返回false
 *
 * 示例：
 * 输入1：root = [3,4,5,1,2], subRoot = [4,1,2]
 * 输出1：true
 *
 * 输入2：root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
 * 输出2：false
 */
public class T572 {
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
     * 官方解法1：深度优先搜索和暴力匹配
     * 枚举root中的每一个节点，判断其子树是否与subRoot相等
     * 判断是否相等需要再做一次深度优先搜索，需要同步遍历
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot);
    }

    /**
     * DFS，判断每个节点处的子树是否与目标树一致
     */
    public boolean dfs(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        return check(root, subRoot) || dfs(root.left, subRoot) || dfs(root.right, subRoot);
    }

    /**
     * DFS判断两棵树是否完全相等，同步遍历
     */
    public boolean check(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null || root.val != subRoot.val) {
            return false;
        }

        return check(root.left, subRoot.left) && check(root.right, subRoot.right);
    }
}
