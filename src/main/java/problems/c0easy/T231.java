package problems.c0easy;

/**
 * 231 2的幂 https://leetcode.cn/problems/power-of-two/
 * 给一个整数n，判断其是否是2的幂次方，如果是，就返回true，否则，返回false
 *
 * 示例：
 * 输入1：n = 1
 * 输出1：true
 *
 * 输入2：n = 16
 * 输出2：true
 *
 * 输入3：n = 3
 * 输出3：false
 *
 * 输入4：n = 4
 * 输出4：true
 */
public class T231 {
    /**
     * 自己实现
     */
    public boolean isPowerOfTwo1(int n) {
        //如果是2的幂，一直除以2一定为1，如果中间有其他奇数，即失败
        while (n != 1) {
            if (n % 2 == 1 || n == 0) {
                return false;
            }
            n = n / 2;
        }

        return true;
    }

    /**
     * 官方解法：位运算
     */
    public boolean isPowerOfTwo2(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }
}
