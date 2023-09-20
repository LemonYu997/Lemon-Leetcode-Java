package demo.c0easy;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 144 二叉树的前序遍历 https://leetcode.cn/problems/binary-tree-preorder-traversal/、
 * 返回二叉树的前序遍历
 * 前序遍历：根节点——左子树——右子树
 *
 * 示例：
 * 输入1：root = [1,null,2,3]
 * 输出1：[1,2,3]
 *
 * 输入2：root = []
 * 输出2：[]
 *
 * 输入3：root = [1]
 * 输出3：[1]
 *
 * 输入4：root = [1,2]
 * 输出4：[1,2]
 *
 * 输入5：root = [1,null,2]
 * 输出5：[1,2]
 */
public class T144 {
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
     * 官方解法1：递归
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        perorder(root, res);
        return res;
    }

    public void perorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        //先添加左子树，再添加右子树
        perorder(root.left, res);
        perorder(root.right, res);
    }

    /**
     * 官方解法2：迭代 思路与递归一致，只是使用栈
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;

        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            node = node.right;
        }

        return res;
    }
}
