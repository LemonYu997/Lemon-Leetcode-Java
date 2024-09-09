package problems.c0easy.t1501t2000;

/**
 * 1614 括号的最大深度 https://leetcode.cn/problems/maximum-nesting-depth-of-the-parentheses/description/
 * 给定 有效括号字符串 s，返回 s 的 嵌套深度。嵌套深度是嵌套括号的 最大 数量。
 *
 * 示例：
 * 输入1：s = "(1+(2*3)+((8)/4))+1"
 * 输出1：3
 *
 * 输入2：s = "(1)+((2))+(((3)))"
 * 输出2：3
 *
 * 输入3：s = "()(())((()()))"
 * 输出3：3
 */
public class T1614 {
    /**
     * 自己实现：遍历字符串，遇到 ( +1，遇到 ) -1
     * 找到最大值
     */
    public int maxDepth(String s) {
        int ans = 0;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                temp++;
            }
            if (s.charAt(i) == ')') {
                ans = Math.max(ans, temp);
                temp--;
            }
        }

        return ans;
    }
}
