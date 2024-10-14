package problems.c0easy.t1501t2000;

/**
 * 1704 判断字符串的两半是否相似 https://leetcode.cn/problems/determine-if-string-halves-are-alike/description/
 * 给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。
 * 两个字符串 相似 的前提是它们都含有相同数目的元音（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。注意，s 可能同时含有大写和小写字母。
 * 如果 a 和 b 相似，返回 true ；否则，返回 false 。
 *
 * 示例：
 * 输入1：s = "book"
 * 输出1：true
 *
 * 输入2：s = "textbook"
 * 输出2：false
 */
public class T1704 {
    public static void main(String[] args) {
        String s = "MerryChristmas";
        halvesAreAlike(s);
    }

    /**
     * 自己实现：根据题意模拟
     */
    public static boolean halvesAreAlike(String s) {
        int n = s.length();
        int l = 0, r = 0;
        String temp = "aeiouAEIOU";

        // 统计左半部分
        for (int i = 0; i < n / 2; i++) {
            char c = s.charAt(i);
            // 如果当前字符为元音字符，则计数
            if (temp.indexOf(c) >= 0) {
                l++;
            }
        }

        for (int i = n / 2; i < n; i++) {
            char c = s.charAt(i);
            // 如果当前字符为元音字符，则计数
            if (temp.indexOf(c) >= 0) {
                r++;
            }
        }

        return l == r;
    }
}
