package problems.c0easy.t3001t3500;

import java.util.Arrays;

/**
 * 3010 将数组分成最小总代价的子数组 I https://leetcode.cn/problems/divide-an-array-into-subarrays-with-minimum-cost-i/description/
 * 给你一个长度为 n 的整数数组 nums 。
 * 一个数组的 代价 是它的 第一个 元素。比方说，[1,2,3] 的代价是 1 ，[3,4,1] 的代价是 3 。
 * 你需要将 nums 分成 3 个 连续且没有交集 的子数组。
 * 请你返回这些子数组的 最小 代价 总和 。
 *
 * 示例：
 * 输入1：nums = [1,2,3,12]
 * 输出1：6
 *
 * 输入2：nums = [5,4,3]
 * 输出2：12
 *
 * 输入3：nums = [10,3,1,1]
 * 输出3：12
 */
public class T3010 {
    /**
     * 自己实现：第一个子数组代价有一定为 nums[0]，找到剩下的两个数即可
     */
    public int minimumCost(int[] nums) {
        int cost1 = nums[0];
        int cost2 = Integer.MAX_VALUE;
        int cost3 = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= cost2) {
                cost3 = cost2;
                cost2 = nums[i];
            } else if (nums[i] <= cost3) {
                cost3 = nums[i];
            }
        }

        return cost1 + cost2 + cost3;
    }

    /**
     * 简单实现：排序后取值
     */
    public int minimumCost1(int[] nums) {
        Arrays.sort(nums, 1, nums.length);
        return nums[0] + nums[1] + nums[2];
    }
}