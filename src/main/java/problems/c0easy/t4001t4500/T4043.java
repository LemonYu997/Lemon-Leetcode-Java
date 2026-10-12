package problems.c0easy.t4001t4500;

/**
 * 4043 恰好有 K 对相等相邻字符的循环移位数量 https://leetcode.cn/problems/count-rotations-with-exactly-k-equal-adjacent-pairs/description/
 * 给你一个长度为 n 的字符串 s 和一个整数 k。
 * s 的一次 循环移位 可以通过以下方式得到：选择 s 的一个长度在 0 到 n - 1（包含两端）之间的 前缀 ，并将其移动到字符串末尾，同时保持所有字符的相对顺序不变。
 * 对于 s 的 每一种 循环移位，定义其 得分 为满足以下条件的下标 i 的数量：0 <= i < n - 1，且位置 i 和 i + 1 处的字符相同。
 * 返回得分等于 k 的循环移位数量。
 * 字符串的 前缀 是指从字符串开头开始，并延伸到字符串中某个位置的子串。
 * 子串 是字符串中一段连续的字符序列，可以为空。
 *
 * 示例：
 * 输入1：s = "aab", k = 1
 * 输出1：2
 *
 * 输入2：s = "abca", k = 0
 * 输出2：1
 */
public class T4043 {
    /**
     * 社区解法：滑动窗口
     */
    public int countRotations(String s, int k) {
        char[] cs = s.toCharArray();
        int n = s.length();
        int same = 0;
        int ans = 0;
        for (int i = 0; i < n * 2 - 2; i++) {
            if (cs[i % n] == cs[(i + 1) % n]) {
                same++;
            }

            int left = i - n + 2;
            if (left < 0) {
                continue;
            }

            if (same == k) {
                ans++;
            }

            if (cs[left] == cs[(left + 1) % n]) {
                same--;
            }
        }
        return ans;
    }
}
