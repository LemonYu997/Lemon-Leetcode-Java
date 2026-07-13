package problems.c0easy.t3501t4000;

/**
 * 3750 最少翻转次数得到反转二进制字符串 https://leetcode.cn/problems/minimum-number-of-flips-to-reverse-binary-string/description/
 * 给你一个 正 整数 n。
 * 令 s 为 n 的 二进制表示（不含前导零）。
 * 二进制字符串 s 的 反转 是指将 s 中的字符按相反顺序排列得到的字符串。
 * 你可以翻转 s 中的任意一位（将 0 → 1 或 1 → 0）。每次翻转 仅 影响一位。
 * 请返回使 s 等于其原始形式的反转所需的 最少 翻转次数。
 *
 * 示例：
 * 输入1：n = 7
 * 输出1：0
 *
 * 输入2：n = 10
 * 输出2：4
 */
public class T3750 {
    /**
     * 自己实现：根据题意模拟
     */
    public int minimumFlips(int n) {
        String s = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();

        int ans = 0;
        // 对比和原字符串的不同次数
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != sb.charAt(i)) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 社区解法：位运算
     */
    public int minimumFlips1(int n) {
        int rev = Integer.reverse(n) >>> Integer.numberOfLeadingZeros(n);
        return Integer.bitCount(n ^ rev);
    }
}
