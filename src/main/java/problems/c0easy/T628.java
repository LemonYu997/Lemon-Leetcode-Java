package problems.c0easy;

import java.util.Arrays;

/**
 * 628 三个数的最大乘积 https://leetcode.cn/problems/maximum-product-of-three-numbers/
 * 给定一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * 示例：
 * 输入1：nums = [1,2,3]
 * 输出1：6
 *
 * 输入2：nums = [1,2,3,4]
 * 输出2：24
 *
 * 输入3：nums = [-1,-2,-3]
 * 输出3：-6
 */
public class T628 {
    /**
     * 自己实现：要么找到最大的三个数，要么找到两个最小的负数和一个最大的数
     */
    public int maximumProduct(int[] nums) {
        // 找到最大的三个数
        Arrays.sort(nums);
        int n = nums.length;
        int max = nums[n - 1] * nums[n - 2] * nums[n - 3];
        if (nums[0] < 0 && nums[1] < 0) {
            //找到两个最小的负数和一个最大的数
            max = Math.max(max, nums[0] * nums[1] * nums[n - 1]);
        }
        return max;
    }

    /**
     * 官方解法：线性扫描
     * 只需要找到数组中最大的三个数和最小的两个数
     */
    public int maximumProduct1(int[] nums) {
        // 最小的两个数
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        // 最大的三个数
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }

            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
