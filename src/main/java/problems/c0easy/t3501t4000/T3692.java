package problems.c0easy.t3501t4000;

import java.util.HashMap;
import java.util.Map;

/**
 * 3692 众数频率字符 https://leetcode.cn/problems/majority-frequency-characters/description/
 * 给你一个由小写英文字母组成的字符串 s。
 * 对于一个值 k，频率组 是在 s 中恰好出现 k 次的字符集合。
 * 众数频率组 是包含 不同 字符数量最多的频率组。
 * 返回一个字符串，包含众数频率组中的所有字符，字符的顺序 不限 。
 * 如果两个或多个频率组的大小并列最大，则选择其频率 k 较大 的那个组。
 *
 * 示例：
 * 输入1：s = "aaabbbccdddde"
 * 输出1："ab"
 *
 * 输入2：s = "abcd"
 * 输出2："abcd"
 *
 * 输入3：s = "pfpfgi"
 * 输出3："fp"
 */
public class T3692 {
    /**
     * 自己实现：先统计每个字符出现次数，再将相同次数的组合在一起
     */
    public String majorityFrequencyGroup(String s) {
        // 统计每个字符出现次数
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'a']++;
        }
        // 根据不同次数统计，将出现相同次数的拼接字符串
        Map<Integer, String> map = new HashMap<>();
        int maxCount = 0;
        String ans = "";
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                String temp = "";
                char c = (char) (i + 'a');
                if (map.containsKey(count[i])) {
                    temp = map.get(count[i]) + c;
                } else {
                    temp = temp + c;
                }
                map.put(count[i], temp);

                // 优先选字符串长度更长的，一样长的话选出现次数更多的
                if (temp.length() > ans.length()) {
                    ans = temp;
                    maxCount = count[i];
                } else if (temp.length() == ans.length()) {
                    if (count[i] > maxCount) {
                        ans = temp;
                        maxCount = count[i];
                    }
                }
            }
        }
        return ans;
    }

    /**
     * 社区解法：优化写法
     */
    public String majorityFrequencyGroup1(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        Map<Integer, StringBuilder> groups = new HashMap<>();
        int mx = 0;
        for (int i = 0; i < 26; i++) {
            int c = cnt[i];
            if (c == 0) {
                continue;
            }
            groups.computeIfAbsent(c, k -> new StringBuilder()).append((char)('a' + i));
            if (mx == 0
                    || groups.get(c).length() > groups.get(mx).length()
                    || groups.get(c).length() == groups.get(mx).length()
            && c > mx) {
                mx = c;
            }
        }
        return groups.get(mx).toString();
    }
}
