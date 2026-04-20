package problems.c0easy.t3001t3500;

/**
 * 3423 循环数组中相邻元素的最大差值 https://leetcode.cn/problems/maximum-difference-between-adjacent-elements-in-a-circular-array/description/
 * 给你一个 循环 数组 nums ，请你找出相邻元素之间的 最大 绝对差值。
 * 注意：一个循环数组中，第一个元素和最后一个元素是相邻的。
 *
 * 示例：
 * 输入1：nums = [1,2,4]
 * 输出1：3
 *
 * 输入2：nums = [-5,-10,-5]
 * 输出2：5
 */
public class T3423 {
    /**
     * 自己实现：根据题意模拟
     */
    public int maxAdjacentDistance(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int temp = Math.abs(nums[i] - nums[i + 1]);
            if (temp > ans) {
                ans = temp;
            }
        }
        if (Math.abs(nums[n - 1] - nums[0]) > ans) {
            ans = Math.abs(nums[n - 1] - nums[0]);
        }

        return ans;
    }


    /**
     * 官方解法：优化写法
     */
    public int maxAdjacentDistance1(int[] nums) {
        int n = nums.length;
        int res = Math.abs(nums[0] - nums[n - 1]);
        for (int i = 0; i < n - 1; ++i) {
            res = Math.max(res, Math.abs(nums[i] - nums[i + 1]));
        }
        return res;
    }
}