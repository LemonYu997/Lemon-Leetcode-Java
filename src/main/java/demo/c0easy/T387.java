package demo.c0easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 387 字符串中的第一个唯一字符 https://leetcode.cn/problems/first-unique-character-in-a-string/
 * 给定一个字符串s，找到它的第一个不重复的字符，并返回它的索引
 * 如果不存在，返回-1
 *
 * 示例：
 * 输入1：s = "leetcode"
 * 输出1：0
 *
 * 输入2：s = "loveleetcode"
 * 输出2：2
 *
 * 输入3：s = "aabb"
 * 输出3：-1
 */
public class T387 {
    /**
     * 自己实现：双指针暴力遍历
     */
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (j == i) {
                    continue;
                }
                if (chars[j] == chars[i]) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 官方解法1：使用哈希表存储次数
     */
    public int firstUniqChar1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();

        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 官方解法2：使用哈希表存储索引
     */
    public int firstUniqChar2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int n = chars.length;

        //第一次遍历，只要重复出现过某一字符，就将value设为-1
        for (int i = 0; i < n; i++) {
            char c = chars[i];
            if (map.containsKey(c)) {
                map.put(c, -1);
            } else {
                map.put(c, i);
            }
        }

        //找到不为-1的最小值（最低索引），即为首个不重复字符
        int first = n;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int index = entry.getValue();
            if (index != -1 && index < first) {
                first = index;
            }
        }
        //如果没有找到
        if (first == n) {
            first = -1;
        }

        return first;
    }
}
