package hello.c1algorithm.p3Backtracking;

import hello.c0datastructure.p3Tree.TreeNode;

import java.util.List;

/**
 * 回溯算法，经典例题：
 * 1、搜索问题：找到满足特定条件的解决方案
 *  全排列问题：给定一个集合，求出其所有可能得排列组合
 *  子集和问题：给定一个集合和一个目标和，找到集合中所有和为目标和的子集
 *  汉诺塔问题
 * 2、约束满足问题：找到满足所有约束条件的解
 *  n皇后：在 n * n 的棋盘上放置 n 个皇后，使得他们不相互攻击
 *  数独：在 9 * 9 的网格中填入数字 1 ~ 9，使得每行、每列和每个 3 * 3 子网格中的数字不重复
 *  图着色问题：给定一个无向图，用最少得颜色给每个顶点着色，使得相邻顶点颜色不同
 * 3、组合优化问题：在一个组合空间中找到满足某些条件的最优解
 *  0-1背包问题：给定一组物品和一个背包，每个物品有一定的价值，要求在背包容量范围内使得选择物品价值最大
 *  旅行商问题：在一个图中，从一个点出发，访问所有其他点恰好一次后返回起点，求最短路径
 *  最大团问题：给定一个无向图，找到最大的完全子图，即子图中的任意两个顶点之间都有边相连
 */
public class Demo0Backtracking {
    /**
     * 算法框架：包含尝试、回退、剪枝
     * 例题：在二叉树中搜索所有值为 7 的节点，请返回根节点到这些节点的路径，并要求路径中不包含值为 3 的节点。
     * @param state 表示问题的当前状态，这里为节点遍历路径
     * @param choices 表示当前状态下可以做出的选择，这里为选择当前节点的左子结点或右子节点
     * @param res 存储结果，这里是路径列表
     */
    void backtrack(List<TreeNode> state, List<TreeNode> choices, List<List<TreeNode>> res) {
        // 判断是否为解
        if (isSolution(state)) {
            // 记录解
            recordSolution(state, res);
            // 根据题目判断是否还要继续搜索，这里有可能 7 的节点的子节点仍旧有 7
//            return;
        }
        // 遍历所有选择
        for (TreeNode choice : choices) {
            // 剪枝，判断选择是否合法
            if (isValid(state, choice)) {
                // 尝试：做出选择，更新状态
                makeChoice(state, choice);
                backtrack(state, choices, res);
                // 回退：撤销选择，恢复到之前的状态
                undoChoice(state, choice);
            }
        }
    }

    /**
     * 判断当前状态是否为解
     */
    boolean isSolution(List<TreeNode> state) {
        // 节点遍历路径不为空且当前节点值为 7
        return !state.isEmpty() && state.get(state.size() - 1).val == 7;
    }

    /**
     * 记录解
     */
    void recordSolution(List<TreeNode> state, List<List<TreeNode>> res) {
        res.add(state);
    }

    /**
     * 判断当前状态下，选择是否合法
     * 不合法会被剪枝
     */
    boolean isValid(List<TreeNode> state, TreeNode choice) {
        // 没有遍历到结尾且当前节点值不能为3
        return choice != null && choice.val != 3;
    }

    /**
     * 更新状态
     */
    void makeChoice(List<TreeNode> state, TreeNode choice) {
        // 遍历路径记录当前节点值
        state.add(choice);
    }

    /**
     * 恢复状态
     */
    void undoChoice(List<TreeNode> state, TreeNode choice) {
        // 移除当前节点
        state.remove(state.size() - 1);
    }
}
