package problems.c0easy.t1t500;

import java.util.HashMap;
import java.util.Map;

/**
 * 389 找不同 https://leetcode.cn/problems/find-the-difference/
 * 给定两个字符串s和t，只包含小写字母
 * 字符串t由字符串s随机重排，在随机位置添加一个字母
 * 找出在t中被添加的字母
 *
 * 示例：
 * 输入1：s = "abcd", t = "abcde"
 * 输出1：e
 *
 * 输入2：s = "", t = "y"
 * 输出2：y
 */
public class T389 {
    /**
     * 自己实现：使用Map
     */
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        char[] scs = s.toCharArray();
        char[] tcs = t.toCharArray();

        //先把s所有字符放入map
        for (char c : scs) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //遍历t中字符
        for (char c : tcs) {
            //如果map中不存在或者其出现次数为0，即多余的字母
            if (!map.containsKey(c) || map.get(c) == 0) {
                return c;
            } else if (map.get(c) > 0) {
                //遍历过得字符在map中次数-1
                map.put(c, map.get(c) - 1);
            }
        }

        return 'a';
    }

    /**
     * 官方解法1：计数
     */
    public char findTheDifference1(String s, String t) {
        int[] cnt = new int[26];
        char[] scs = s.toCharArray();
        char[] tcs = t.toCharArray();

        for (char sc : scs) {
            cnt[sc - 'a']++;
        }

        for (char tc : tcs) {
            cnt[tc - 'a']--;
            if (cnt[tc - 'a'] < 0) {
                return tc;
            }
        }

        return ' ';
    }

    /**
     * 官方解法2：ASCII码求和
     */
    public char findTheDifference2(String s, String t) {
        int as = 0;
        int at = 0;
        char[] scs = s.toCharArray();
        char[] tcs = t.toCharArray();

        for (char sc : scs) {
            as += sc;
        }
        for (char tc : tcs) {
            at += tc;
        }

        return (char) (at - as);
    }
}
