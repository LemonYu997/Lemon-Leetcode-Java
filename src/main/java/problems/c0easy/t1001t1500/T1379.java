package problems.c0easy.t1001t1500;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1379 找出克隆二叉树中的相同节点 https://leetcode.cn/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/description/
 * 给你两棵二叉树，原始树 original 和克隆树 cloned，
 * 以及一个位于原始树 original 中的目标节点 target。
 * 其中，克隆树 cloned 是原始树 original 的一个 副本 。
 * 请找出在树 cloned 中，与 target 相同 的节点，
 * 并返回对该节点的引用（在 C/C++ 等有指针的语言中返回 节点指针，其他语言返回节点本身）。
 * 注意：你 不能 对两棵二叉树，以及 target 节点进行更改。
 * 只能 返回对克隆树 cloned 中已有的节点的引用。
 *
 * 示例：
 * 输入1：tree = [7,4,3,null,null,6,19], target = 3
 * 输出1：3
 *
 * 输入2：tree = [7], target =  7
 * 输出2：7
 *
 * 输入3：tree = [8,null,6,null,5,null,4,null,3,null,2,null,1], target = 4
 * 输出3：4
 */
public class T1379 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 官方解法1：深度优先搜索
     */
    public final TreeNode getTargetCopy1(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) {
            return null;
        }
        if (original == target) {
            return cloned;
        }
        TreeNode left = getTargetCopy1(original.left, cloned.left, target);
        if (left != null) {
            return left;
        }
        return getTargetCopy1(original.right, cloned.right, target);
    }

    /**
     * 官方解法2：广度优先搜索
     */
    public final TreeNode getTargetCopy2(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Queue<TreeNode> q1 = new ArrayDeque<>();
        Queue<TreeNode> q2 = new ArrayDeque<>();
        q1.offer(original);
        q2.offer(cloned);

        while (q1.size() > 0) {
            TreeNode node1 = q1.poll();
            TreeNode node2 = q2.poll();
            if (node1 == target) {
                return node2;
            }
            if (node1.left != null) {
                q1.offer(node1.left);
                q2.offer(node2.left);
            }
            if (node1.right != null) {
                q1.offer(node1.right);
                q2.offer(node2.right);
            }
        }
        return null;
    }
}
