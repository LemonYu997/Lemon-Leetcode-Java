package problems.c0easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1021 删除最外层的括号 https://leetcode.cn/problems/remove-outermost-parentheses/description/
 * 有效括号字符串为空 ""、"(" + A + ")" 或 A + B ，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。
 * 例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 * 如果有效字符串 s 非空，且不存在将其拆分为 s = A + B 的方法，我们称其为原语（primitive），
 * 其中 A 和 B 都是非空有效括号字符串。
 *
 * 给出一个非空有效字符串 s，考虑将其进行原语化分解，使得：s = P_1 + P_2 + ... + P_k，
 * 其中 P_i 是有效括号字符串原语。
 *
 * 对 s 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 s 。
 *
 * 示例：
 * 输入1：s = "(()())(())"
 * 输出1："()()()"
 *
 * 输入2：s = "(()())(())(()(()))"
 * 输出2："()()()()(())"
 *
 * 输入3：s = "()()"
 * 输出3：""
 */
public class T1021 {
    /**
     * 官方解法：使用栈，遇到 "(" 入栈，遇到 ")" 出栈
     */
    public String removeOuterParentheses(String s) {
        StringBuffer sb = new StringBuffer();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                sb.append(c);
            }
            if (c == '(') {
                stack.push(c);
            }
        }
        return sb.toString();
    }

    /**
     * 官方解法：计数
     */
    public String removeOuterParentheses1(String s) {
        int level = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                level--;
            }
            if (level > 0) {
                sb.append(c);
            }
            if (c == '(') {
                level++;
            }
        }
        return sb.toString();
    }
}
