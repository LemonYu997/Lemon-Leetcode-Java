package problems.c0easy.t2501t3000;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 2506 统计相似字符串对的数目 https://leetcode.cn/problems/count-pairs-of-similar-strings/description/
 * 给你一个下标从 0 开始的字符串数组 words 。
 * 如果两个字符串由相同的字符组成，则认为这两个字符串 相似 。
 * 例如，"abca" 和 "cba" 相似，因为它们都由字符 'a'、'b'、'c' 组成。
 * 然而，"abacba" 和 "bcfd" 不相似，因为它们不是相同字符组成的。
 * 请你找出满足字符串 words[i] 和 words[j] 相似的下标对 (i, j) ，
 * 并返回下标对的数目，其中 0 <= i < j <= words.length - 1 。
 *
 * 示例：
 * 输入1：words = ["aba","aabb","abcd","bac","aabc"]
 * 输出1：2
 *
 * 输入2：words = ["aabb","ab","ba"]
 * 输出2：3
 *
 * 输入3：words = ["nba","cba","dba"]
 * 输出3：0
 */
public class T2506 {
    /**
     * 官方解法：哈希表 + 位运算
     * 用 int 26 位计算出现的是否出现 26 个字母
     */
    public int similarPairs(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;

        for (String word : words) {
            // 记录当前单词出现的字母
            int temp = 0;
            int length = word.length();

            // 位运算
            for (int i = 0; i < length; i++) {
                char c = word.charAt(i);
                temp |= 1 << (c - 'a');
            }
            // 计算该种类型出现次数，每多出现一次就会配对情况累加以前的出现次数
            ans += map.getOrDefault(temp, 0);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        return ans;
    }
}
