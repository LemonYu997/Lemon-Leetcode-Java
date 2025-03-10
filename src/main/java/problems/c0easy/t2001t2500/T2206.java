package problems.c0easy.t2001t2500;

import java.util.Arrays;

/**
 * 2206 将数组划分成相等数对 https://leetcode.cn/problems/divide-array-into-equal-pairs/description/
 * 给你一个整数数组 nums ，它包含 2 * n 个整数。
 * 你需要将 nums 划分成 n 个数对，满足：
 *
 * 每个元素 只属于一个 数对。
 * 同一数对中的元素 相等 。
 * 如果可以将 nums 划分成 n 个数对，请你返回 true ，否则返回 false 。
 *
 * 示例：
 * 输入1：nums = [3,2,3,2,2,2]
 * 输出1：true
 *
 * 输入2：nums = [1,2,3,4]
 * 输出2：false
 *
 * 提示：
 * nums.length == 2 * n
 * 1 <= n <= 500
 * 1 <= nums[i] <= 500
 * */
public class T2206 {
    /**
     * 自己实现：先排序，然后判断相邻的两个数是否相等即可
     */
    public boolean divideArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i += 2) {
            if (nums[i] != nums[i - 1]) {
                return false;
            }
        }

        return true;
    }


    /**
     * 优化解法：使用数组存储每一个数的出现次数
     */
    public boolean divideArray1(int[] nums) {
        // 根据1 <= nums[i] <= 500
        int[] temp = new int[501];
        // 记录每一个数的出现次数
        for (int num : nums) {
            temp[num]++;
        }

        for (int t : temp) {
            if (t % 2 != 0) {
                return false;
            }
        }

        return true;
    }
}
