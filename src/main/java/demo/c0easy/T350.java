package demo.c0easy;

import java.util.*;

/**
 * 350 两个数组的交集2 https://leetcode.cn/problems/intersection-of-two-arrays-ii/
 * 给定两个数组nums1和nums2，以数组的形式返回两数组的交集，返回结果中每个元素出现的次数
 * 应与元素在两个数组中都出现的次数一致
 *
 * 示例：
 * 输入1：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出1：[2,2]
 *
 * 输入2：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出2：[4,9]
 */
public class T350 {
    /**
     * 自己实现：排序+双指针
     */
    public int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0;
        int index2 = 0;
        int l1 = nums1.length;
        int l2 = nums2.length;
        //返回结果及其索引
        int[] ans = new int[l1 + l2];
        int index = 0;

        while (index1 < l1 && index2 < l2) {
            int num1 = nums1[index1];
            int num2 = nums2[index2];

            if (num1 == num2) {
                ans[index] = num1;
                index++;
                //向前移动指针
                index1++;
                index2++;
            } else if (num1 < num2) {
                index1++;
            } else {
                index2++;
            }
        }

        //去除多余的0
        return Arrays.copyOfRange(ans, 0, index);
    }

    /**
     * 官方解法：哈希表
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;

        //把长度小的数组放前边
        if (l1 > l2) {
            return intersect2(nums2, nums1);
        }

        Map<Integer, Integer> map = new HashMap<>();

        //记录长度小的数组中每个数出现的次数
        for (int n1 : nums1) {
            int count = map.getOrDefault(n1, 0) + 1;
            map.put(n1, count);
        }

        //返回结果，最长肯定不会超过参数中短的那个数组
        int[] ans = new int[l1];
        int index = 0;

        for (int n2 : nums2) {
            //如果数组2中出现与数组1中重复的数字
            int count = map.getOrDefault(n2, 0);
            if (count > 0) {
                ans[index] = n2;
                index++;
                count--;
                //如果只出现一次，将其从map中剔除，因为最多该数只会重复一次
                if (count > 0) {
                    map.put(n2, count);
                } else {
                    map.remove(n2);
                }
            }
        }

        //去除多余的0
        return Arrays.copyOfRange(ans, 0, index);
    }
}
