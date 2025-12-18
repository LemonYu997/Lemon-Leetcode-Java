package problems.c0easy.t3001t3500;

/**
 * 3042 统计前后缀下标对 I https://leetcode.cn/problems/count-prefix-and-suffix-pairs-i/description/
 * 给你一个下标从 0 开始的字符串数组 words 。
 * 定义一个 布尔 函数 isPrefixAndSuffix ，它接受两个字符串参数 str1 和 str2 ：
 * 当 str1 同时是 str2 的前缀（prefix）和后缀（suffix）时，isPrefixAndSuffix(str1, str2) 返回 true，否则返回 false。
 * 例如，isPrefixAndSuffix("aba", "ababa") 返回 true，因为 "aba" 既是 "ababa" 的前缀，
 * 也是 "ababa" 的后缀，但是 isPrefixAndSuffix("abc", "abcd") 返回 false。
 * 以整数形式，返回满足 i < j 且 isPrefixAndSuffix(words[i], words[j]) 为 true 的下标对 (i, j) 的 数量 。
 *
 * 示例：
 * 输入1：words = ["a","aba","ababa","aa"]
 * 输出1：4
 *
 * 输入2：words = ["pa","papa","ma","mama"]
 * 输出2：2
 *
 * 输入3：words = ["abab","ab"]
 * 输出3：0
 */
public class T3042 {
    /**
     * 自己实现：根据题意模拟
     */
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // isPrefixAndSuffix
                if (words[j].startsWith(words[i]) && words[j].endsWith(words[i])) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
