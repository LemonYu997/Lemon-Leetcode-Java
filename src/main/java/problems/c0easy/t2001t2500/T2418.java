package problems.c0easy.t2001t2500;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2418 按身高排序 https://leetcode.cn/problems/sort-the-people/description/
 * 给你一个字符串数组 names ，和一个由 互不相同 的正整数组成的数组 heights 。
 * 两个数组的长度均为 n 。
 *
 * 对于每个下标 i，names[i] 和 heights[i] 表示第 i 个人的名字和身高。
 *
 * 请按身高 降序 顺序返回对应的名字数组 names 。
 *
 * 示例：
 * 输入1：names = ["Mary","John","Emma"], heights = [180,165,170]
 * 输出1：["Mary","Emma","John"]
 *
 * 输入2：names = ["Alice","Bob","Bob"], heights = [155,185,150]
 * 输出2：["Bob","Alice","Bob"]
 */
public class T2418 {
    /**
     * 自己实现：构建索引数组
     */
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // 将索引数组根据身高排序
        Arrays.sort(indices, (a , b) -> heights[b] - heights[a]);
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = names[indices[i]];
        }
        return res;
    }

    /**
     * 高效解法：使用 Map 记录
     */
    public String[] sortPeople1(String[] names, int[] heights) {
        int n = names.length;
        int index = 0;
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(heights[i], names[i]);
        }
        // 根据 key 排序
        Arrays.sort(heights);

        // 得到新结果
        String[] ans = new String[n];
        for (int i = n - 1; i >= 0; i--) {
            // 按身高倒序取值
            ans[index++] = map.get(heights[i]);
        }

        return ans;
    }
}
