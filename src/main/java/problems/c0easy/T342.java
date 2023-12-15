package problems.c0easy;

/**
 * 342 4的幂  https://leetcode.cn/problems/power-of-four/
 * 给定一个整数，判断其是否4的幂次方，如果是返回true，否则返回false
 *
 * 示例：
 * 输入1：n = 16
 * 输出1：true
 *
 * 输入2：n = 5
 * 输出2：false
 *
 * 输入3：n = 1
 * 输出3：true
 */
public class T342 {
    /**
     * 自己实现
     */
    public boolean isPowerOfFour(int n) {
        while (n > 1) {
            if (n % 4 != 0) {
                return false;
            }
            n = n / 4;
        }

        return n == 1;
    }
}
