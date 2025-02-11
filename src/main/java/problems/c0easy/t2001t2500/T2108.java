package problems.c0easy.t2001t2500;

/**
 * 2108 找出数组中的第一个回文字符串 https://leetcode.cn/problems/find-first-palindromic-string-in-the-array/description/
 * 给你一个字符串数组 words ，找出并返回数组中的 第一个回文字符串 。
 * 如果不存在满足要求的字符串，返回一个 空字符串 "" 。
 * 回文字符串 的定义为：如果一个字符串正着读和反着读一样，那么该字符串就是一个 回文字符串 。
 *
 * 示例：
 * 输入1：words = ["abc","car","ada","racecar","cool"]
 * 输出1："ada"
 *
 * 输入2：words = ["notapalindrome","racecar"]
 * 输出2："racecar"
 *
 * 输入3：words = ["def","ghi"]
 * 输出3：""
 */
public class T2108 {
    /**
     * 自己实现：根据题意模拟
     */
    public String firstPalindrome(String[] words) {
        for (String word : words) {
            int n = word.length();
            boolean flag = true;

            // 从两边向中间遍历判断是否为回文字符串
            for (int i = 0; i < n / 2; i++) {
                if (word.charAt(i) != word.charAt(n - i - 1)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                return word;
            }
        }

        return "";
    }
}
