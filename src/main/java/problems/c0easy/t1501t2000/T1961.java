package problems.c0easy.t1501t2000;

/**
 * 1961 检查字符串是否为数组前缀 https://leetcode.cn/problems/check-if-string-is-a-prefix-of-array/description/
 * 给你一个字符串 s 和一个字符串数组 words ，
 * 请你判断 s 是否为 words 的 前缀字符串 。
 * 字符串 s 要成为 words 的 前缀字符串 ，需要满足：s 可以由 words 中的前 k（k 为 正数 ）个字符串按顺序相连得到，
 * 且 k 不超过 words.length 。
 * 如果 s 是 words 的 前缀字符串 ，返回 true ；否则，返回 false 。
 *
 * 示例：
 * 输入1：s = "iloveleetcode", words = ["i","love","leetcode","apples"]
 * 输出1：true
 *
 * 输入2：s = "iloveleetcode", words = ["apples","i","love","leetcode"]
 * 输出2：false
 */
public class T1961 {
    /**
     * 自己实现：连续拼接 wrods 并于 s 比较，为方便比较可以先比较长度
     */
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            sb.append(word);
            if (sb.length() > s.length()) {
                // 如果已超出长度，直接返回false
                return false;
            } else if (sb.length() == s.length()) {
                // 如果长度一致，可以结束循环
                break;
            }
        }

        // 判断是否一致
        // 这里注意：即使 words 拼接完长度已然小于 s，直接比较也会是 false，因此不必再判断
        return sb.toString().equals(s);
    }

    /**
     * 官方解法：直接比较每一个字符
     */
    public boolean isPrefixString1(String s, String[] words) {
        int i = 0;
        int n = s.length();

        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                // 比较当前字符串
                if (i < n && word.charAt(j) == s.charAt(i)) {
                    i++;
                } else {
                    // 如果当前字符不一致或者长度超出要求，直接返回 false
                    return false;
                }
            }
            // 如果当前单词遍历完，长度刚好一致，说明满足条件
            if (i == n) {
                return true;
            }
        }

        // 遍历完所有单词还是不满足条件，返回 false
        return false;
    }
}