package problems.c0easy;

import java.util.Arrays;

/**
 * 977 有序数组的平方 https://leetcode.cn/problems/squares-of-a-sorted-array/
 * 给定一个按 非递减顺序 排序的整数数组 nums，
 * 返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * 示例：
 * 输入1：nums = [-4,-1,0,3,10]
 * 输出1：[0,1,9,16,100]
 *
 * 输入2：nums = [-7,-3,2,3,11]
 * 输出2：[4,9,9,49,121]
 */
public class T977 {
    /**
     * 自己实现：先生成新数组，再排序
     */
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i] * nums[i];
        }

        Arrays.sort(ans);
        return ans;
    }

    /**
     * 官方解法：双指针，边平方边排序，利用原数组非递减的特性
     * 分别从首尾遍历，因为如果开头是负数有可能比结尾大
     * 将平方结果较大的倒序放入结果数组
     */
    public int[] sortedSquares1(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int i = 0;          //头指针
        int j = n - 1;      //尾指针
        int pos = n - 1;    //倒序指针
        while (i <= j) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                ans[pos] = nums[i] * nums[i];
                i++;
            } else {
                ans[pos] = nums[j] * nums[j];
                j--;
            }
            pos--;
        }
        return ans;
    }
}
