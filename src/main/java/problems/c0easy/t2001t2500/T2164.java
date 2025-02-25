package problems.c0easy.t2001t2500;

import java.util.Arrays;
import java.util.Collections;

/**
 * 2164 对奇偶下标分别排序 https://leetcode.cn/problems/sort-even-and-odd-indices-independently/description/
 * 给你一个下标从 0 开始的整数数组 nums 。根据下述规则重排 nums 中的值：
 * 按 非递增 顺序排列 nums 奇数下标 上的所有值。
 * 举个例子，如果排序前 nums = [4,1,2,3] ，
 * 对奇数下标的值排序后变为 [4,3,2,1] 。奇数下标 1 和 3 的值按照非递增顺序重排。
 * 按 非递减 顺序排列 nums 偶数下标 上的所有值。
 * 举个例子，如果排序前 nums = [4,1,2,3] ，对偶数下标的值排序后变为 [2,1,4,3] 。
 * 偶数下标 0 和 2 的值按照非递减顺序重排。
 * 返回重排 nums 的值之后形成的数组。
 *
 * 示例：
 * 输入1：nums = [4,1,2,3]
 * 输出1：[2,3,4,1]
 *
 * 输入2：nums = [2,1]
 * 输出2：[2,1]
 */
public class T2164 {
    /**
     * 自己实现：分割成两个数组排序后再合并
     */
    public int[] sortEvenOdd(int[] nums) {
        int n = nums.length;
        // 为了后边能使用API倒序排序，这里需要使用 Integer
        Integer[] odds = new Integer[n / 2];
        // 判断原数组长度是奇数还是偶数，如果是偶数，偶数数组个数要多一个
        int[] evens;
        if (n % 2 == 0) {
            evens = new int[n / 2];
        } else {
            evens = new int[n / 2 + 1];
        }

        // 获取偶数位和奇数位数组
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                evens[i / 2] = nums[i];
            } else {
                odds[i / 2] = nums[i];
            }
        }

        // 偶数递增
        Arrays.sort(evens);
        // 奇数递减
        Arrays.sort(odds, Collections.reverseOrder());

        // 将排序后的数组填充进原数组
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = evens[i / 2];
            } else {
                nums[i] = odds[i / 2];
            }
        }

        return nums;
    }
}
