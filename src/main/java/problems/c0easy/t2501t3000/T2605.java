package problems.c0easy.t2501t3000;

import java.util.Arrays;

/**
 * 2605 从两个数字数组里生成最小数字 https://leetcode.cn/problems/form-smallest-number-from-two-digit-arrays/description/
 * 给你两个只包含 1 到 9 之间数字的数组 nums1 和 nums2 ，每个数组中的元素 互不相同 ，
 * 请你返回 最小 的数字，两个数组都 至少 包含这个数字的某个数位。
 *
 * 示例：
 * 输入1：nums1 = [4,1,3], nums2 = [5,7]
 * 输出1：15
 *
 * 输入2：nums1 = [3,5,2,6], nums2 = [3,1,7]
 * 输出2：3
 */
public class T2605 {
    /**
     * 自己实现：优先选择共同的最小数字
     */
    public int minNumber(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        // 优先选择共同的最小数字
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                return nums1[i];
            }
        }

        // 没有共同数字则选择两个最小的数字
        if (nums1[0] < nums2[0]) {
            return nums1[0] * 10 + nums2[0];
        } else {
            return nums2[0] * 10 + nums1[0];
        }
    }
}
