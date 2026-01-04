package problems.c0easy.t3001t3500;

/**
 * 3099 哈沙德数 https://leetcode.cn/problems/harshad-number/description/
 * 如果一个整数能够被其各个数位上的数字之和整除，则称之为 哈沙德数（Harshad number）。
 * 给你一个整数 x 。如果 x 是 哈沙德数 ，则返回 x 各个数位上的数字之和，否则，返回 -1 。
 *
 * 输入1：x = 18
 * 输出1：9
 *
 * 输入2：x = 23
 * 输出2：-1
 */
public class T3099 {
    /**
     * 自己实现：根据题意模拟
     */
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int temp = x;
        int sum = 0;

        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }

        if (temp % sum == 0) {
            return sum;
        } else {
            return -1;
        }
    }

    /**
     * 自己实现：根据题意模拟
     */
    public int sumOfTheDigitsOfHarshadNumber1(int x) {
        int s = 0;
        for (int y = x; y != 0; y /= 10) {
            s += y % 10;
        }
        return x % s != 0 ? -1 : s;
    }
}