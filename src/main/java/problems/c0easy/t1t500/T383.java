package problems.c0easy.t1t500;

import java.util.HashMap;
import java.util.Map;

/**
 * 383 赎金信 https://leetcode.cn/problems/ransom-note/
 * 给定两个字符串：ransomNote和magazine，判断ransomNote能不能由magazine里的字符构成
 * 如果可以，返回true，否则返回false
 *
 * 示例：
 * 输入1：ransomNote = "a", magazine = "b"
 * 输出1：false
 *
 * 输入2：ransomNote = "aa", magazine = "ab"
 * 输出2：false
 *
 * 输入3：ransomNote = "aa", magazine = "aab"
 * 输出3：true
 */
public class T383 {
    /**
     * 自己实现：使用map
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        //将magazine中的每个字符出现的次数放入map
        char[] chars = magazine.toCharArray();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //匹配ransomNote的字符
        char[] cs = ransomNote.toCharArray();
        for (char c : cs) {
            if (map.getOrDefault(c, 0) == 0) {
                return false;
            } else {
                map.put(c, map.get(c) - 1);
            }
        }

        return true;
    }

    /**
     * 官方解法：字符统计，使用数组
     */
    public boolean canConstruct1(String ransomNote, String magazine) {
        //先排除一定不可能的情况
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        //存储magazine中26个英文小写字符出现的次数
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }

        //用ransomNote匹配
        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a']--;
            if (cnt[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
