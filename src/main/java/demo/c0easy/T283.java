package demo.c0easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 283 移动零 https://leetcode.cn/problems/move-zeroes/
 * 给定一个数组，编写一个函数将所有0移动到数组的末尾，同时保证非零元素相对顺序
 *
 * 示例：
 * 输入1：nums = [0,1,0,3,12]
 * 输出1：[1,3,12,0,0]
 *
 * 输入2： nums = [0]
 * 输出2：[0]
 */
public class T283 {
    /**
     * 自己实现：使用另一个数组中介
     * 不符合题目要求（不复制数组），放弃
     */
    public void moveZeroes(int[] nums) {
        int l = nums.length;
        List<Integer> temp = new ArrayList<>();
        //出现0的个数
        int count = 0;

        for (int i = 0; i < l; i++) {
            if (nums[i] != 0) {
                temp.add(nums[i]);
            } else {
                count++;
            }
        }

        for (int i = 0; i < count; i++) {
            temp.add(0);
        }

        nums = temp.stream().mapToInt(Integer::valueOf).toArray();
    }

    /**
     * 官方解法：双指针
     */
    public void moveZeroes1(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;

        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
