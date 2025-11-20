package problems.c0easy.t2501t3000;

import java.util.ArrayList;
import java.util.List;

/**
 * 2942 查找包含给定字符的单词 https://leetcode.cn/problems/find-words-containing-character/description/
 * 给你一个下标从 0 开始的字符串数组 words 和一个字符 x 。
 * 请你返回一个 下标数组 ，表示下标在数组中对应的单词包含字符 x 。
 * 注意 ，返回的数组可以是 任意 顺序。
 *
 * 示例：
 * 输入1：words = ["leet","code"], x = "e"
 * 输出1：[0,1]
 *
 * 输入2：words = ["abc","bcd","aaaa","cbc"], x = "a"
 * 输出2：[0,2]
 *
 * 输入3：words = ["abc","bcd","aaaa","cbc"], x = "z"
 * 输出3：[]
 */
public class T2942 {
    /**
     * 自己实现：根据题意模拟
     */
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) != -1) {
                ans.add(i);
            }
        }
        return ans;
    }
}
