package problems.c0easy.t2501t3000;

/**
 * 2706 购买两块巧克力 https://leetcode.cn/problems/buy-two-chocolates/description/
 * 给你一个整数数组 prices ，它表示一个商店里若干巧克力的价格。
 * 同时给你一个整数 money ，表示你一开始拥有的钱数。
 * 你必须购买 恰好 两块巧克力，而且剩余的钱数必须是 非负数 。
 * 同时你想最小化购买两块巧克力的总花费。
 * 请你返回在购买两块巧克力后，最多能剩下多少钱。
 * 如果购买任意两块巧克力都超过了你拥有的钱，请你返回 money 。注意剩余钱数必须是非负数。
 *
 * 示例：
 * 输入1：prices = [1,2,2], money = 3
 * 输出1：0
 *
 * 输入2：prices = [3,2,3], money = 3
 * 输出2：3
 */
public class T2706 {
    /**
     * 自己实现：遍历取最小的两个值即可
     */
    public int buyChoco(int[] prices, int money) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < min1) {
                min2 = min1;
                min1 = price;
            } else if (price < min2) {
                min2 = price;
            }
        }

        if (money < min1 + min2) {
            return money;
        } else {
            return money - (min1 + min2);
        }
    }
}
