package problems.c0easy.t3001t3500;

/**
 * 3442 奇偶频次间的最大差值 I https://leetcode.cn/problems/maximum-difference-between-even-and-odd-frequency-i/description/
 * 给你一个由小写英文字母组成的字符串 s。
 * 请你找出字符串中两个字符 a1 和 a2 的出现频次之间的 最大 差值 diff = freq(a1) - freq(a2)，这两个字符需要满足：
 * a1 在字符串中出现 奇数次 。
 * a2 在字符串中出现 偶数次 。
 * 返回 最大 差值。
 *
 * 示例：
 * 输入1：s = "aaaaabbc"
 * 输出1：3
 *
 * 输入2：s = "abcabcab"
 * 输出2：1
 */
public class T3442 {
    /**
     * 自己实现：根据题意模拟
     */
    public int maxDifference(String s) {
        // 统计各字母出现次数
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        //找到最大的奇数和最小的偶数
        int max = 1;
        int min = s.length();
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                if (count[i] % 2 == 0 && count[i] < min) {
                    min = count[i];
                } else if (count[i] % 2 != 0 && count[i] > max) {
                    max = count[i];
                }
            }
        }
        return max - min;
    }
}
