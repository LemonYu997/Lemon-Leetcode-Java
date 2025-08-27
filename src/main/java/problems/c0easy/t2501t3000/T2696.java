package problems.c0easy.t2501t3000;

import java.util.ArrayList;
import java.util.List;

/**
 * 2696 删除子串后的字符串最小长度 https://leetcode.cn/problems/minimum-string-length-after-removing-substrings/description/
 * 给你一个仅由 大写 英文字符组成的字符串 s 。
 * 你可以对此字符串执行一些操作，在每一步操作中，你可以从 s 中删除 任一个 "AB" 或 "CD" 子字符串。
 * 通过执行操作，删除所有 "AB" 和 "CD" 子串，返回可获得的最终字符串的 最小 可能长度。
 * 注意，删除子串后，重新连接出的字符串可能会产生新的 "AB" 或 "CD" 子串。
 *
 * 示例：
 * 输入1：s = "ABFCACDB"
 * 输出1：2
 *
 * 输入2：s = "ACBBD"
 * 输出2：5
 */
public class T2696 {
    /**
     * 自己实现：遍历删除即可
     */
    public int minLength(String s) {
        while (true) {
            if (s.contains("AB")) {
                s = s.replace("AB", "");
            } else if (s.contains("CD")) {
                s = s.replace("CD", "");
            } else {
                break;
            }
        }

        return s.length();
    }

    /**
     * 官方解法：使用栈模拟即可
     */
    public int minLength1(String s) {
        List<Character> stack = new ArrayList<Character>();
        for (int i = 0; i < s.length(); i++) {
            // 每一个字符都入栈
            char c = s.charAt(i);
            stack.add(c);
            int m = stack.size();
            // 如果最近的两个字符为 AB 或者 CD，则将其出栈
            if (m >= 2 && (stack.get(m - 2) == 'A' && stack.get(m - 1) == 'B' || stack.get(m - 2) == 'C' && stack.get(m - 1) == 'D')) {
                stack.remove(m - 1);
                stack.remove(m - 2);
            }
        }
        return stack.size();
    }
}
