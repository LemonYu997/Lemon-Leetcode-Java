package problems.c0easy.t2001t2500;

import java.util.Arrays;

/**
 * 2399 检查相同字母间的距离 https://leetcode.cn/problems/check-distances-between-same-letters/description/
 * 给你一个下标从 0 开始的字符串 s ，该字符串仅由小写英文字母组成，s 中的每个字母都 恰好 出现 两次 。
 * 另给你一个下标从 0 开始、长度为 26 的的整数数组 distance 。
 *
 * 字母表中的每个字母按从 0 到 25 依次编号（即，'a' -> 0, 'b' -> 1, 'c' -> 2, ... , 'z' -> 25）。
 *
 * 在一个 匀整 字符串中，第 i 个字母的两次出现之间的字母数量是 distance[i] 。
 * 如果第 i 个字母没有在 s 中出现，那么 distance[i] 可以 忽略 。
 *
 * 如果 s 是一个 匀整 字符串，返回 true ；否则，返回 false 。
 *
 * 示例：
 * 输入1：s = "abaccb", distance = [1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
 * 输出1：true
 *
 * 输入2：s = "aa", distance = [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
 * 输出2：false
 */
public class T2399 {
    /**
     * 自己实现：使用数组记录两个字母间隔的字符个数
     */
    public boolean checkDistances(String s, int[] distance) {
        int[] charDis = new int[26];
        // 因为s的起始索引也为0，这里最好把数组初值赋为-1
        Arrays.fill(charDis, -1);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果该字母尚未出现过，则记录出现位置
            if (charDis[c - 'a'] == -1) {
                charDis[c - 'a'] = i;
            } else {
                // 已经出现过时，则记录间隔字符个数
                charDis[c - 'a'] = i - charDis[c - 'a'] - 1;
            }
        }

        // 判断是否满足 distance
        for (int i = 0; i < distance.length; i++) {
            if (charDis[i] != -1 && charDis[i] != distance[i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * 官方解法：枚举
     */
    public boolean checkDistances1(String s, int[] distance) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && distance[s.charAt(i) - 'a'] != j - i - 1) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * 官方解法2：模拟
     */
    public boolean checkDistances2(String s, int[] distance) {
        // 只用记录每个字母出现的第一次索引
        int[] firstIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (firstIndex[idx] != 0 && i - firstIndex[idx] != distance[idx]) {
                return false;
            }

            // 记录索引时都 + 1，这样计算间隔时不用再 - 1，并且规避了 s 初始索引也为 0 导致上边判断失效的情况
            firstIndex[idx] = i + 1;
        }

        return true;
    }
}