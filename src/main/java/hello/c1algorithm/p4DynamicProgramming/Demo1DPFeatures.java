package hello.c1algorithm.p4DynamicProgramming;

/**
 * 动态规划问题特性
 * 1、最优子结构：原问题的最优解是从子问题的最优解构建得来的
 *  例题：爬楼梯最小代价
 * 2、无后效性：给定一个确定的状态，它的未来发展只与当前状态有关，与过去经历的所有状态无关
 *  例题：爬楼梯问题只用考虑当前爬 1 阶还是 2 阶，而不用考虑之前的选择
 *  反例：如带约束爬楼梯问题，不满足无后效性
 */
public class Demo1DPFeatures {
    /**
     * 最优子结构：爬楼梯最小代价
     * 给定一个楼梯，你每步可以上 1 阶或者 2 阶，每一阶楼梯上都贴有一个非负整数，
     * 表示你在该台阶所需要付出的代价。给定一个非负整数数组 cost[] ，
     * 其中 cost[i] 表示在第 i 个台阶需要付出的代价，cost[0] 为地面（起始点）。
     * 请计算最少需要付出多少代价才能到达顶部？
     */
    int minCostClimbingStairsDP(int[] cost) {
        int n = cost.length - 1;
        if (n == 1 || n == 2) {
            return cost[n];
        }
        // 初始化 dp 表，用于存储子问题的解
        int[] dp = new int[n + 1];
        // 初始状态：预设最小子问题的解
        dp[1] = cost[1];
        dp[2] = cost[2];
        // 状态转移：从较小子问题逐步求解较大子问题
        for (int i = 3; i <= n; i++) {
            // 每一步都选择最优结果
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return dp[n];
    }

    /**
     * 使用滚动数组优化空间复杂度
     */
    int minCostClimbingStairsDPComp(int[] cost) {
        int n = cost.length - 1;
        if (n == 1 || n == 2) {
            return cost[n];
        }
        int a = cost[1];
        int b = cost[2];
        for (int i = 3; i <= n; i++) {
            int tmp = b;
            b = Math.min(a, tmp) + cost[i];
            a = tmp;
        }
        return b;
    }

    /**
     * 带约束爬楼梯问题
     * 给定一个共有 n 阶的楼梯，每步可以上 1 阶或者 2 阶，但不能连续两轮跳 1 阶，请问有多少种方案可以爬到楼顶？
     * 将状态扩展，使用 dp[i,j] 表示处在第 i 阶，并且上一轮跳了 j 阶，根据题意则：
     * dp[i, 1] = dp[i-1, 2]
     * dp[i, 2] = dp[i-2, 1] + dp[i-2, 2]
     */
    int climbingStairsConstrainDP(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        // 初始化
        int[][] dp = new int[n + 1][3];
        // 初始状态：预设最小子问题的解
        dp[1][1] = 1;
        dp[1][2] = 0;
        dp[2][1] = 0;
        dp[2][2] = 1;
        // 状态转移：从较小子问题逐步求解较大子问题
        for (int i = 3; i <= n; i++) {
            dp[i][1] = dp[i - 1][2];
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
        }
        return dp[n][1] + dp[n][2];
    }
}
