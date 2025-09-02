package problems.c0easy.t2501t3000;

import java.util.HashSet;
import java.util.Set;

/**
 * 2716 最小化字符串长度 https://leetcode.cn/problems/minimize-string-length/description/
 * 给你一个下标从 0 开始的字符串 s ，重复执行下述操作 任意 次：
 * 在字符串中选出一个下标 i ，并使 c 为字符串下标 i 处的字符。
 * 并在 i 左侧（如果有）和 右侧（如果有）各 删除 一个距离 i 最近 的字符 c 。
 * 请你通过执行上述操作任意次，使 s 的长度 最小化 。
 * 返回一个表示 最小化 字符串的长度的整数。
 *
 * 示例：
 * 输入1：s = "aaabc"
 * 输出1：3
 *
 * 输入2：s = "cbbd"
 * 输出2：3
 *
 * 输入3：s = "dddaaa"
 * 输出3：2
 */
public class T2716 {
    /**
     * 自己实现：即统计不同的字符数即可
     */
    public int minimizedStringLength(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }

        return set.size();
    }


    /**
     * 官方解法：使用位运算
     */
    public int minimizedStringLength1(String s) {
        // int 32 位足够统计 26 个字母
        int mask = 0;
        for (char c : s.toCharArray()) {
            mask |= (1 << (c - 'a'));
        }
        return Integer.bitCount(mask);
    }
}