package problems.c0easy.t3001t3500;

/**
 * 3461 判断操作后字符串中的数字是否相等 I https://leetcode.cn/problems/check-if-digits-are-equal-in-string-after-operations-i/description/
 * 给你一个由数字组成的字符串 s 。重复执行以下操作，直到字符串恰好包含 两个 数字：
 * 从第一个数字开始，对于 s 中的每一对连续数字，计算这两个数字的和 模 10。
 * 用计算得到的新数字依次替换 s 的每一个字符，并保持原本的顺序。
 * 如果 s 最后剩下的两个数字 相同 ，返回 true 。否则，返回 false。
 *
 * 示例：
 * 输入1：s = "3902"
 * 输出1：true
 *
 * 输入2：s = "34789"
 * 输出2：false
 */
public class T3461 {
    /**
     * 官方解法：根据题意模拟
     */
    public boolean hasSameDigits(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        for (int i = 1; i <= n - 2; i++) {
            for (int j = 0; j <= n - 1 - i; j++) {
                int digit1 = chars[j] - '0';
                int digit2 = chars[j + 1] - '0';
                chars[j] = (char) (((digit1 + digit2) % 10) + '0');
            }
        }
        return chars[0] == chars[1];
    }
}
