package problems.c0easy.t1t500;

/**
 * 326 3的幂 https://leetcode.cn/problems/power-of-three/
 * 给定一个整数，判定它是否为3的幂次方
 *
 * 示例：
 * 输入1：n = 27
 * 输出1：true
 *
 * 输入2：n = 0
 * 输出2：false
 *
 * 输入3：n = 9
 * 输出3：true
 *
 * 输入4：n = 45
 * 输出4：false
 */
public class T326 {
    /**
     * 自己实现
     */
    public boolean isPowerOfThree(int n) {
        //小于1的数肯定错误
        if (n < 1) {
            return false;
        }

        while (n > 1) {
            if (n % 3 != 0) {
                return false;
            }
            n = n / 3;
        }

        return true;
    }

    /**
     * 官方解法：优化代码
     */
    public boolean isPowerOfThree1(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
