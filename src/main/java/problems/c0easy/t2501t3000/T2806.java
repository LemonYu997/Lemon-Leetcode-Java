package problems.c0easy.t2501t3000;

/**
 * 2806 取整购买后的账户余额 https://leetcode.cn/problems/account-balance-after-rounded-purchase/description/
 * 一开始，你的银行账户里有 100 块钱。
 * 给你一个整数purchaseAmount ，它表示你在一次购买中愿意支出的金额。
 * 在一个商店里，你进行一次购买，实际支出的金额会向 最近 的 10 的 倍数 取整。换句话说，
 * 你实际会支付一个 非负 金额 roundedAmount ，满足 roundedAmount 是 10 的倍数且 abs(roundedAmount - purchaseAmount) 的值 最小 。
 * 如果存在多于一个最接近的 10 的倍数，较大的倍数 是你的实际支出金额。
 * 请你返回一个整数，表示你在愿意支出金额为 purchaseAmount 块钱的前提下，购买之后剩下的余额。
 * 注意： 0 也是 10 的倍数。
 *
 * 示例：
 * 输入1：purchaseAmount = 9
 * 输出1：90
 *
 * 输入2：purchaseAmount = 15
 * 输出2：80
 */
public class T2806 {
    /**
     * 自己实现：向上按10取整
     */
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int temp = (int) Math.round((double) purchaseAmount / 10);
        return 100 - temp * 10;
    }

    /**
     * 官方解法：简单判断
     */
    public int accountBalanceAfterPurchase1(int purchaseAmount) {
        int r = purchaseAmount % 10;
        if (r < 5) {
            purchaseAmount -= r;
        } else {
            purchaseAmount += 10 - r;
        }
        return 100 - purchaseAmount;
    }
}
