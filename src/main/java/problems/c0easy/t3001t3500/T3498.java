package problems.c0easy.t3001t3500;

/**
 * 3498 字符串的反转度 https://leetcode.cn/problems/reverse-degree-of-a-string/description/
 * 给你一个字符串 s，计算其 反转度。
 * 反转度的计算方法如下：
 * 对于每个字符，将其在 反转 字母表中的位置（'a' = 26, 'b' = 25, ..., 'z' = 1）
 * 与其在字符串中的位置（下标从1 开始）相乘。
 * 将这些乘积加起来，得到字符串中所有字符的和。
 * 返回 反转度。
 *
 * 示例：
 * 输入1：s = "abc"
 * 输出1：148
 *
 * 输入2：s = "zaza"
 * 输出2：160
 */
public class T3498 {
    /**
     * 自己实现：根据题意模拟
     */
    public int reverseDegree(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            ans += ('z' - c + 1) * (i + 1);
        }
        return ans;
    }
}
