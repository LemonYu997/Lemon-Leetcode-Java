package problems.c0easy.t3501t4000;

import java.util.Arrays;

/**
 * 3774 最大和最小 K 个元素的绝对差 https://leetcode.cn/problems/absolute-difference-between-maximum-and-minimum-k-elements/description/
 * 给你一个整数数组 nums 和一个整数 k。
 * 请计算以下两者的绝对差值：
 * 数组中 k 个 最大 元素的总和；
 * 数组中 k 个 最小 元素的总和。
 * 返回表示此差值的整数。
 *
 * 示例：
 * 输入1：nums = [5,2,2,4], k = 2
 * 输出1： 5
 *
 * 输入2：nums = [100], k = 1
 * 输出2：0
 */
public class T3774 {
    /**
     * 自己实现：先排序再找最大的k个数和最小的k个数
     */
    public int absDifference(int[] nums, int k) {
        int sumMax = 0;
        int sumMin = 0;

        Arrays.sort(nums);

        for (int i = 0; i < k; i++) {
            sumMin += nums[i];
        }

        for (int i = nums.length - k; i < nums.length; i++) {
            sumMax += nums[i];
        }

        return sumMax - sumMin;
    }
}
