package problems.c0easy.t2501t3000;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 2810 故障键盘 https://leetcode.cn/problems/faulty-keyboard/description/
 * 你的笔记本键盘存在故障，每当你在上面输入字符 'i' 时，
 * 它会反转你所写的字符串。而输入其他字符则可以正常工作。
 * 给你一个下标从 0 开始的字符串 s ，请你用故障键盘依次输入每个字符。
 * 返回最终笔记本屏幕上输出的字符串。
 *
 * 示例：
 * 输入1：s = "string"
 * 输出1："rtsng"
 *
 * 输入2：s = "poiinter"
 * 输出2："ponter"
 */
public class T2810 {
    /**
     * 自己实现：根据题意模拟即可
     */
    public String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == 'i') {
                sb.reverse();
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 官方解法：减少反转次数，提高性能
     */
    public String finalString1(String s) {
        Deque<Character> q = new ArrayDeque<>();
        boolean head = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != 'i') {
                if (head) {
                    q.offerFirst(c);
                } else {
                    q.offerLast(c);
                }
            } else {
                head = !head;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (head) {
            while (!q.isEmpty()) {
                sb.append(q.pollLast());
            }
        } else {
            while (!q.isEmpty()) {
                sb.append(q.pollFirst());
            }
        }
        return sb.toString();
    }
}
