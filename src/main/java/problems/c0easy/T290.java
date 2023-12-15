package problems.c0easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 290 单词规律 https://leetcode.cn/problems/word-pattern/
 * 给定一种规律pattern和一个字符串s，判断s是否遵循相同的规律
 *
 * 示例：
 * 输入1：pattern = "abba", s = "dog cat cat dog"
 * 输出1：true
 *
 * 输入2：pattern = "abba", s = "dog cat cat fish"
 * 输出2：false
 *
 * 输入3：pattern = "aaaa", s = "dog cat cat dog"
 * 输出3：false
 */
public class T290 {
    public static void main(String[] args) {
        wordPattern("abba", "dog cat cat dog");
    }

    /**
     * 自己实现：使用map存储映射关系
     */
    public static boolean wordPattern(String pattern, String s) {
        String[] ss = s.split(" ");
        char[] ps = pattern.toCharArray();
        if (ss.length != ps.length) {
            return false;
        }

        //存映射关系
        Map<Character, String> c2s = new HashMap<>();
        Map<String, Character> s2c = new HashMap<>();
        for (int i = 0; i < ps.length; i++) {
            if (s2c.containsKey(ss[i]) && s2c.get(ss[i]) != ps[i]) {
                return false;
            }
            if (c2s.containsKey(ps[i]) && !c2s.get(ps[i]).equals(ss[i])) {
                return false;
            }
            s2c.put(ss[i], ps[i]);
            c2s.put(ps[i], ss[i]);
        }

        return true;
    }
}
