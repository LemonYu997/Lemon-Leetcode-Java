package problems.c0easy.t501t1000;

import java.util.ArrayList;
import java.util.List;

/**
 * T501 二叉搜索树中的众数 https://leetcode.cn/problems/find-mode-in-binary-search-tree/
 * 给定一个含重复值的二叉搜索树（BST）的根节点root，找出并返回BST中的所有众数
 * 如果树中不止一个众数，可以按任意顺序返回
 *
 * 示例：
 * 输入1：root = [1,null,2,2]
 * 输出1:[2]
 *
 * 输入2：root = [0]
 * 输出2：[0]
 */
public class T501 {
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

    List<Integer> ans = new ArrayList<>();
    int base = 0;
    int count = 0;
    int maxCount = 0;

    /**
     * 中序遍历：即为一个有序数组
     */
    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] mode = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            mode[i] = ans.get(i);
        }
        return mode;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        update(node.val);
        dfs(node.right);
    }

    public void update(int x) {
        if (x == base) {
            count++;
        } else {
            count = 1;
            base = x;
        }
        if (count == maxCount) {
            ans.add(base);
        }
        if (count > maxCount) {
            maxCount = count;
            ans.clear();
            ans.add(base);
        }
    }
}
