package problems.c0easy.t2501t3000;

/**
 * 2937 使三个字符串相等 https://leetcode.cn/problems/make-three-strings-equal/description/
 * 给你三个字符串 s1、s2 和 s3。 你可以根据需要对这三个字符串执行以下操作 任意次数 。
 * 在每次操作中，你可以选择其中一个长度至少为 2 的字符串 并删除其 最右位置上 的字符。
 * 如果存在某种方法能够使这三个字符串相等，请返回使它们相等所需的 最小 操作次数；否则，返回 -1。
 *
 * 示例：
 * 输入1：s1 = "abc"，s2 = "abb"，s3 = "ab"
 * 输出1：2
 *
 * 输入2：s1 = "dac"，s2 = "bac"，s3 = "cac"
 * 输出2：-1
 */
public class T2937 {
    /**
     * 自己实现：根据题意模拟
     */
    public int findMinimumOperations(String s1, String s2, String s3) {
        // 找到最短的那个，以此为基础遍历
        int n = Math.min(s1.length(), Math.min(s2.length(), s3.length()));
        int i = 0;
        while (i < n && s2.charAt(i) == s3.charAt(i) && s1.charAt(i) == s3.charAt(i)) {
            i++;
        }
        return i == 0 ? -1 : s1.length() + s2.length() + s3.length() - i * 3;
    }
}
