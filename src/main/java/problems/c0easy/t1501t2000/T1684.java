package problems.c0easy.t1501t2000;

/**
 * 1684 统计一致字符串的数目 https://leetcode.cn/problems/count-the-number-of-consistent-strings/description/
 * 给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。
 * 如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字符串 。
 *
 * 请你返回 words 数组中 一致字符串 的数目。
 *
 * 示例：
 * 输入1：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
 * 输出1:2
 *
 * 输入2：allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
 * 输出2：7
 *
 * 输入3：allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
 * 输出3：4
 */
public class T1684 {
    /**
     * 自己实现：使用 int[] 统计每个字母是否在 allowed 中
     */
    public int countConsistentStrings(String allowed, String[] words) {
        int ans = 0;
        int[] dist = new int[26];
        // 记录存在的字母
        for (int i = 0; i < allowed.length(); i++) {
            dist[allowed.charAt(i) - 'a'] = 1;
        }

        // 判断每一个单词
        for (String word : words) {
            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                if (dist[word.charAt(i) - 'a'] == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans++;
            }
        }

        return ans;
    }

    /**
     * 官方解法：使用一个32位整数 mask 来表示字母是否存在，节省上边的 int[] 空间
     */
    public int countConsistentStrings1(String allowed, String[] words) {
        int mask = 0;
        // 将存在该字母的位数的二进制 置为 1
        for (int i = 0; i < allowed.length(); i++) {
            char c = allowed.charAt(i);
            mask |= 1 << (c - 'a');
        }

        int res = 0;
        for (String word : words) {
            int mask1 = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                mask1 |= 1 << (c - 'a');
            }
            // 如果该单词的所有字母都在 mask 中存在
            if ((mask1 | mask) == mask) {
                res++;
            }
        }

        return res;
    }
}
