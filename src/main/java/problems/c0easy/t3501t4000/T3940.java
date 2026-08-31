package problems.c0easy.t3501t4000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3940 限制有序数组中的元素出现次数 https://leetcode.cn/problems/limit-occurrences-in-sorted-array/description/
 * 给你一个 按升序排序 的整数数组 nums 和一个整数 k。
 * 返回一个数组，使得每个 不同 元素最多出现 k 次，同时保持 nums 中元素的相对顺序不变。
 *
 * 示例：
 * 输入1：nums = [1,1,1,2,2,3], k = 2
 * 输出1：[1,1,2,2,3]
 *
 * 输入2：nums = [1,2,3], k = 1
 * 输出2：[1,2,3]
 */
public class T3940 {
    /**
     * 自己实现：根据题意模拟
     */
    public int[] limitOccurrences(int[] nums, int k) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(nums[0]);
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
                if (count <= k) {
                    list.add(nums[i]);
                }
            } else {
                count = 1;
                list.add(nums[i]);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    /**
     * 社区解法：原地双指针
     */
    public int[] limitOccurrences1(int[] nums, int k) {
        int stackSize = k;
        for (int i = k; i < nums.length; i++) {
            if (nums[i] != nums[stackSize - k]) {
                nums[stackSize++] = nums[i];
            }
        }
        return Arrays.copyOf(nums, stackSize);
    }
}