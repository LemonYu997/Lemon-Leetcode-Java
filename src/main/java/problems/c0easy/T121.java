package problems.c0easy;

/**
 * 121 买卖股票的最佳时机 https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 * 给定一个数组 prices，它的第i个元素 prices[i]表示一支给定股票第i天的价格
 * 只能选择某一天买入这只股票，并选择未来的某一个不同的日子卖出该股票，怎么买才能获得最大利润
 * 返回能获取的最大利润，不能的话返回0
 *
 * 示例：
 * 输入1：[7,1,5,3,6,4]
 * 输出1：5
 * 备注：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5
 *
 * 输入2：prices = [7,6,4,3,1]
 * 输出2:0
 */
public class T121 {
    /**
     * 自己实现：暴力求解
     * 会超时
     */
    public int maxProfit1(int[] prices) {
        //默认为0
        int max = 0;

        //买入从第一天开始遍历
        for (int i = 0; i < prices.length; i++) {
            //卖出从买入之后开始遍历
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > max) {
                    max = prices[j] - prices[i];
                }
            }
        }

        return max;
    }

    /**
     * 官方解法：只有遍历一次
     */
    public int maxProfit(int[] prices) {
        //最低点价格
        int minprice = Integer.MAX_VALUE;
        //最大利润
        int maxprofit = 0;

        for (int i = 0; i < prices.length; i++) {
            //更新最低价格
            if (prices[i] < minprice) {
                minprice = prices[i];
            //更新最大价格
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }

        return maxprofit;
    }
}
