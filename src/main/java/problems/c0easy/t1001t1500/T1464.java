package problems.c0easy.t1001t1500;

import java.util.Arrays;

/**
 * 1464 数组中两元素的最大乘积 https://leetcode.cn/problems/maximum-product-of-two-elements-in-an-array/description/
 * 给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，
 * 使 (nums[i]-1)*(nums[j]-1) 取得最大值。
 *
 * 请你计算并返回该式的最大值。
 *
 * 示例：
 * 输入1：nums = [3,4,5,2]
 * 输出1：12
 *
 * 输入2：nums = [1,5,4,5]
 * 输出2：16
 *
 * 输入3：nums = [3,7]
 * 输出3：12
 */
public class T1464 {
    /**
     * 自己实现：即取最大的前两个数即可
     * 先排序
     */
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return (nums[n - 1] - 1) * (nums[n - 2] - 1);
    }

    /**
     * 一次遍历取
     */
    public int maxProduct1(int[] nums) {
        int m1 = 0;
        int m2 = 0;

        for (int num : nums) {
            if (num > m1) {
                m2 = m1;
                m1 = num;
            } else if (num > m2) {
                m2 = num;
            }
        }

        return (m1 - 1) * (m2 - 1);
    }
}
