package problems.c0easy.t1t500;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 242 有效的字母异位词 https://leetcode.cn/problems/valid-anagram/
 * 给定两个字符串s和t，编写一个函数来判断t是否是s的字母异位词
 * 字母异位词：s和t中每个字符出现的次数相同
 *
 * 示例：
 * 输入1：s = "anagram", t = "nagaram"
 * 输出1：true
 *
 * 输入2：s = "rat", t = "car"
 * 输出2：false
 */
public class T242 {
    /**
     * 自己实现：使用两个map，对比所有字符数量
     */
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> maps = new HashMap<>();
        Map<Character, Integer> mapt = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (maps.containsKey(c)) {
                maps.put(c, maps.get(c) + 1);
            } else {
                maps.put(c, 1);
            }
        }

        for (char c : t.toCharArray()) {
            if (mapt.containsKey(c)) {
                mapt.put(c, mapt.get(c) + 1);
            } else {
                mapt.put(c, 1);
            }
        }

        //如果key不相等，就不同
        if (!maps.keySet().equals(mapt.keySet())) {
            return false;
        }

        //判断每一个字符的数量
        for (Character c : maps.keySet()) {
            if (!maps.get(c).equals(mapt.get(c))) {
                return false;
            }
        }

        return true;
    }

    /**
     * 官方解法1：对字符串进行排序后判断是否相等
     */
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] css = s.toCharArray();
        char[] cts = t.toCharArray();

        Arrays.sort(css);
        Arrays.sort(cts);

        return Arrays.equals(cts, css);
    }

    /**
     * 官方解法2：维护一个哈希表，先存s中字符出现的个数，再减去t的
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        //先存s的
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //再减去t的
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
            if (map.get(c) < 0) {
                return false;
            }
        }
        return true;
    }
}
