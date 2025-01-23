package problems.c0easy.t2001t2500;

/**
 * 2042 检查句子中的数字是否递增 https://leetcode.cn/problems/check-if-numbers-are-ascending-in-a-sentence/description/
 * 句子是由若干 token 组成的一个列表，token 间用 单个 空格分隔，
 * 句子没有前导或尾随空格。每个 token 要么是一个由数字 0-9 组成的不含前导零的 正整数 ，
 * 要么是一个由小写英文字母组成的 单词 。
 * 示例，"a puppy has 2 eyes 4 legs" 是一个由 7 个 token 组成的句子："2" 和 "4" 是数字，
 * 其他像 "puppy" 这样的 tokens 属于单词。
 * 给你一个表示句子的字符串 s ，你需要检查 s 中的 全部 数字是否从左到右严格递增（即，除了最后一个数字，
 * s 中的 每个 数字都严格小于它 右侧 的数字）。
 *
 * 如果满足题目要求，返回 true ，否则，返回 false 。
 *
 * 示例：
 * 输入1：s = "1 box has 3 blue 4 red 6 green and 12 yellow marbles"
 * 输出1：true
 *
 * 输入2：s = "hello world 5 x 5"
 * 输出2：false
 *
 * 输入3：s = "sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s"
 * 输出3：false
 */
public class T2042 {
    /**
     * 自己实现：获取每个数并判断是否比前一个数大
     */
    public boolean areNumbersAscending(String s) {
        String[] words = s.split(" ");
        int pre = 0;
        for (int i = 0; i < words.length; i++) {
            // 如果当前单词是数字
            if (words[i].charAt(0) >= '0' && words[i].charAt(0) <= '9') {
                int temp = Integer.parseInt(words[i]);
                if (temp <= pre) {
                    return false;
                }
                pre = temp;
            }
        }

        return true;
    }

    /**
     * 官方解法：直接遍历
     */
    public boolean areNumbersAscending1(String s) {
        int pre = 0;
        int pos = 0;

        while (pos < s.length()) {
            if (Character.isDigit(s.charAt(pos))) {
                int cur = 0;
                while (pos < s.length() && Character.isDigit(s.charAt(pos))) {
                    cur = cur * 10 + s.charAt(pos) - '0';
                    pos++;
                }
                if (cur <= pre) {
                    return false;
                }
                pre = cur;
            } else {
                pos++;
            }
        }
        return true;
    }
}
