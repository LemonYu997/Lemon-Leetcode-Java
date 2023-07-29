package demo.c0easy;

import java.util.Arrays;

/**
 * 88  合并两个有序数组  https://leetcode.cn/problems/merge-sorted-array/
 * 给定两个非递减顺序排列数组 nums1 和 nums2，以及两个整数 m 和 n 表示两个数组中的元素数。
 * 将 nums2 合并到 nums1 中，按非递减顺序排列
 * 这个数组不返回，而是会校验 nums1 ，其初始长度为 m + n，超出的数据为 0
 *
 * 示例1：
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 *
 * 示例2：
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 *
 * 示例3：
 * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
 * 输出：[1]
 */
public class T88 {
    /**
     * 自己实现：暴力法，将nums2全部数据先放到 nums1 后边，再重新排序
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        //将nums2放入nums1中
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }

        //对nums1重新排序，调用API
//        Arrays.sort(nums1);

        //冒泡排序
        bubbleSort(nums1);
    }

    /**
     * 冒泡排序
     */
    public void bubbleSort(int[] arr) {
        int len = arr.length;
        if (len < 2) {
            return;
        }

        int temp = 0;

        //遍历每个元素，比较相邻的元素，如果第一个比第二个大，就进行交换
        //每轮循环结束后最大的那个元素就会放在最后
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                //将大的元素向后放
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
