package problems.c0easy.t2001t2500;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2144 打折购买糖果的最小开销 https://leetcode.cn/problems/minimum-cost-of-buying-candies-with-discount/description/
 * 一家商店正在打折销售糖果。每购买 两个 糖果，商店会 免费 送一个糖果。
 * 免费送的糖果唯一的限制是：它的价格需要小于等于购买的两个糖果价格的 较小值 。
 * 比方说，总共有 4 个糖果，价格分别为 1 ，2 ，3 和 4 ，
 * 一位顾客买了价格为 2 和 3 的糖果，那么他可以免费获得价格为 1 的糖果，但不能获得价格为 4 的糖果。
 * 给你一个下标从 0 开始的整数数组 cost ，其中 cost[i] 表示第 i 个糖果的价格，
 * 请你返回获得 所有 糖果的 最小 总开销。
 *
 * 示例：
 * 输入1：cost = [1,2,3]
 * 输出1：5
 *
 * 输入2：cost = [6,5,7,9,2,2]
 * 输出2：23
 *
 * 输入3：cost = [5,5]
 * 输出3：10
 */
public class T2144 {
    /**
     * 自己实现：根据题意模拟，先排序，然后每两个大的带一个稍微小的，直到结束为止
     */
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n = cost.length;
        int ans = 0;

        // 倒序遍历
        for (int i = n - 1; i >= 0; ) {
            // 每三个数只取最大的两个数
            if (i >= 2) {
                ans += cost[i];
                ans += cost[i - 1];
                i -= 3;
            } else {
                // 不足3个数时全都要
                ans += cost[i];
                i--;
            }
        }

        return ans;
    }

    /**
     * 官方解法：主要是用取余的思路优化，Java倒序排序损耗有点大
     */
    public int minimumCost1(int[] cost) {
        int ans = 0;
        // 倒序排序
        cost = Arrays.stream(cost)
                .boxed().sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        int n = cost.length;

        for (int i = 0; i < n; i++) {
            // 每3个数只取最大的两个
            if (i % 3 != 2) {
                ans += cost[i];
            }
        }

        return ans;
    }
}