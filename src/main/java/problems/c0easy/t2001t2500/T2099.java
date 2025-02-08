package problems.c0easy.t2001t2500;

import java.util.Arrays;

/**
 * 2099 找到和最大的长度为 K 的子序列 https://leetcode.cn/problems/find-subsequence-of-length-k-with-the-largest-sum/description/
 * 给你一个整数数组 nums 和一个整数 k 。
 * 你需要找到 nums 中长度为 k 的 子序列 ，且这个子序列的 和最大 。
 * 请你返回 任意 一个长度为 k 的整数子序列。
 * 子序列 定义为从一个数组里删除一些元素后，不改变剩下元素的顺序得到的数组。
 *
 * 示例：
 * 输入1：nums = [2,1,3,3], k = 2
 * 输出1：[3,3]
 *
 * 输入2：nums = [-1,-2,3,4], k = 3
 * 输出2：[-1,3,4]
 *
 * 输入3：nums = [3,4,3,3], k = 2
 * 输出3：[3,4]
 */
public class T2099 {
    /**
     * 官方解法：找到最大的 k 个数，排序数组并记录原下标
     */
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        // 存储数组和索引
        int idxMap[][] = new int[n][2];
        // 记录数组和索引
        for (int i = 0; i < n; i++) {
            idxMap[i][1] = nums[i];
            idxMap[i][0] = i;
        }

        // 按照 nums[i] 从大到小排
        Arrays.sort(idxMap, (a, b) -> b[1] - a[1]);
        // 按照索引从小到大排列
        Arrays.sort(idxMap, 0, k, (a, b) -> a[0] - b[0]);

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = idxMap[i][1];
        }
        return ans;
    }
}
