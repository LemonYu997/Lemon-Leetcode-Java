package problems.c0easy.t3001t3500;

/**
 * 3110 字符串的分数 https://leetcode.cn/problems/score-of-a-string/description/
 * 给你一个字符串 s 。一个字符串的 分数 定义为相邻字符 ASCII 码差值绝对值的和。
 * 请你返回 s 的 分数 。
 *
 * 示例：
 * 输入1：s = "hello"
 * 输出1：13
 *
 * 输入2：s = "zaz"
 * 输出2：50
 */
public class T3110 {
    /**
     * 自己实现：根据题意模拟
     */
    public int scoreOfString(String s) {
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            ans += Math.abs(s.charAt(i) - s.charAt(i - 1));
        }

        return ans;
    }
}
