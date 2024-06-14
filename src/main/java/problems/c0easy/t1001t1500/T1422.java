package problems.c0easy.t1001t1500;

/**
 * 1422 分割字符串的最大得分 https://leetcode.cn/problems/maximum-score-after-splitting-a-string/description/
 * 给你一个由若干 0 和 1 组成的字符串 s ，
 * 请你计算并返回将该字符串分割成两个 非空 子字符串（即 左 子字符串和 右 子字符串）所能获得的最大得分。
 * 「分割字符串的得分」为 左 子字符串中 0 的数量加上 右 子字符串中 1 的数量。
 *
 * 示例：
 * 输入1：s = "011101"
 * 输出1：5
 *
 * 输入2：s = "00111"
 * 输出2：5
 *
 * 输入3：s = "1111"
 * 输出3：3
 */
public class T1422 {
    /**
     * 自己实现：暴力解法，尝试所有情况
     */
    public int maxScore(String s) {
        char[] chars = s.toCharArray();
        int ans = 0;
        // 遍历每一位作为分割点
        for (int i = 1; i < chars.length; i++) {
            int count = 0;
            // 计算左侧得分
            for (int j = 0; j < i; j++) {
                if (chars[j] == '0') {
                    count++;
                }
            }
            // 计算右侧得分
            for (int j = i; j < chars.length; j++) {
                if (chars[j] == '1') {
                    count++;
                }
            }
            ans = Math.max(ans, count);
        }

        return ans;
    }
}
