package problems.c0easy.t501t1000;

import java.util.*;

/**
 * 653 两数之和 IV - 输入二叉搜索树
 * 给定一个二叉搜索树 root 和一个目标结果 k，
 * 如果二叉搜索树中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 * 示例：
 * 输入1：root = [5,3,6,2,4,null,7], k = 9
 * 输出1：true
 *
 * 输入2：root = [5,3,6,2,4,null,7], k = 28
 * 输出2：false
 */
public class T653 {
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
     * 官方解法：DFS+哈希集合
     * 假设当前节点值为 n，遍历每个节点，判断是否存在值为 k-n 的节点
     */
    Set<Integer> set = new HashSet<Integer>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        // 只要有一个找到就算 true
        return findTarget(root.left, k) || findTarget(root.right, k);
    }

    /**
     * 官方解法：BFS+哈希表
     */
    public boolean findTarget1(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (set.contains(k - node.val)) {
                return true;
            }
            set.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return false;
    }

    /**
     * 官方解法：DFS + 中序遍历 + 双指针
     * 二叉搜索树中序遍历为有序数组
     */
    List<Integer> list = new ArrayList<>();
    public boolean findTarget2(TreeNode root, int k) {
        // 中序遍历
        inorderTraversal(root);
        // 双指针遍历数组
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            // 两指针对应数值之和 = k
            if (list.get(l) + list.get(r) == k) {
                return true;
            }
            // 元素之和 < k 时，左指针右移
            if (list.get(l) + list.get(r) < k) {
                l++;
            } else {
                // 元素之和 > k 时，右指针左移
                r--;
            }
        }
        return false;
    }

    public void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
    }
}