package problems.c0easy.t2001t2500;

/**
 * 2315 统计星号 https://leetcode.cn/problems/count-asterisks/description/
 * 给你一个字符串 s ，每 两个 连续竖线 '|' 为 一对 。换言之，
 * 第一个和第二个 '|' 为一对，第三个和第四个 '|' 为一对，以此类推。
 * 请你返回 不在 竖线对之间，s 中 '*' 的数目。
 * 注意，每个竖线 '|' 都会 恰好 属于一个对。
 *
 * 示例：
 * 输入1：s = "l|*e*et|c**o|*de|"
 * 输出1：2
 *
 * 输入2：s = "iamprogrammer"
 * 输出2：0
 *
 * 输入3：s = "yo|uar|e**|b|e***au|tifu|l"
 * 输出3：5
 */
public class T2315 {
    /**
     * 自己实现：根据题意模拟
     */
    public int countAsterisks(String s) {
        int ans = 0;

        // 表示当前遍历的内容是否在 || 之间
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                flag = !flag;
            }
            // 只统计不在 || 之间的星号
            if (!flag && s.charAt(i) == '*') {
                ans++;
            }
        }

        return ans;
    }
}
