package problems.c0easy.t2501t3000;

/**
 * 2586 统计范围内的元音字符串数 https://leetcode.cn/problems/count-the-number-of-vowel-strings-in-range/description/
 * 给你一个下标从 0 开始的字符串数组 words 和两个整数：left 和 right 。
 * 如果字符串以元音字母开头并以元音字母结尾，那么该字符串就是一个 元音字符串 ，
 * 其中元音字母是 'a'、'e'、'i'、'o'、'u' 。
 * 返回 words[i] 是元音字符串的数目，其中 i 在闭区间 [left, right] 内。
 *
 * 示例：
 * 输入1：words = ["are","amy","u"], left = 0, right = 2
 * 输出1：2
 *
 * 输入2：words = ["hey","aeo","mu","ooo","artro"], left = 1, right = 4
 * 输出2：3
 */
public class T2586 {
    /**
     * 自己实现：根据题意遍历即可
     */
    public int vowelStrings(String[] words, int left, int right) {
        String aeiou = "aeiou";
        int ans = 0;
        for (int i = left; i <= right; i++) {
            String word = words[i];
            int n = word.length();
            if (aeiou.contains(String.valueOf(word.charAt(0))) &&
                    aeiou.contains(String.valueOf(word.charAt(n - 1)))) {
                ans++;
            }
        }
        return ans;
    }
}
