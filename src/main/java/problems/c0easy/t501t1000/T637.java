package problems.c0easy.t501t1000;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 637 二叉树的层平均值 https://leetcode.cn/problems/average-of-levels-in-binary-tree/description/
 * 给定一个非空二叉树的根节点root，以数组的形式返回每一层节点的平均值。
 * 与实际答案相差 10-5 以内的答案可以被接受。
 *
 * 示例：
 * 输入1：root = [3,9,20,null,null,15,7]
 * 输出1：[3.00000,14.50000,11.00000]
 *
 * 输入2：root = [3,9,20,15,7]
 * 输出2：[3.00000,14.50000,11.00000]
 */
public class T637 {
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
     * 自己实现：DFS
     */
    public List<Double> averageOfLevels(TreeNode root) {
        // 每一层个数
        List<Integer> counts = new ArrayList<>();
        // 每一层求和 使用Double避免求和之后超出 int 精度问题
        List<Double> sums = new ArrayList<>();
        // 结果
        List<Double> ans = new ArrayList<>();

        // 遍历
        dfs(0, root, counts, sums);

        // 计算结果
        for (int i = 0; i < counts.size(); i++) {
            ans.add((sums.get(i) / counts.get(i)));
        }

        return ans;
    }

    /**
     * 深度优先搜搜
     * @param level     层序
     * @param root      当前节点
     * @param counts    该层节点数
     * @param sums      该层总和
     */
    public void dfs(int level, TreeNode root, List<Integer> counts, List<Double> sums) {
        if (root == null) {
            return;
        }

        if (counts.size() > level) {
            // 总数加1
            counts.set(level, counts.get(level) + 1);
            sums.set(level, sums.get(level) + root.val);
        } else {
            // 如果该层第一次入 初始赋值
            counts.add(1);
            sums.add(1.0 * root.val);
        }

        // 遍历下一层
        dfs(level + 1, root.left, counts, sums);
        dfs(level + 1, root.right, counts, sums);
    }

    /**
     * 官方解法：BFS
     */
    public List<Double> averageOfLevels1(TreeNode root) {
        // 结果
        List<Double> ans = new ArrayList<>();
        // 使用队列进行层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 当前层的和
            double sum = 0;
            // 当前层的大小
            int size = queue.size();
            // 遍历当前层
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                // 将子节点入队
                TreeNode left = node.left;
                TreeNode right = node.right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
            ans.add(sum / size);
        }

        return ans;
    }
}
