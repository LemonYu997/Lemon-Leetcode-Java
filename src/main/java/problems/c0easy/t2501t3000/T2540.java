package problems.c0easy.t2501t3000;

/**
 * 2540 最小公共值 https://leetcode.cn/problems/minimum-common-value/description/
 * 给你两个整数数组 nums1 和 nums2 ，它们已经按非降序排序，请你返回两个数组的 最小公共整数 。
 * 如果两个数组 nums1 和 nums2 没有公共整数，请你返回 -1 。
 *
 * 如果一个整数在两个数组中都 至少出现一次 ，那么这个整数是数组 nums1 和 nums2 公共 的。
 *
 * 示例：
 * 输入1：nums1 = [1,2,3], nums2 = [2,4]
 * 输出1：2
 *
 * 输入2：nums1 = [1,2,3,6], nums2 = [2,3,4,5]
 * 输出2：2
 */
public class T2540 {
    /**
     * 自己实现：双指针同时遍历，找到最小的同时出现的值
     */
    public int getCommon(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                return nums1[i];
            }
        }

        return -1;
    }
}
