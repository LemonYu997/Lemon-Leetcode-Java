package problems.c0easy;

import java.util.Arrays;

/**
 * 1189 “气球” 的最大数量 https://leetcode.cn/problems/maximum-number-of-balloons/description/
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 * 字符串 text 中的每个字母最多只能被使用一次。
 * 请你返回最多可以拼凑出多少个单词 "balloon"。
 *
 * 示例：
 * 输入1：text = "nlaebolko"
 * 输出1：1
 *
 * 输入2：text = "loonbalxballpoon"
 * 输出2：2
 *
 * 输入3：text = "leetcode"
 * 输出3：0
 */
public class T1189 {
    /**
     * 自己实现：使用 int[] 存储字母数量
     */
    public int maxNumberOfBalloons(String text) {
        int[] dict = new int[26];
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            dict[c - 'a']++;
        }

        // 计算可以拼写多少个 balloon
        int ans = 0;
        String balloon = "balloon";
        while (true) {
            // 该次拼写成功标识
            boolean flag = true;
            for (int i = 0; i < balloon.length(); i++) {
                char c = balloon.charAt(i);
                dict[c - 'a']--;
                // 字母不足，拼写失败
                if (dict[c - 'a'] < 0) {
                    flag = false;
                    break;
                }
            }
            // 如果拼写失败，退出循环
            if (!flag) {
                break;
            }
            // 拼写成功，次数 + 1
            ans++;
        }
        return ans;
    }

    /**
     * 官方解法：只统计 balloon 中五个字母的个数
     */
    public int maxNumberOfBalloons1(String text) {
        int[] cnt = new int[5];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == 'b') {
                cnt[0]++;
            } else if (ch == 'a') {
                cnt[1]++;
            } else if (ch == 'l') {
                cnt[2]++;
            } else if (ch == 'o') {
                cnt[3]++;
            } else if (ch == 'n') {
                cnt[4]++;
            }
        }
        // 其中 l 和 o 各需要两次
        cnt[2] /= 2;
        cnt[3] /= 2;
        // 求cnt[]各元素的最小值即为目标
        return Arrays.stream(cnt).min().getAsInt();
    }
}
