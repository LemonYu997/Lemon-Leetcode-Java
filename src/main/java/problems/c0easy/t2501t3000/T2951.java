package problems.c0easy.t2501t3000;

import java.util.ArrayList;
import java.util.List;

/**
 * 2951 找出峰值 https://leetcode.cn/problems/find-the-peaks/description/
 * 给你一个下标从 0 开始的数组 mountain 。你的任务是找出数组 mountain 中的所有 峰值。
 * 以数组形式返回给定数组中 峰值 的下标，顺序不限 。
 * 注意：
 *
 * 峰值 是指一个严格大于其相邻元素的元素。
 * 数组的第一个和最后一个元素 不 是峰值。
 *
 * 示例：
 * 输入1：mountain = [2,4,4]
 * 输出1：[]
 *
 * 输入2：mountain = [1,4,3,8,5]
 * 输出2：[1,3]
 */
public class T2951 {
    /**
     * 自己实现：遍历一次即可
     */
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> ans = new ArrayList<Integer>();
        int n = mountain.length;
        for (int i = 1; i < n - 1; i++) {
            if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                ans.add(i);
            }
        }
        return ans;
    }
}
