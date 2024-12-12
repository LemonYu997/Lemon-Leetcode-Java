package problems.c0easy.t1501t2000;

/**
 * 1869 哪种连续子字符串更长 https://leetcode.cn/problems/longer-contiguous-segments-of-ones-than-zeros/description/
 * 给你一个二进制字符串 s 。如果字符串中由 1 组成的 最长 连续子字符串
 * 严格长于 由 0 组成的 最长 连续子字符串，返回 true ；否则，返回 false 。
 * 例如，s = "110100010" 中，由 1 组成的最长连续子字符串的长度是 2 ，
 * 由 0 组成的最长连续子字符串的长度是 3 。
 * 注意，如果字符串中不存在 0 ，此时认为由 0 组成的最长连续子字符串的长度是 0 。
 * 字符串中不存在 1 的情况也适用此规则。
 *
 * 示例：
 * 输入1：s = "1101"
 * 输出1：true
 *
 * 输入2：s = "111000"
 * 输出2：false
 *
 * 输入3：s = "110100010"
 * 输出3：false
 */
public class T1869 {
    /**
     * 自己实现：根据题意模拟
     */
    public boolean checkZeroOnes(String s) {
        // 当前 0 或 1 的连续长度
        int len0 = 0;
        int len1 = 0;
        // 连续 0 或 1 的最大长度
        int max0 = 0;
        int max1 = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                len0++;
                len1 = 0;
            } else {
                len1++;
                len0 = 0;
            }
            max1 = Math.max(len1, max1);
            max0 = Math.max(len0, max0);
        }

        return max1 > max0;
    }
}
