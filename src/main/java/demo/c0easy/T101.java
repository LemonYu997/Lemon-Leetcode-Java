package demo.c0easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 101 对称二叉树 https://leetcode.cn/problems/symmetric-tree/
 * 给定一个二叉树，判断其是否轴对称
 *
 * 示例：
 * 输入1：root = [1,2,2,3,4,4,3]
 * 输出1：true
 *
 * 输入2：root = [1,2,2,null,3,null,3]
 * 输出2：false
 */
public class T101 {
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
     * 用两个指针p和q同步移动遍历该树，都从根节点出发
     * p右移时，q左移。p左移时，q右移
     * 每次移动都要检查p和q的节点值是否相等，如果相等再判断是否对称
     */
    public boolean isSymmetric1(TreeNode root) {
        return check1(root, root);
    }

    public boolean check1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val && check1(p.left, q.right) && check1(p.right, q.left);
    }

    /**
     * 官方解法2：迭代
     * 引入一个队列，初始化时把根节点入队两次，每次提取节点时比较它们的值
     * 然后将两个节点的左右子节点按相反顺序插入队中，当队列为空或者检测到不对称时，就结束
     */
    public boolean isSymmetric2(TreeNode root) {
        return check2(root, root);
    }

    public boolean check2(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(u);
        q.offer(v);

        while (!q.isEmpty()) {
            //取出前两个节点
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            //如果一个为空一个不为空，或者值不相同，就说明不对称
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            //因为每次循环都会取队列中的前两个节点，只要按相反顺序入队，就能比较对称节点是否相同
            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }

        return true;
    }
}
