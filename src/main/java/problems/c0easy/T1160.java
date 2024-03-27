package problems.c0easy;

import java.util.Arrays;

/**
 * 1160 拼写单词 https://leetcode.cn/problems/find-words-that-can-be-formed-by-characters/description/
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），
 * 那么我们就认为你掌握了这个单词。
 * 注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 *
 * 示例：
 * 输入1：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出1：6
 *
 * 输入2：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * 输出2：10
 */
public class T1160 {
    /**
     * 自己实现：使用 int[] 存储字母表
     */
    public int countCharacters(String[] words, String chars) {
        int[] dist = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            dist[chars.charAt(i) - 'a']++;
        }

        int ans = 0;

        // 遍历每一个单词，和 map 比对
        for (String word : words) {
            // 判断该单词是否掌握
            boolean flag = true;
            int[] temp = Arrays.copyOf(dist, 26);
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (temp[c - 'a'] <= 0) {
                    flag = false;
                    break;
                }
                temp[c - 'a']--;
            }

            if (flag) {
                ans += word.length();
            }
        }

        return ans;
    }
}
