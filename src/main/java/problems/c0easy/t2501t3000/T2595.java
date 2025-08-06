package problems.c0easy.t2501t3000;

/**
 * 2595 奇偶位数 https://leetcode.cn/problems/number-of-even-and-odd-bits/description/
 * 给你一个 正 整数 n 。
 * 用 even 表示在 n 的二进制形式（下标从 0 开始）中值为 1 的偶数下标的个数。
 * 用 odd 表示在 n 的二进制形式（下标从 0 开始）中值为 1 的奇数下标的个数。
 * 请注意，在数字的二进制表示中，位下标的顺序 从右到左。
 * 返回整数数组 answer ，其中 answer = [even, odd] 。
 *
 * 示例：
 * 输入1：n = 50
 * 输出1：[1,2]
 *
 * 输入2：n = 2
 * 输出2：[0,1]
 */
public class T2595 {
    /**
     * 自己实现：根据题意模拟
     */
    public int[] evenOddBit(int n) {
        String binaryString = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder(binaryString);
        String s = sb.reverse().toString();
        int len = binaryString.length();
        int[] ans = new int[2];

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '1' && i % 2 == 0) {
                ans[0]++;
            }
            if (s.charAt(i) == '1' && i % 2 != 0) {
                ans[1]++;
            }
        }

        return ans;
    }

    /**
     * 官方解法：优化写法
     */
    public int[] evenOddBit1(int n) {
        int[] ans = new int[2];
        int i = 0;
        while (n > 0) {
            ans[i] += n & 1;
            n >>= 1;
            i ^= 1;
        }
        return ans;
    }
}