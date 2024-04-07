package problems.c0easy.t1t500;

/**
 * 110 平衡二叉树 https://leetcode.cn/problems/balanced-binary-tree/
 * 给定一个二叉树，判断其是否高度平衡
 * 高度平衡二叉树：每个节点的左右两个子树的高度差绝对值不超过1
 *
 * 示例：
 * 输入1：root = [3,9,20,null,null,15,7]
 * 输出1：true
 *
 * 输入2：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 *
 * 输入3：root = []
 * 输出3：true
 */
public class T110 {
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
     * 官方解法1：自顶向下递归
     * 计算每一个节点的左右子树高度，判断其是否平衡，再递归遍历其左右节点
     */
    public boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height1(root.left) - height1(root.right)) <= 1
                    && isBalanced1(root.left) && isBalanced1(root.right);
        }
    }

    public int height1(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height1(root.left), height1(root.right)) + 1;
        }
    }

    /**
     * 官方解法2：自底向上递归
     * 类似后序遍历，对于当前遍历到的节点，先递归地判断其左右子树是否平衡，再判断以当前节点为根的子树是否平衡
     * 如果一课子树是平衡的，则返回其高度（高度一定是非负整数），否则返回-1
     * 如果存在一棵子树不平衡，则整个二叉树一定不平衡
     */
    public boolean isBalanced2(TreeNode root) {
        return height2(root) >= 0;
    }

    public int height2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height2(root.left);
        int rightHeight = height2(root.right);

        if (leftHeight == 1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
