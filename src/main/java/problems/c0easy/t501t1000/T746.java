package problems.c0easy.t501t1000;

/**
 * 746 使用最小花费爬楼梯 https://leetcode.cn/problems/min-cost-climbing-stairs/
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。
 * 一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * 请你计算并返回达到楼梯顶部的最低花费。
 *
 * 示例：
 * 输入1：cost = [10,15,20]
 * 输出1：15
 * 备注：从下标为 1 的台阶开始。支付 15 ，向上爬两个台阶，到达楼梯顶部。
 * 总花费为 15 。
 *
 * 输入2：cost = [1,100,1,1,1,100,1,1,100,1]
 * 输出2：6
 * 备注：你将从下标为 0 的台阶开始。
 * - 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达楼梯顶部。
 * 总花费为 6 。
 */
public class T746 {
    /**
     * 官方解法：动态规划
     * 设数组 cost 长度为 n，每个阶梯分别对应下标 0 ~ n - 1，楼层顶部对应下标 n。
     * 创建长度为 n + 1 的数组 dp，其中 dp[i] 表示到达下标 i 的最小花费
     * 因为可以选择 0 或 1 作为起始台阶，可以设置 dp[0] = dp[1] = 0
     * 在 2 <= i <= n 之间，因为可以一次走一步或两步，所以需要从两次中选择最小值
     * dp[i] = min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2])
     * 最后求得 dp[n]
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp [0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[n];
    }

    /**
     * 优化上述写法，使用滚动数组，不必实际创建 dp[n + 1]
     */
    public int minCostClimbingStairs1(int[] cost) {
        int n = cost.length;
        int prev = 0;
        int curr = 0;
        for (int i = 2; i <= n; i++) {
            int next = Math.min(curr + cost[i - 1], prev + cost[i - 2]);
            prev = curr;
            curr = next;
        }
        return curr;
    }

}
