package problems.c0easy.t2501t3000;

/**
 * 2697 字典序最小回文串 https://leetcode.cn/problems/lexicographically-smallest-palindrome/description/
 * 给你一个由 小写英文字母 组成的字符串 s ，你可以对其执行一些操作。在一步操作中，你可以用其他小写英文字母 替换  s 中的一个字符。
 * 请你执行 尽可能少的操作 ，使 s 变成一个 回文串 。如果执行 最少 操作次数的方案不止一种，则只需选取 字典序最小 的方案。
 * 对于两个长度相同的字符串 a 和 b ，在 a 和 b 出现不同的第一个位置，
 * 如果该位置上 a 中对应字母比 b 中对应字母在字母表中出现顺序更早，则认为 a 的字典序比 b 的字典序要小。
 * 返回最终的回文字符串。
 *
 * 示例：
 * 输入1：s = "egcfe"
 * 输出1："efcfe"
 *
 * 输入2：s = "abcd"
 * 输出2："abba"
 *
 * 输入3：s = "seven"
 * 输出3："neven"
 */
public class T2697 {
    /**
     * 自己实现：根据题意模拟即可
     */
    public String makeSmallestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        // 比较回文对应位置的字符是否一致，不一致则取字典顺序较小的那个
        for (int i = 0; i < n / 2; i++) {
            if (chars[i] != chars[n - 1 - i]) {
                if (chars[i] < chars[n - 1 - i]) {
                    chars[n - 1 - i] = chars[i];
                } else {
                    chars[i] = chars[n - 1 - i];
                }
            }
        }

        return new String(chars);
    }

    /**
     * 官方解法：双指针
     */
    public String makeSmallestPalindrome1(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = chars.length - 1;
        while (l < r) {
            if (chars[l] != chars[r]) {
                chars[l] = chars[r] = (char) Math.min(chars[l], chars[r]);
            }
            l++;
            r--;
        }
        return new String(chars);
    }
}
