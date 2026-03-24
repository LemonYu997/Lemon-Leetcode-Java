package problems.c0easy.t3001t3500;

import java.util.List;

/**
 * 3364 最小正和子数组 https://leetcode.cn/problems/minimum-positive-sum-subarray/description/
 * 给你一个整数数组 nums 和 两个 整数 l 和 r。你的任务是找到一个长度在 l 和 r 之间（包含）且和大于 0 的 子数组 的 最小 和。
 * 返回满足条件的子数组的 最小 和。如果不存在这样的子数组，则返回 -1。
 * 子数组 是数组中的一个连续 非空 元素序列。
 *
 * 示例：
 * 输入1：nums = [3, -2, 1, 4], l = 2, r = 3
 * 输出1：1
 *
 * 输入2： nums = [-2, 2, -3, 1], l = 2, r = 3
 * 输出2：-1
 *
 * 输入3： nums = [1, 2, 3, 4], l = 2, r = 4
 * 输出3：3
 */
public class T3364 {
    /**
     * 自己实现：根据题意模拟即可
     */
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        Integer[] a = nums.toArray(new Integer[0]);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= a.length - l; i++) {
            int s = 0;
            for (int j = i; j < a.length && j - i + 1 <= r; j++) {
                s += a[j];
                if (s > 0 && j - i + 1 >= l) {
                    ans = Math.min(ans, s);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
