package problems.c0easy.t4001t4500;

/**
 * 4006 统计有效前缀数目 https://leetcode.cn/problems/count-valid-prefixes/description/
 * 给你一个 二进制 字符串 s。
 * 如果 s 的某个 前缀 的字符可以重新排列成一个 交替 字符串，那么该前缀被认为是 有效 的。
 * 返回 s 中有效前缀的数量。
 * 二进制 字符串是仅由 '0' 和 '1' 组成的字符串。
 * 字符串的 前缀 是指从字符串的开头开始并延伸到其内任意点的 子字符串。
 * 子字符串 是字符串中连续且 非空 的字符序列。
 * 如果一个字符串中没有两个相邻字符相等，那么它被认为是 交替 的。
 *
 * 示例：
 * 输入1：s = "00101"
 * 输出1：3
 *
 * 输入2：s = "101"
 * 输出2：3
 */
public class T4006 {
    /**
     * 自己实现：即统计0和1的次数，且次数差不得大于1
     */
    public int countValidPrefixes(String s) {
        int c0 = 0;
        int c1 = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                c0++;
            } else {
                c1++;
            }
            if (Math.abs(c0 - c1) <= 1) {
                ans++;
            }
        }
        return ans;
    }
}
