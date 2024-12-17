package problems.c0easy.t1501t2000;

/**
 * 1897 重新分配字符使所有字符串都相等 https://leetcode.cn/problems/redistribute-characters-to-make-all-strings-equal/description/
 * 给你一个字符串数组 words（下标 从 0 开始 计数）。
 * 在一步操作中，需先选出两个 不同 下标 i 和 j，
 * 其中 words[i] 是一个非空字符串，接着将 words[i] 中的 任一 字符移动到 words[j] 中的 任一 位置上。
 * 如果执行任意步操作可以使 words 中的每个字符串都相等，返回 true ；否则，返回 false 。
 *
 * 示例：
 * 输入1：words = ["abc","aabc","bc"]
 * 输出1：true
 *
 * 输入2：words = ["ab","a"]
 * 输出2：false
 */
public class T1897 {
    /**
     * 自己实现：统计每个字符的出现次数，并判断其是否满足 words.length 的倍数
     */
    public boolean makeEqual(String[] words) {
        // 记录每个字母出现的次数
        int[] temp = new int[26];
        int n = words.length;
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                temp[word.charAt(i) - 'a']++;
            }
        }

        // 判断是否满足 n 的倍数
        for (int i : temp) {
            if (i % n != 0) {
                return false;
            }
        }

        return true;
    }
}
