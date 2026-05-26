package problems.c0easy.t3501t4000;

import java.util.Arrays;

/**
 * 3536 两个数字的最大乘积 https://leetcode.cn/problems/maximum-product-of-two-digits/description/
 * 给定一个正整数 n。
 * 返回 任意两位数字 相乘所得的 最大 乘积。
 * 注意：如果某个数字在 n 中出现多次，你可以多次使用该数字。
 *
 * 示例：
 * 输入1：n = 31
 * 输出1：3
 *
 * 输入2：n = 22
 * 输出2：4
 *
 * 输入3：n = 124
 * 输出3：8
 */
public class T3536 {
    /**
     * 自己实现：找到最大的两个数即可
     */
    public int maxProduct(int n) {
        int mx1 = 0;
        int mx2 = 0;

        while (n > 0) {
            int temp = n % 10;
            n /= 10;
            if (temp > mx1) {
                mx2 = mx1;
                mx1 = temp;
            } else if (temp > mx2) {
                mx2 = temp;
            }
        }

        return mx1 * mx2;
    }

    /**
     * 社区解法：优化写法
     */
    public int maxProduct1(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        Arrays.sort(chars);
        int m = chars.length;
        return (chars[m - 1] - '0') * (chars[m - 2] - '0');
    }
}
