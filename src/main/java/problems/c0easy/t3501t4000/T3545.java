package problems.c0easy.t3501t4000;

import java.util.Arrays;

/**
 * 3545 不同字符数量最多为 K 时的最少删除数 https://leetcode.cn/problems/minimum-deletions-for-at-most-k-distinct-characters/description/
 * 给你一个字符串 s（由小写英文字母组成）和一个整数 k。
 * 你的任务是删除字符串中的一些字符（可以不删除任何字符），使得结果字符串中的 不同字符数量 最多为 k。
 * 返回为达到上述目标所需删除的 最小 字符数量。
 *
 * 示例：
 * 输入1：s = "abc", k = 2
 * 输出1：1
 *
 * 输入2：s = "aabb", k = 2
 * 输出2：0
 *
 * 输入3：s = "yyyzz", k = 1
 * 输出3：2
 */
public class T3545 {
    /**
     * 自己实现：统计所有字符对应个数，只保留个数最多的前 k 种，其他全删掉
     */
    public int minDeletion(String s, int k) {
        int[] temp = new int[26];
        for (int i = 0; i < s.length(); i++) {
            temp[s.charAt(i) - 'a']++;
        }
        Arrays.sort(temp);
        
        int ans = 0;
        for (int i = 0; i < 26 - k; i++) {
            ans += temp[i];
        }
        return ans;
    }
}
