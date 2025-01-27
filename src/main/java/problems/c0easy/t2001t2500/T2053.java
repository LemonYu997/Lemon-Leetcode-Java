package problems.c0easy.t2001t2500;

import java.util.HashMap;
import java.util.Map;

/**
 * 2053 数组中第 K 个独一无二的字符串 https://leetcode.cn/problems/kth-distinct-string-in-an-array/description/
 * 独一无二的字符串 指的是在一个数组中只出现过 一次 的字符串。
 *
 * 给你一个字符串数组 arr 和一个整数 k ，请你返回 arr 中第 k 个 独一无二的字符串 。
 * 如果 少于 k 个独一无二的字符串，那么返回 空字符串 "" 。
 *
 * 注意，按照字符串在原数组中的 顺序 找到第 k 个独一无二字符串。
 *
 * 示例：
 * 输入1：arr = ["d","b","c","b","c","a"], k = 2
 * 输出1："a"
 *
 * 输入2：arr = ["aaa","aa","a"], k = 1
 * 输出2："aaa"
 *
 * 输入3：arr = ["a","b","a"], k = 3
 * 输出3：""
 */
public class T2053 {
    /**
     * 自己实现：使用 map 统计
     */
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : arr) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // 遍历 arr，寻找第 k 个独一无二的字符串
        for (String s : arr) {
            if (map.get(s) == 1) {
                if (k == 1) {
                    return s;
                } else {
                    k--;
                }
            }
        }

        return "";
    }
}
