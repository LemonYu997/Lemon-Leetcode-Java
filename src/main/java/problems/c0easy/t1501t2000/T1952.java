package problems.c0easy.t1501t2000;

/**
 * 1952 三除数 https://leetcode.cn/problems/three-divisors/description/
 * 给你一个整数 n 。如果 n 恰好有三个正除数 ，返回 true ；否则，返回 false 。
 *
 * 如果存在整数 k ，满足 n = k * m ，那么整数 m 就是 n 的一个 除数 。
 *
 * 示例：
 * 输入1：n = 2
 * 输出1：false
 *
 * 输入2： n = 4
 * 输出2：true
 * */
public class T1952 {
    /**
     * 自己实现：遍历判断
     */
    public boolean isThree(int n) {
        int count = 0;
        // 暴力遍历
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
                if (count > 3) {
                    return false;
                }
            }
        }

        return count == 3;
    }

    /**
     * 官方解法：优化遍历次数
     * 如果 n = 1，那么结果只有1个，false
     * 如果 n > 1，那么结果最少有 2 个，n 和自身
     * 另外如果有任意 n / i = k(k != i)，那么必有 k 和 i 两个整除数，
     * 所以如果想要有三个整除数，则只能有 i * i = n，因此遍历也只需要遍历到 i * i <= n即可
     */
    public boolean isThree1(int n) {
        // 如果 n = 1，那么结果只有1个，false
        if (n == 1) {
            return false;
        }

        // 如果 n > 1，那么结果最少有 2 个，n 和自身
        boolean ans = false;
        for (int i = 2; i * i <= n; i++) {
            // 另外如果有任意 n / i = k(k != i)，那么必有 k 和 i 两个整除数，不满足条件
            if (n % i == 0 && n / i != i) {
                return false;
            }
            // 如果想要有三个整除数，则只能有 i * i = n，此时只需要判断 n 是否存在一个这样的整数 i
            if (i * i == n) {
                ans = true;
            }
        }

        return ans;
    }
}
