package demo.c0easy;

/**
 * 606 根据二叉树创建字符串 https://leetcode.cn/problems/construct-string-from-binary-tree/
 * 使用前序遍历，将二叉树转为一个由括号和整数组成的字符串，空节点用空括号表示，
 * 转化完后省略所有不影响字符串与原始二叉树之间的一对一映射关系
 *
 * 示例：
 * 输入1：root = [1,2,3,4]
 * 输出1："1(2(4))(3)"
 *
 * 输入2：root = [1,2,3,null,4]
 * 输出2："1(2()(4))(3)"
 */
public class T606 {
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
     * 自己实现：递归
     */
    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        if (root.left == null && root.right == null) {
            return Integer.toString(root.val);
        }
        if (root.right == null) {
            return new StringBuffer().append(root.val).append("(").append(tree2str(root.left)).append(")").toString();
        }
        return new StringBuffer().append(root.val).append("(").append(tree2str(root.left)).append(")(").append(tree2str(root.right)).append(")").toString();

    }
}
