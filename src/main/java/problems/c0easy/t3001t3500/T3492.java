package problems.c0easy.t3001t3500;

/**
 * 3492 船上可以装载的最大集装箱数量 https://leetcode.cn/problems/maximum-containers-on-a-ship/description/
 * 给你一个正整数 n，表示船上的一个 n x n 的货物甲板。甲板上的每个单元格可以装载一个重量 恰好 为 w 的集装箱。
 * 然而，如果将所有集装箱装载到甲板上，其总重量不能超过船的最大承载重量 maxWeight。
 * 请返回可以装载到船上的 最大 集装箱数量。
 *
 * 示例：
 * 输入1：n = 2, w = 3, maxWeight = 15
 * 输出1：4
 *
 * 输入2：n = 3, w = 5, maxWeight = 20
 * 输出2：4
 */
public class T3492 {
    /**
     * 自己实现：根据题意模拟
     */
    public int maxContainers(int n, int w, int maxWeight) {
//        int maxCount = n * n;
//        int real = maxWeight / w;
//        return Math.min(real, maxCount);

        // 再简化
        return Math.min(maxWeight / w, n * n);
    }
}
