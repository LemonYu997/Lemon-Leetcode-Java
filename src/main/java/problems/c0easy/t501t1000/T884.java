package problems.c0easy.t501t1000;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 884 两句话中的不常见单词 https://leetcode.cn/problems/uncommon-words-from-two-sentences/
 * 句子 是一串由空格分隔的单词。每个 单词 仅由小写字母组成。
 * 如果某个单词在其中一个句子中恰好出现一次，在另一个句子中却 没有出现 ，那么这个单词就是 不常见的 。
 * 给你两个 句子 s1 和 s2 ，返回所有 不常用单词 的列表。返回列表中单词可以按 任意顺序 组织。
 *
 * 示例：
 * 输入1：s1 = "this apple is sweet", s2 = "this apple is sour"
 * 输出1：["sweet","sour"]
 *
 * 输入2：s1 = "apple apple", s2 = "banana"
 * 输出2：["banana"]
 */
public class T884 {
    /**
     * 自己实现：使用 HashMap
     * 遍历两次，第一次记录所有单词出现的次数，第二次筛除出现次数为 1 的单词
     */
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        countWords(s1, map);
        countWords(s2, map);

        String[] ans = new String[s1.length() + s2.length()];

        int i = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                ans[i] = entry.getKey();
                i++;
            }
        }

        return Arrays.copyOfRange(ans, 0, i);
    }

    public void countWords(String s, Map<String, Integer> map) {
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            while (i < s.length() && s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
                i++;
            }
            String word = sb.toString();
            map.put(word, map.getOrDefault(word, 0) + 1);
            sb.setLength(0);
        }
    }
}
