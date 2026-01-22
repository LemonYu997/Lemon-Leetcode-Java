package problems.c0easy.t3001t3500;

import java.util.Stack;

/**
 * 3174 https://leetcode.cn/problems/clear-digits/description/
 * 给你一个字符串 s 。
 * 你的任务是重复以下操作删除 所有 数字字符：
 * 删除 第一个数字字符 以及它左边 最近 的 非数字 字符。
 * 请你返回删除所有数字字符以后剩下的字符串。
 * 注意，该操作不能对左侧没有任何非数字字符的数字执行。
 *
 * 示例：
 * 输入1：s = "abc"
 * 输出1："abc"
 *
 * 输入2：s = "cb34"
 * 输出2：""
 */
public class T3174 {
    /**
     * 自己实现：根据题意模拟
     */
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 遇到数字出栈
            if (Character.isDigit(c) && !stack.isEmpty()) {
                stack.pop();
            } else {
                // 遇到英文字符入栈
                stack.push(c);
            }
        }
        // 按顺序排出所有元素拼接字符串
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }


    /**
     * 官方解法：优化写法，直接用过StringBuilder模拟栈
     */
    public String clearDigits1(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // 删除上一个字符
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}