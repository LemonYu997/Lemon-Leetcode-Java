package problems.c0easy.t1001t1500;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1221 分割平衡字符串 https://leetcode.cn/problems/split-a-string-in-balanced-strings/description/
 * 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
 * 给你一个平衡字符串 s，请你将它分割成尽可能多的子字符串，并满足：
 * 每个子字符串都是平衡字符串。
 * 返回可以通过分割得到的平衡字符串的 最大数量 。
 *
 * 示例：
 * 输入1：s = "RLRRLLRLRL"
 * 输出1：4
 *
 * 输入2：s = "RLRRRLLRLL"
 * 输出2：2
 *
 * 输入3：s = "LLLLRRRR"
 * 输出3：1
 */
public class T1221 {
    /**
     * 官方解法：使用 int 计数，出现 L 就 ++，出现 R 就 --，当为 0 时 次数就加一
     */
    public int balancedStringSplit(String s) {
        int ans = 0;
        int n = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                n++;
            } else {
                n--;
            }
            if (n == 0) {
                ans++;
            }
        }
        return ans;
    }
}
