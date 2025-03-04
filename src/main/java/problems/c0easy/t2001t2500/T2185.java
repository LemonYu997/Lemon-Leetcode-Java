package problems.c0easy.t2001t2500;

/**
 * 2185 统计包含给定前缀的字符串 https://leetcode.cn/problems/counting-words-with-a-given-prefix/description/
 * 给你一个字符串数组 words 和一个字符串 pref 。
 *
 * 返回 words 中以 pref 作为 前缀 的字符串的数目。
 *
 * 字符串 s 的 前缀 就是  s 的任一前导连续字符串。
 *
 * 示例：
 * 输入1：words = ["pay","attention","practice","attend"], pref = "at"
 * 输出1：2
 *
 * 输入2：words = ["leetcode","win","loops","success"], pref = "code"
 * 输出2：0
 */
public class T2185 {
    /**
     * 自己实现：遍历每一个字符串并用 API 判断
     */
    public int prefixCount(String[] words, String pref) {
        int ans = 0;

        for (String word : words) {
            if (word.startsWith(pref)) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 不使用API时
     */
    public int prefixCount1(String[] words, String pref) {
        int ans = 0;

        for (String word : words) {
            int n = pref.length();
            boolean flag = true;
            if (n > word.length()) {
                continue;
            }

            // 比较前 n 个字符是否一致
            for (int i = 0; i < n; i++) {
                if (word.charAt(i) != pref.charAt(i)) {
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
}
