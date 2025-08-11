package problems.c0easy.t2501t3000;

/**
 * 2609 最长平衡子字符串 https://leetcode.cn/problems/find-the-longest-balanced-substring-of-a-binary-string/description/
 * 给你一个仅由 0 和 1 组成的二进制字符串 s 。
 * 如果子字符串中 所有的 0 都在 1 之前 且其中 0 的数量等于 1 的数量，
 * 则认为 s 的这个子字符串是平衡子字符串。请注意，空子字符串也视作平衡子字符串。
 * 返回  s 中最长的平衡子字符串长度。
 * 子字符串是字符串中的一个连续字符序列。
 *
 * 示例：
 * 输入1：s = "01000111"
 * 输出1：6
 *
 * 输入2：s = "00111"
 * 输出2:4
 *
 * 输入3：s = "111"
 * 输出3：0
 */
public class T2609 {
    /**
     * 官方解法：遍历一次
     */
    public int findTheLongestBalancedSubstring(String s) {
        int ans = 0;
        int n = s.length();
        int[] count = new int[2];
        for (int i = 0; i < n; i++) {
            // 每到 1 处就更新结果
            if (s.charAt(i) == '1') {
                count[1]++;
                ans = Math.max(ans, 2 * Math.min(count[0], count[1]));
            } else if (i == 0 || s.charAt(i - 1) == '1') {
                // 如果是初始位或者与上一个字符不一致，则更新，因为 else，所以此时是0
                count[0] = 1;
                count[1] = 0;
            } else {
                count[0]++;
            }
        }
        return ans;
    }
}
