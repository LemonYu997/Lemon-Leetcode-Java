package problems.c0easy.t3501t4000;

/**
 * 3541 找到频率最高的元音和辅音 https://leetcode.cn/problems/find-most-frequent-vowel-and-consonant/description/
 * 给你一个由小写英文字母（'a' 到 'z'）组成的字符串 s。
 * 你的任务是找出出现频率 最高 的元音（'a'、'e'、'i'、'o'、'u' 中的一个）和出现频率最高的辅音（除元音以外的所有字母），并返回这两个频数之和。
 * 注意：如果有多个元音或辅音具有相同的最高频率，可以任选其中一个。
 * 如果字符串中没有元音或没有辅音，则其频率视为 0。
 * 一个字母 x 的 频率 是它在字符串中出现的次数。
 *
 * 示例：
 * 输入1：s = "successes"
 * 输出1：6
 *
 * 输入2：s = "aeiaeia"
 * 输出2：3
 */
public class T3541 {
    /**
     * 自己实现：根据题意模拟
     */
    public int maxFreqSum(String s) {
        int[] dict = new int[26];
        for (int i = 0; i < s.length(); i++) {
            dict[s.charAt(i) - 'a']++;
        }

        // 找到数量最多的元音字母和辅音字母
        int max1 = 0;
        int max2 = 0;
        for (int i = 0; i < dict.length; i++) {
            // 元音字母 aeiou 所在索引
            if (i == 0 || i == 'e' - 'a' || i == 'i' - 'a' || i == 'o' - 'a' || i == 'u' - 'a') {
                if (dict[i] > max1) {
                    max1 = dict[i];
                }
            } else {
                if (dict[i] > max2) {
                    max2 = dict[i];
                }
            }
        }
        return max1 + max2;
    }
}
