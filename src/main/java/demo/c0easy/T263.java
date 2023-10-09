package demo.c0easy;

/**
 * 263 丑数 https://leetcode.cn/problems/ugly-number/
 * 判断给定数n是否位丑数
 * 丑数：只包含质因数2、3、5的正整数
 *
 * 示例：
 * 输入1：n = 6
 * 输出1：true
 *
 * 输入2：n = 1
 * 输出2：true
 *
 * 输入3：n = 14
 * 输出3：false
 */
public class T263 {
    /**
     * 官方解法
     */
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }

        int[] factors = {2, 3, 5};
        //尽除2、3、5，如果最后全部除尽，结果为1
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }

        return n == 1;
    }
}
