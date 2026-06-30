package problems.c0easy.t3501t4000;

/**
 * 3707 相等子字符串分数 https://leetcode.cn/problems/equal-score-substrings/description/
 * 给你一个由小写英文字母组成的字符串 s。
 * 一个字符串的 得分 是其字符在字母表中的位置之和，其中 'a' = 1，'b' = 2，...，'z' = 26。
 * 请你判断是否存在一个下标 i，使得该字符串可以被拆分成两个 非空子字符串 s[0..i] 和 s[(i + 1)..(n - 1)]，且它们的得分 相等 。
 * 如果存在这样的拆分，则返回 true，否则返回 false。
 * 一个 子字符串 是字符串中 非空 的连续字符序列。
 *
 * 示例：
 * 输入1：s = "adcb"
 * 输出1：true
 *
 * 输入2：s = "bace"
 * 输出2：false
 */
public class T3707 {
    /**
     * 自己实现：先转换为数组，再计算两边的和是否有相等的
     */
    public boolean scoreBalance(String s) {
        // 先计算总和，再遍历求和
        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < s.length(); i++) {
            sumB += s.charAt(i) - 'a' + 1;
        }
        // 两边必须得保证不为空
        for (int i = 0; i < s.length() - 1; i++) {
            sumA += s.charAt(i) - 'a';
            if (sumA == (sumB - sumA)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 社区解法：优化写法
     */
    public boolean scoreBalance1(String s) {
        char[] chars = s.toCharArray();
        int total = 0;
        for (char c : chars) {
            total += c & 31;
        }

        int left = 0;
        for (char c : chars) {
            left += c & 31;
            if (left * 2 == total) {
                return true;
            }
        }
        return false;
    }
}