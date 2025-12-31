package problems.c0easy.t3001t3500;

/**
 * 3095 或值至少 K 的最短子数组 I https://leetcode.cn/problems/shortest-subarray-with-or-at-least-k-i/description/
 * 给你一个 非负 整数数组 nums 和一个整数 k 。
 * 如果一个数组中所有元素的按位或运算 OR 的值 至少 为 k ，那么我们称这个数组是 特别的 。
 * 请你返回 nums 中 最短特别非空 子数组的长度，如果特别子数组不存在，那么返回 -1 。
 *
 * 示例：
 * 输入1：nums = [1,2,3], k = 2
 * 输出1：1
 *
 * 输入2：nums = [2,1,8], k = 10
 * 输出2：3
 *
 * 输入3：nums = [1,2], k = 0
 * 输出3：1
 */
public class T3095 {
    /**
     * 官方解法：枚举
     */
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int value = 0;
            for (int j = i; j < n; j++) {
                value |= nums[j];
                if (value >= k) {
                    res = Math.min(res, j - i + 1);
                    break;
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
