package problems.c0easy.t2001t2500;

import java.util.HashMap;
import java.util.Map;

/**
 * 2085 统计出现过一次的公共字符串 https://leetcode.cn/problems/count-common-words-with-one-occurrence/description/
 * 给你两个字符串数组 words1 和 words2 ，
 * 请你返回在两个字符串数组中 都恰好出现一次 的字符串的数目。
 *
 * 示例：
 * 输入1：words1 = ["leetcode","is","amazing","as","is"], words2 = ["amazing","leetcode","is"]
 * 输出1：2
 *
 * 输入2：words1 = ["b","bb","bbb"], words2 = ["a","aa","aaa"]
 * 输出2：0
 *
 * 输入3：words1 = ["a","ab"], words2 = ["a","a","a","ab"]
 * 输出3：1
 *
 * 注意：
 * 1 <= words1.length, words2.length <= 1000
 * 1 <= words1[i].length, words2[j].length <= 30
 * words1[i] 和 words2[j] 都只包含小写英文字母。
 */
public class T2085 {
    /**
     * 自己实现：使用 MAP 统计
     */
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        int ans = 0;

        // 统计每个单词出现的次数
        for (String s : words1) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }

        for (String s : words2) {
            map2.put(s, map2.getOrDefault(s, 0) + 1);
        }

        // 找到符合要求的单词
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            if (entry.getValue() == 1 && map2.getOrDefault(entry.getKey(), 0) == 1) {
                ans++;
            }
        }

        return ans;
    }

    /**
     * 优化解法：单个 Map 统计
     */
    public int countWords1(String[] words1, String[] words2) {
        Map<String, Integer> map = new HashMap<>();
        int ans = 0;

        // 由于words长度最大为 1000，可以用 1000的倍数 来标记第一组单词出现的次数
        for (String s : words1) {
            map.put(s, map.getOrDefault(s, 0) + 1000);
        }

        // 第二组单词用个位数统计
        for (String s : words2) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (Integer value : map.values()) {
            if (value == 1001) {
                ans++;
            }
        }
        return ans;
    }
}
