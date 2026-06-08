package problems.c0easy.t3501t4000;

/**
 * 3622 判断整除性 https://leetcode.cn/problems/check-divisibility-by-digit-sum-and-product/description/
 * 给你一个正整数 n。请判断 n 是否可以被以下两值之和 整除：
 * n 的 数字和（即其各个位数之和）。
 * n 的 数字积（即其各个位数之积）。
 * 如果 n 能被该和整除，返回 true；否则，返回 false。
 *
 * 示例：
 * 输入1：n = 99
 * 输出1：true
 *
 * 输入2：n = 23
 * 输出2：false
 */
public class T3622 {
    /**
     * 自己实现：根据题意模拟
     */
    public boolean checkDivisibility(int n) {
        int num = n;
        int a = 0;
        int b = 1;

        while (num > 0) {
            int temp = num % 10;
            a += temp;
            b *= temp;
            num /= 10;
        }

        return n % (a + b) == 0;
    }
}
