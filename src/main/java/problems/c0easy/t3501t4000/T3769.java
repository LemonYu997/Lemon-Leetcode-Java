package problems.c0easy.t3501t4000;

import java.util.Arrays;

/**
 * 3769 二进制反射排序 https://leetcode.cn/problems/sort-integers-by-binary-reflection/description/
 * 给你一个整数数组 nums。
 * 二进制反射 是对一个 正整数 的二进制表示按顺序反转（忽略前导零）后，将反转得到的二进制数转为十进制的结果。
 * 请按每个元素的二进制反射值的 升序 对数组进行排序。如果两个不同的数字具有相同的二进制反射值，则 较小 的原始数字应排在前面。
 * 返回排序后的数组。
 *
 * 示例：
 * 输入1：nums = [4,5,4]
 * 输出1：[4,4,5]
 *
 * 输入2：nums = [3,6,5,8]
 * 输出2：[8,3,6,5]
 */
public class T3769 {
    /**
     * 社区解法
     */
    public int[] sortByReflection(int[] nums) {
            Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);

            Arrays.sort(arr, (a, b) -> {
                int revA = Integer.reverse(a) >>> Integer.numberOfLeadingZeros(a);
                int revB = Integer.reverse(b) >>> Integer.numberOfLeadingZeros(b);
                return revA != revB ? revA - revB : a - b;
            });

            for (int i = 0; i < nums.length; i++) {
                nums[i] = arr[i];
            }
            return nums;
    }
}
