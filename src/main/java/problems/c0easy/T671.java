package problems.c0easy;

/**
 * 671 二叉树中第二小的节点 https://leetcode.cn/problems/second-minimum-node-in-a-binary-tree/
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。
 * 如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 * 更正式地说，即 root.val = min(root.left.val, root.right.val) 总成立。
 * 给出这样的一个二叉树，你需要输出所有节点中的 第二小的值 。
 * 如果第二小的值不存在的话，输出 -1 。
 *
 * 示例：
 * 输入1：root = [2,2,5,null,null,5,7]
 * 输出1：5
 * 备注：最小的值是 2 ，第二小的值是 5 。
 *
 * 输入1：root = [2,2,2]
 * 输出1：-1
 * 备注：最小的值是 2, 但是不存在第二小的值。
 */
public class T671 {
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
     * 官方解法：找到比根节点大的最小值即可
     */
    int ans;
    int rootvalue;
    public int findSecondMinimumValue(TreeNode root) {
        ans = -1;
        rootvalue = root.val;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        // 当前节点值比最小值大的直接跳过
        if (ans != -1 && node.val > ans) {
            return;
        }
        if (node.val > rootvalue) {
            ans = node.val;
        }
        dfs(node.left);
        dfs(node.right);
    }
}
