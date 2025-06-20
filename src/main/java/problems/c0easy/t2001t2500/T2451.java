package problems.c0easy.t2001t2500;

import java.util.*;

/**
 * 2451 差值数组不同的字符串 https://leetcode.cn/problems/odd-string-difference/description/
 * 给你一个字符串数组 words ，每一个字符串长度都相同，令所有字符串的长度都为 n 。
 * 每个字符串 words[i] 可以被转化为一个长度为 n - 1 的 差值整数数组 difference[i] ，
 * 其中对于 0 <= j <= n - 2 有 difference[i][j] = words[i][j+1] - words[i][j] 。
 * 注意两个字母的差值定义为它们在字母表中 位置 之差，也就是说 'a' 的位置是 0 ，'b' 的位置是 1 ，'z' 的位置是 25 。
 * 比方说，字符串 "acb" 的差值整数数组是 [2 - 0, 1 - 2] = [2, -1] 。
 * words 中所有字符串 除了一个字符串以外 ，其他字符串的差值整数数组都相同。你需要找到那个不同的字符串。
 * 请你返回 words中 差值整数数组 不同的字符串。
 *
 * 示例：
 * 输入1：words = ["adc","wzy","abc"]
 * 输出1："abc"
 *
 * 输入2：words = ["aaa","bob","ccc","ddd"]
 * 输出2："bob"
 */
public class T2451 {
    public static void main(String[] args) {
        String[] sss = new String[]{"adc", "wzy", "abc"};
        oddString(sss);
    }

    /**
     * 自己实现：根据题意模拟
     */
    public static String oddString(String[] words) {
        int m = words.length;
        int n = words[0].length();
        int[][] difference = new int[m][n - 1];
        // 初始值出现的次数
        int count = 0;
        String temp1 = "";
        String temp2 = "";

        // 遍历每一个数组
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                difference[i][j - 1] = words[i].charAt(j) - words[i].charAt(j - 1);
            }

            if (i == 0) {
                count++;
                temp1 = words[i];
            } else {
                // 记录当前值是否与初始值相同，如果不同则记录
                if (!Arrays.equals(difference[i], difference[0])) {
                    temp2 = words[i];
                } else {
                    count++;
                }
            }
        }

        // 如果初始值只出现了一次则返回初始值
        if (count == 1) {
            return temp1;
        }

        return temp2;
    }

    /**
     * 社区解法：使用哈希表
     */
    public static String oddString1(String[] words) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : words) {
            int m = word.length();
            char[] chars = new char[m - 1];

            for (int i = 0; i < m - 1; i++) {
                chars[i] = (char) (word.charAt(i + 1) - word.charAt(i));
            }
            String temp = String.valueOf(chars);
            map.computeIfAbsent(temp, k -> new ArrayList<>()).add(word);
        }

        for (List<String> value : map.values()) {
            if (value.size() == 1) {
                return value.get(0);
            }
        }

        return "";
    }
}
