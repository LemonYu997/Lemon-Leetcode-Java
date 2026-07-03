package problems.c0easy.t3501t4000;

/**
 * 3726 移除十进制表示中的所有零 https://leetcode.cn/problems/remove-zeros-in-decimal-representation/description/
 * 给你一个正整数n。
 * 返回一个整数，该整数是将 n 的十进制表示中所有的零都移除后得到的结果。
 *
 * 示例：
 * 输入1：n = 1020030
 * 输出1：123
 *
 * 输入2：n = 1
 * 输出2：1
 */
public class T3726 {
    /**
     * 自己实现：根据题意模拟
     */
    public long removeZeros(long n) {
        String num = Long.toString(n);
        String ans = num.replaceAll("0", "");
        return Long.parseLong(ans);
    }

    /**
     * 社区解法：不用字符串
     */
    public long removeZeros1(long n) {
        long ans = 0;
        long pow10 = 1;
        while (n > 0) {
            long d = n % 10;
            if (d > 0) {
                ans += d * pow10;
                pow10 *= 10;
            }
            n /= 10;
        }
        return ans;
    }
}
