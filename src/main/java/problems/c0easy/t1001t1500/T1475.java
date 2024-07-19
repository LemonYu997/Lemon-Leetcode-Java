package problems.c0easy.t1001t1500;

/**
 * 1475 商品折扣后的最终价格 https://leetcode.cn/problems/final-prices-with-a-special-discount-in-a-shop/description/
 * 给你一个数组 prices ，其中 prices[i] 是商店里第 i 件商品的价格。
 * 商店里正在进行促销活动，如果你要买第 i 件商品，那么你可以得到与 prices[j] 相等的折扣，
 * 其中 j 是满足 j > i 且 prices[j] <= prices[i] 的 最小下标 ，如果没有满足条件的 j ，你将没有任何折扣。
 * 请你返回一个数组，数组中第 i 个元素是折扣后你购买商品 i 最终需要支付的价格。
 *
 * 示例：
 * 输入1：prices = [8,4,6,2,3]
 * 输出1：[4,2,4,2,3]
 *
 * 输入2：prices = [1,2,3,4,5]
 * 输出2：[1,2,3,4,5]
 *
 * 输入3：prices = [10,1,1,6]
 * 输出3：[9,0,1,6]
 */
public class T1475 {
    /**
     * 自己实现：根据题意模拟
     */
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = prices[i];
            for (int j = i + 1; j < n; j++) {
                if (prices[j] <= prices[i]) {
                    ans[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        return ans;
    }
}
