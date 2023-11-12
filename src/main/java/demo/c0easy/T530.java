package demo.c0easy;

/**
 * 530 二叉搜索树的最小绝对差 https://leetcode.cn/problems/minimum-absolute-difference-in-bst/
 * 返回树中任意两不同节点值之间的最小差值（绝对值）
 *
 * 示例：
 * 输入1：root = [4,2,6,1,3]
 * 输出1:1
 *
 * 输入2：root = [1,0,48,null,null,12,49]
 * 输出2:1
 */
public class T530 {
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

    int pre;    //前一个节点值
    int ans;    //最小绝对差

    /**
     * 官方解法：中序遍历
     * 二叉搜索树的中序遍历是按升序排列的
     * 依次比较两个值之间的差值，找到最小的即可
     */
    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;   //初始值为-1
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        //遍历左子树
        dfs(root.left);
        //如果前一个节点没有遍历到，那就取当前节点值
        if (pre == -1) {
            pre = root.val;
        } else {
            //如果前一个节点值遍历到，计算差值并更新
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        //遍历右子树
        dfs(root.right);
    }
}
