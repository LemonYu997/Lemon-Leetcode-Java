package demo.c0easy;

/**
 * 563 二叉树的坡度 https://leetcode.cn/problems/binary-tree-tilt/
 * 给定一个二叉树的根节点root，计算并返回整个树的坡度。
 * <p>
 * 一个树的节点坡度：左子树的节点之和和右子树节点之和差值的绝对值。
 * 没有左子树的话，节点之和为0，没有右子树的话，节点之后为0
 * <p>
 * 整个树的坡度就是所有节点坡度之和
 * <p>
 * 示例：
 * 输入1：root = [1,2,3]
 * 输出1：1
 * <p>
 * 输入2：root = [4,2,9,3,5,null,7]
 * 输出2:15
 * <p>
 * 输入3：root = [21,7,14,1,1,2,2,3,3]
 * 输出3:9
 */
public class T563 {
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
     * 官方解法：深度优先搜索
     */
    int ans = 0;
    public int findTilt(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int sumLeft = dfs(node.left);
        int sumRight = dfs(node.right);

        //更新差值
        ans += Math.abs(sumLeft - sumRight);
        //返回当前子树的所有节点和
        return sumLeft + sumRight + node.val;
    }
}
