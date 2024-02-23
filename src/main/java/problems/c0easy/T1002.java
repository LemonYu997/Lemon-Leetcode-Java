package problems.c0easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1002 查找共用字符 https://leetcode.cn/problems/find-common-characters/description/
 * 给你一个字符串数组 words ，请你找出所有在 words 的每个字符串中都出现的共用字符（ 包括重复字符），
 * 并以数组形式返回。你可以按 任意顺序 返回答案。
 *
 * 示例：
 * 输入1：words = ["bella","label","roller"]
 * 输出1：["e","l","l"]
 *
 * 输入2：words = ["cool","lock","cook"]
 * 输出2：["c","o"]
 */
public class T1002 {
    /**
     * 官方解法：使用 minfreq[c] 存储字符 c 在所有字符串中出现次数的最小值
     * 遍历每一个字符串，使用 freq[c] 统计字符串中每一个字符 c 出现的次数
     */
    public List<String> commonChars(String[] words) {
        int[] minfreq = new int[26];
        Arrays.fill(minfreq, Integer.MAX_VALUE);
        for (String word : words) {
            int[] freq = new int[26];
            int length = word.length();
            for (int i = 0; i < length; i++) {
                char c = word.charAt(i);
                freq[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                minfreq[i] = Math.min(minfreq[i], freq[i]);
            }
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < minfreq[i]; j++) {
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;
    }
}
