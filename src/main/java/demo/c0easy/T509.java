package demo.c0easy;

/**
 * 509. 斐波那契数 https://leetcode.cn/problems/fibonacci-number/
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 *
 * 示例：
 * 输入1：n = 2
 * 输出1：1
 *
 * 输入2：n = 3
 * 输出2：2
 *
 * 输入3：n = 4
 * 输出3：3
 */
public class T509 {
    /**
     * 自己实现1：递归
     */
    public int fib1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int count = 0;
        count += fib1(n - 1) + fib1(n - 2);
        return count;
    }

    /**
     * 自己实现2：循环
     */
    public int fib2(int n) {
        //处理边界情况
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        //存储每一个结果
        int[] fs = new int[n + 1];
        //初始赋值
        fs[0] = 0;
        fs[1] = 1;

        for (int i = 2; i <= n; i++) {
            fs[i] = fs[i - 1] + fs[i - 2];
        }

        //最后一位即需要的值
        return fs[n];
    }

    /**
     * 官方解法1：动态规划
     * 是上边循环方法的优化写法
     */
    public int fib3(int n) {
        if (n < 2) {
            return n;
        }
        int p = 0;
        int q = 0;
        int r = 1;

        for (int i = 2; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }

        return r;
    }
}
