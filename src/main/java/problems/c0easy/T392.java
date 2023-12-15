package problems.c0easy;

/**
 * 392 判断子序列 https://leetcode.cn/problems/is-subsequence/
 * 给定字符串s和t，判断s是否为t的子序列
 * 字符串的一个子序列是原始字符串删除一些字符而不改变剩余字符相对位置形成的新字符
 * 例如 "ace"是"abcde"的一个子序列
 *
 * 示例：
 * 输入1：s = "abc", t = "ahbgdc"
 * 输入1：true
 *
 * 输入2：s = "axc", t = "ahbgdc"
 * 输出2：false
 */
public class T392 {
    public static void main(String[] args) {
        isSubsequence("abc", "ahbgdc");
    }

    /**
     * 自己实现：双指针
     */
    public static boolean isSubsequence(String s, String t) {
        char[] scs = s.toCharArray();
        char[] tcs = t.toCharArray();

        int sl = scs.length;
        int tl = tcs.length;
        int i = 0;
        int j = 0;

        while (i < sl && j < tl) {
            //如果当前字符一致，指针全向后移
            if (tcs[j] == scs[i]) {
                i++;
            }

            j++;
        }

        //如果s是t子串，最后i++之后应当与s长度一致
        return i == sl;
    }
}
