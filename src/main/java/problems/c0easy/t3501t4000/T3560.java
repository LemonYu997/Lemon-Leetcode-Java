package problems.c0easy.t3501t4000;

/**
 * 3560 木材运输的最小成本 https://leetcode.cn/problems/find-minimum-log-transportation-cost/description/
 * 给你三个整数 n、m 和 k。
 * 有两根长度分别为 n 和 m 单位的木材，需要通过三辆卡车运输。
 * 每辆卡车最多只能装载一根长度 不超过 k 单位的木材。
 * 你可以将木材切成更小的段，其中将长度为 x 的木材切割成长度为 len1 和 len2
 * 的段的成本为 cost = len1 * len2，并且满足 len1 + len2 = x。
 * 返回将木材分配到卡车上的 最小总成本 。如果木材不需要切割，总成本为 0。
 *
 * 示例：
 * 输入1：n = 6, m = 5, k = 5
 * 输出1：5
 *
 * 输入2：n = 4, m = 4, k = 6
 * 输出2：0
 */
public class T3560 {
    /**
     * 自己实现：超出的部分需要被切割
     */
    public long minCuttingCost(int n, int m, int k) {
        // 只会分成两段，因此 n 和 m 都不会超过 2k
        long ans = 0;
        if (n > k) {
            ans += (long) (n - k) * k;
        }
        if (m > k) {
            ans += (long) (m - k) * k;
        }
        return ans;
    }

    /**
     * 社区解法：优化写法
     */
    public long minCuttingCost1(int n, int m, int k) {
        return Math.max((long) k * (Math.max(n, m) - k), 0);
    }
}