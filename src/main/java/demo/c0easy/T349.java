package demo.c0easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 349 两个数组的交集 https://leetcode.cn/problems/intersection-of-two-arrays/
 * 给定两个数组nums1和nums2，返回它们的交集。
 * 输出结果中每一个元素一定是唯一的，不用考虑输出顺序
 *
 * 示例：
 * 输入1：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出1：[2]
 *
 * 输入2：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出2：[9,4]
 */
public class T349 {
    /**
     * 自己实现：暴力循环
     */
    public int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        for (int n1 : nums1) {
            for (int n2 : nums2) {
                if (n1 == n2) {
                    set.add(n1);
                }
            }
        }

        return set.stream().mapToInt(Integer::valueOf).toArray();
    }

    /**
     * 官方解法：排序+双指针
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0;
        int index2 = 0;
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[] ans = new int[l1 + l2];
        int index = 0;

        while (index1 < l1 && index2 < l2) {
            int num1 = nums1[index1];
            int num2 = nums2[index2];

            if (num1 == num2) {
                if (index == 0 || num1 != ans[index - 1]) {
                    ans[index] = num1;
                    index++;
                }
                index1++;
                index2++;
            } else if (num1 < num2) {
                index1++;
            } else {
                index2++;
            }
        }

        return Arrays.copyOfRange(ans, 0, index);
    }
}
