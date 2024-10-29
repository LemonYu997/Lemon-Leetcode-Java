package problems.c0easy.t1501t2000;

/**
 * 1768 交替合并字符串 https://leetcode.cn/problems/merge-strings-alternately/description/
 * 给你两个字符串 word1 和 word2 。请你从 word1 开始，
 * 通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
 *
 * 返回 合并后的字符串 。
 *
 * 示例：
 * 输入1：word1 = "abc", word2 = "pqr"
 * 输出1："apbqcr"
 *
 * 输入2：word1 = "ab", word2 = "pqrs"
 * 输出2："apbqrs"
 *
 * 输入3：word1 = "abcd", word2 = "pq"
 * 输出3："apbqcd"
 */
public class T1768 {
    /**
     * 自己实现：根据题意模拟
     */
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0, j = 0; i < m && j < n; i++, j++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(j));
        }

        // 哪个字符串长就把剩下多余的拼接在后边
        if (m > n) {
            sb.append(word1.substring(n));
        }
        if (n > m) {
            sb.append(word2.substring(m));
        }

        return sb.toString();
    }

    /**
     * 官方解法：双指针优化写法
     */
    public String mergeAlternately1(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int i = 0;
        int j = 0;

        StringBuilder ans = new StringBuilder();
        while (i < m || j < n) {
            if (i < m) {
                ans.append(word1.charAt(i));
                i++;
            }
            if (j < n) {
                ans.append(word2.charAt(j));
                j++;
            }
        }

        return ans.toString();
    }
}
