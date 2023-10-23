package demo.c0easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 409 最长回文串 https://leetcode.cn/problems/longest-palindrome/
 * 给定一个包含大写字母和小写字母的字符串s，返回通过这些字母构造成的最长回文串的长度
 * 注意区分大小写
 *
 * 示例：
 * 输入1：s = "abccccdd"
 * 输出1：7
 * 备注：我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 *
 * 输入2：s = "a"
 * 输出2:1
 *
 * 输入3：s = "aaaaaccc"
 * 输出3：7
 */
public class T409 {
    /**
     * 自己实现：使用map
     * (字符出现次数 / 2) * 2可以把超出2的倍数的数值去除，即得到该字符能出现的回文长度
     * 所有单数情况只能加一个长度
     */
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //遍历每个字符出现的次数，计算回文长度
        int count = 0;
        //奇数字符最终只能算一次
        boolean flagOdd = true;
        for (Integer value : map.values()) {
            if (value % 2 == 1 && flagOdd) {
                count++;
                flagOdd = false;
            }

            count += (value / 2) * 2;
        }

        return count;
    }

    /**
     * 官方解法：贪心
     * 上述代码的更简洁实现
     */
    public int longestPalindrome1(String s) {
        //存储字符次数 ASIIC值作为索引
        int[] count = new int[128];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            count[c]++;
        }

        int ans = 0;
        for (int v : count) {
            ans += v / 2 * 2;
            //如果某个字符出现次数为奇数，而此时答案回文长度为偶数（说明还未计算奇数多加的那个1）
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }

        return ans;
    }
}
