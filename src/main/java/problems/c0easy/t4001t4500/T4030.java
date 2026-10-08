package problems.c0easy.t4001t4500;

/**
 * 4030 判断 ASCII 值回文 https://leetcode.cn/problems/check-ascii-palindromic/description/
 * 给你一个由小写英文字母组成的字符串 s。
 * 将 s 中的每个字符替换为其 ASCII 值对应的 8 位二进制表示，包括前导零，并保持字符原有顺序，从而构造一个二进制字符串。
 * 如果得到的二进制字符串是一个 回文串 ，则返回 true；否则返回 false。
 * 二进制字符串 是指仅由字符 '0' 和 '1' 组成的字符串。
 * 回文串 是指正着读和反着读都相同的字符串。
 *
 * 示例：
 * 输入1：s = "ff"
 * 输出1：true
 *
 * 输入2：s = "leet"
 * 输出2：false
 */
public class T4030 {
    /**
     * 社区解法：转为字符串
     */
    public boolean isPalindromic(String s) {
        char[] chars = s.toCharArray();
        StringBuilder t = new StringBuilder(chars.length * 8);
        for (char ch : chars) {
            t.append(String.format("%8s", Integer.toBinaryString(ch)).replace(' ', '0'));
        }

        int n = t.length();
        for (int i = 0; i < n / 2; i++) {
            if (t.charAt(i) != t.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }


    private static final int m0 = 0b01010101;
    private static final int m1 = 0b00110011;
    private static final int m2 = 0b00001111;

    private int reverseBits(int n) {
        n = n >> 1 & m0 | (n & m0) << 1; // 交换相邻位
        n = n >> 2 & m1 | (n & m1) << 2; // 两个两个交换
        return n >> 4 | (n & m2) << 4;   // 交换高低 4 位
    }

    public boolean isPalindromic1(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i <= n / 2; i++) {
            if (reverseBits(chars[i]) != chars[n - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}