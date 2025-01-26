package problems.c0easy.t2001t2500;

/**
 * 2047 句子中的有效单词数 https://leetcode.cn/problems/number-of-valid-words-in-a-sentence/description/
 * 句子仅由小写字母（'a' 到 'z'）、数字（'0' 到 '9'）、连字符（'-'）、
 * 标点符号（'!'、'.' 和 ','）以及空格（' '）组成。每个句子可以根据空格分解成 一个或者多个 token ，
 * 这些 token 之间由一个或者多个空格 ' ' 分隔。
 * 如果一个 token 同时满足下述条件，则认为这个 token 是一个有效单词：
 * 仅由小写字母、连字符和/或标点（不含数字）组成。
 * 至多一个 连字符 '-' 。如果存在，连字符两侧应当都存在小写字母（"a-b" 是一个有效单词，
 * 但 "-ab" 和 "ab-" 不是有效单词）。
 * 至多一个 标点符号。如果存在，标点符号应当位于 token 的 末尾 。
 * 这里给出几个有效单词的例子："a-b."、"afad"、"ba-c"、"a!" 和 "!" 。
 *
 * 给你一个字符串 sentence ，请你找出并返回 sentence 中 有效单词的数目 。
 *
 * 示例：
 * 输入1：sentence = "cat and  dog"
 * 输出1：3
 *
 * 输入2：sentence = "!this  1-s b8d!"
 * 输出2：0
 *
 * 输入3：sentence = "alice and  bob are playing stone-game10"
 * 输出3：5
 */
public class T2047 {
    /**
     * 官方解法：双指针遍历
     */
    public int countValidWords(String sentence) {
        int n = sentence.length();
        int l = 0;
        int r = 0;
        int ans = 0;

        while (true) {
            // 找到单词的左起始点
            while (l < n && sentence.charAt(l) == ' ') {
                l++;
            }
            if (l >= n) {
                break;
            }
            r = l + 1;
            // 找到单词的右截止点
            while (r < n && sentence.charAt(r) != ' ') {
                r++;
            }

            if (check(sentence.substring(l, r))) {
                ans++;
            }

            l = r + 1;
        }

        return ans;
    }

    /**
     * 校验当前单词是否成立，排除以下条件
     * 单词中包含数字；
     * 单词中包含两个以上连字符；
     * 连字符在单词头部或者单词末尾；
     * 连字符的左/右边字符不是小写字母；
     * 单词中的标点符号不在单词的末尾。
      */
    public boolean check(String word) {
        int n = word.length();
        // 是否包含连字符
        boolean hasHyphens = false;
        for (int i = 0; i < n; i++) {
            // 包含数字
            if (Character.isDigit(word.charAt(i))) {
                return false;
            } else if (word.charAt(i) == '-') {
                // 包含两个以上连字符或者 起始位和末位为连字符 或者 连字符的前后不为字母
                if (hasHyphens == true || i == 0 || i == n - 1
                        || !Character.isLetter(word.charAt(i - 1))
                        || !Character.isLetter(word.charAt(i + 1))) {
                    return false;
                }
                hasHyphens = true;
            } else if (word.charAt(i) == '!'
                    || word.charAt(i) == '.'
                    || word.charAt(i) == ',') {
                // 如果当前为标点符号但不是单词末位
                if (i != n - 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
