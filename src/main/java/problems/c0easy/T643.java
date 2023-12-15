package problems.c0easy;

/**
 * 643 子数组的最大平均数 https://leetcode.cn/problems/maximum-average-subarray-i/
 * 给定一个由 n 个元素组成的整数数组nums和一个整数k
 * 找出平均数最大且长度为k的连续子数组，并输出该最大平均数
 *
 * 示例：
 * 输入1：nums = [1,12,-5,-6,50,3], k = 4
 * 输出1：12.75
 *
 * 输入2：nums = [5], k = 1
 * 输出2：5.00000
 */
public class T643 {
    /**
     * 自己实现：滑动窗口
     * 求出最大和即求出最大平均数
     */
    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;
        //往前移动一位，去掉上一次窗口最左侧的值，加上当前窗口右侧的值
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(sum, maxSum);
        }

        return (double) maxSum / k;
    }
}
