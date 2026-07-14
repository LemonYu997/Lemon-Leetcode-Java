package problems.c0easy.t3501t4000;

/**
 * 3754 连接非零数字并乘以其数字和 I https://leetcode.cn/problems/concatenate-non-zero-digits-and-multiply-by-sum-i/description/
 * 给你一个整数 n。
 * 将 n 中所有的 非零数字 按照它们的原始顺序连接起来，形成一个新的整数 x。如果不存在 非零数字 ，则 x = 0。
 * sum 为 x 中所有数字的 数字和 。
 * 返回一个整数，表示 x * sum 的值。
 *
 * 示例：
 * 输入1：n = 10203004
 * 输出1：12340
 *
 * 输入2：n = 1000
 * 输出2：1
 */
public class T3754 {
    /**
     * 自己实现：根据题意模拟
     */
    public long sumAndMultiply(int n) {
        if (n == 0) {
            return 0;
        }
        // 新的数字
        String numS = String.valueOf(n).replace("0", "");
        long num = Long.parseLong(numS);
        // 新的数字和
        long temp = num;
        long sum = 0;
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }

        return num * sum;
    }

    public long sumAndMultiply1(int n) {
        long x = 0;
        long sum = 0;
        String s = String.valueOf(n);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int d = c - '0';
            sum += d;
            if (d > 0) {
                x = x * 10 + d;
            }
        }
        return x * sum;
    }
}
