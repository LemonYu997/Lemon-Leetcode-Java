package problems.c0easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 205 同构字符串 https://leetcode.cn/problems/isomorphic-strings/
 * 给定两个字符串s和t，判断它们是否是同构的
 * 如果s中的字符可以按某种映射关系替换得到t，那么就认为它是同构的
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。
 * 不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 * 示例：
 * 输入1：s = "egg", t = "add"
 * 输出1：true
 *
 * 输入2：s = "foo", t = "bar"
 * 输出2：false
 *
 * 输入3：s = "paper", t = "title"
 * 输出3：true
 */
public class T205 {
    /**
     * 自己实现：同时遍历两个字符串，以每次首先遇到的字符作为映射关系
     * 如果之后遇到不同的映射关系，就返回false
     */
    public boolean isIsomorphic(String s, String t) {
        //长度不一致肯定排除
        if (s.length() != t.length()) {
            return false;
        }

        //使用两个map来存储映射关系
        Map<Character, Character> maps = new HashMap<>();
        Map<Character, Character> mapt = new HashMap<>();

        char[] scs = s.toCharArray();
        char[] tcs = t.toCharArray();

        for (int i = 0; i < scs.length; i++) {
            char sc = scs[i];
            char tc = tcs[i];
            if ((maps.containsKey(sc) && maps.get(sc) != tc) || (mapt.containsKey(tc) && mapt.get(tc) != sc)) {
                return false;
            }
            maps.put(sc, tc);
            mapt.put(tc, sc);
        }

        return true;
    }
}
