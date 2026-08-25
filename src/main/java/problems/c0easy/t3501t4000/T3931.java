package problems.c0easy.t3501t4000;

/**
 * 3931 检查相邻数字差 https://leetcode.cn/problems/check-adjacent-digit-differences/description/
 * 给你一个由数字组成的字符串 s。
 * 如果每一对 相邻 数字之间的 绝对差 都至多为 2，则返回 true；否则返回 false。
 * a 和 b 之间的绝对差定义为 abs(a - b)。
 *
 * 示例：
 * 输入1：s = "132"
 * 输出1：true
 *
 * 输入2：s = "129"
 * 输出2：false
 */
public class T3931 {
    /**
     * 自己实现：根据题意模拟
     */
    public boolean isAdjacentDiffAtMostTwo(String s) {
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (Math.abs(chars[i] - chars[i - 1]) > 2) {
                return false;
            }
        }
        return true;
    }

    /**
     * 社区解法：不需要转chars，优化写法
     */
    public boolean isAdjacentDiffAtMostTwo1(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (Math.abs(s.charAt(i) - s.charAt(i - 1)) > 2) {
                return false;
            }
        }
        return true;
    }
}
