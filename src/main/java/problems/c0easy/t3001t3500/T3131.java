package problems.c0easy.t3001t3500;

import java.util.Arrays;

/**
 * 3131 找出与数组相加的整数 I https://leetcode.cn/problems/find-the-integer-added-to-array-i/description/
 * 给你两个长度相等的数组 nums1 和 nums2。
 * 数组 nums1 中的每个元素都与变量 x 所表示的整数相加。如果 x 为负数，则表现为元素值的减少。
 * 在与 x 相加后，nums1 和 nums2 相等 。当两个数组中包含相同的整数，并且这些整数出现的频次相同时，两个数组 相等 。
 * 返回整数 x 。
 *
 * 示例：
 * 输入1：nums1 = [2,6,4], nums2 = [9,7,5]
 * 输出1：3
 *
 * 输入2：nums1 = [10], nums2 = [5]
 * 输出2：-5
 *
 * 输入3：nums1 = [1,1,1,1], nums2 = [1,1,1,1]
 * 输出3：0
 */
public class T3131 {
    /**
     * 自己实现：因为该X必存在，所以找到两个数组中的最小值，然后求差即可
     */
    public int addedInteger(int[] nums1, int[] nums2) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int num : nums1) {
            if (num < min1) {
                min1 = num;
            }
        }

        for (int num : nums2) {
            if (num < min2) {
                min2 = num;
            }
        }

        return min2 - min1;
    }

    /**
     * 官方解法：优化写法
     */
    public int addedInteger1(int[] nums1, int[] nums2) {
        return Arrays.stream(nums2).min().getAsInt() - Arrays.stream(nums1).min().getAsInt();
    }
}