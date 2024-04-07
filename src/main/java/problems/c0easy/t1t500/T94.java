package problems.c0easy.t1t500;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 94 二叉树的中序遍历 https://leetcode.cn/problems/binary-tree-inorder-traversal/
 * 给定二叉树的节点root，返回它的中序遍历
 * 中序遍历：按照左子树——根节点——右子树的方式遍历，在访问左子树或者右子树的时候仍然按照该方式进行遍历
 * 直到遍历完整棵树为止，这种遍历天然具有递归性质
 *
 * 示例：
 * 输入1：root = [1,null,2,3]
 * 输出1：[1,3,2]
 *
 * 输入2：root = []
 * 输出2：[]
 *
 * 输入3：root = [1]
 * 输出3：[1]
 */
public class T94 {
    //定义好的树
    class TreeNode {
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
     * 官方解法1：递归
     * 定义inorder(root)表示当前遍历到的root节点答案
     * 只需要递归调用inorder(root.left)来遍历root节点的左子树，再递归调用inorder(root.right)的右子树即可
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);

        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    /**
     * 官方解法2：迭代
     * 使用一个栈来维护遍历到的数据
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        //维护一个栈
        Deque<TreeNode> stack = new LinkedList<>();

        while (root != null || !stack.isEmpty()) {
            //先从左节点开始遍历
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            //然后再遍历右节点
            root = root.right;
        }

        return res;
    }
}


