package hello.c1algorithm.p4DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 动态规划入门
 * 问题：给定一个共有 n 阶的楼梯，你每步可以上 1 阶或者 2 阶，
 * 请问有多少种方案可以爬到楼顶？
 *
 * 常用术语：
 * 1、dp[] 表：dp[i] 表示状态 i 对应子问题的解
 * 2、初始状态：最小子问题对应的状态
 * 3、状态转移方程：递推公式 dp[i] = dp[i-1] + dp[i-2]
 */
public class Demo0DynamicProgramming {
    /**
     * 方法一：回溯解法
     */
    int climbingStairsBacktrack(int n) {
        // 可选择向上爬 1 阶或 2 阶
        List<Integer> choices = Arrays.asList(1, 2);
        // 从第 0 阶开始爬
        int state = 0;
        List<Integer> res = new ArrayList<>();
        res.add(0); // 使用 res[0]记录方案数量
        backtrack(choices, state, n, res);
        return res.get(0);
    }

    /**
     * 回溯：从地面出发，每轮选择上 1 层或 2 层，到达楼梯顶部时就将方案数量 + 1，越过顶部就剪枝
     */
    void backtrack(List<Integer> choices, int state, int n, List<Integer> res) {
        // 当爬到第 n 阶时，方案数量 + 1
        if (state == n) {
            // 使用 res[0] 存储方案数
            res.set(0, res.get(0) + 1);
        }
        // 遍历所有选择
        for (Integer choice : choices) {
            // 剪枝：不允许越过第 n 阶
            if (state + choice > n) {
                continue;
            }
            // 尝试：做出选择，更新状态
            backtrack(choices, state + choice, n, res);
        }
    }

    /**
     * 方法二：暴力搜索
     * 时间复杂度 O(2^n)
     */
    int climbingStairsDFS(int n) {
        return dfs(n);
    }

    /**
     * 假设爬到第 i 阶有 dp[i] 种方案，则：dp[i] = dp[i-1] + dp[i-2]
     */
    int dfs(int i) {
        // 已知 dp[1] 和 dp[2]，返回
        if (i == 1 || i == 2) {
            return i;
        }
        // dp[i] = dp[i-1] + dp[i-2]
        return dfs(i - 1) + dfs(i - 2);
    }

    /**
     * 方法二：记忆化搜索
     * 重叠的子问题只被计算一次，用 mem 记录每个子问题的解
     * 时间复杂度 O(n)
     */
    int climbingStairsDFSMem(int n) {
        // mem[i] 记录爬到第 i 阶的方案总数，-1 代表无记录
        int[] mem = new int[n + 1];
        Arrays.fill(mem, -1);
        return dfsMem(n, mem);
    }

    /**
     * 记忆化搜索
     */
    int dfsMem(int i, int[] mem) {
        // 已知 dp[1] 和 dp[2]，返回
        if (i == 1 || i == 2) {
            return i;
        }
        // 若存在记录 dp[i]，直接返回
        if (mem[i] != -1) {
            return mem[i];
        }
        // dp[i] = dp[i-1] + dp[i-2]
        int count = dfs(i - 1) + dfs(i - 2);
        // 记录 dp[i]
        mem[i] = count;
        return count;
    }

    /**
     * 方法三：动态规划
     * 从底至顶：从最小子问题的解开始，迭代构建更大子问题的解，直接得到原问题的解
     */
    int climbingStairsDP(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        // 初始化 dp 表，用于存储子问题的解
        int[] dp = new int[n + 1];
        // 初始状态：最小子问题的解
        dp[1] = 1;
        dp[2] = 2;
        // 状态转移：从较小子问题逐步求解较大子问题
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 滚动数组：空间优化，不需要维护一个 dp[]
     */
    int climbingStairsDPComp(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int a = 1;
        int b = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = b;
            b = a + b;
            a = tmp;
        }
        return b;
    }
}
