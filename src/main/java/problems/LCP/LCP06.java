package problems.LCP;

/**
 * LCP06 拿硬币 https://leetcode.cn/problems/na-ying-bi/description/
 * 桌上有 n 堆力扣币，每堆的数量保存在数组 coins 中。
 * 我们每次可以选择任意一堆，拿走其中的一枚或者两枚，求拿完所有力扣币的最少次数。
 *
 * 示例：
 * 输入1：[4,2,1]
 * 输出1：4
 *
 * 输入2：[2,3,10]
 * 输出2：8
 */
public class LCP06 {
    /**
     * 自己实现：根据题意模拟即可
     */
    public int minCount(int[] coins) {
        int ans = 0;

        for (int coin : coins) {
            ans += coin / 2;
            // 优先每次取2个，如果取不尽再取1次1个
            if (coin % 2 != 0) {
                ans++;
            }
        }
        return ans;
    }


    /**
     * 官方解法：优化写法
     */
    public int minCount1(int[] coins) {
        int sum = 0;
        for (int coin : coins) {
            sum += (coin + 1) / 2;
        }
        return sum;
    }
}
