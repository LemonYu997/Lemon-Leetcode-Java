package problems.c0easy.t2001t2500;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2441 与对应负数同时存在的最大正整数 https://leetcode.cn/problems/largest-positive-integer-that-exists-with-its-negative/description/
 * 给你一个 不包含 任何零的整数数组 nums ，找出自身与对应的负数都在数组中存在的最大正整数 k 。
 *
 * 返回正整数 k ，如果不存在这样的整数，返回 -1 。
 *
 * 示例：
 * 输入1：nums = [-1,2,-3,3]
 * 输出1：3
 *
 * 输入2：nums = [-1,10,6,7,-7,1]
 * 输出2：7
 *
 * 输入3：nums = [-10,8,6,7,-2,-3]
 * 输出3：-1
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * nums[i] != 0
 */
public class T2441 {
    /**
     * 自己实现：使用数组统计
     */
    public int findMaxK(int[] nums) {
        int[] temp = new int[2001];
        int ans = -1;
        for (int num : nums) {
            // 找到其对应的正数或负数是否存在
            if (temp[1000 - num] == 1) {
                ans = Math.max(ans, Math.abs(num));
            }
            temp[num + 1000] = 1;
        }

        return ans;
    }

    /**
     * 官方解法：排序 + 双指针
     */
    public int findMaxK1(int[] nums) {
        Arrays.sort(nums);
        // 双指针，一个向前遍历一个向后遍历
        for (int i = 0, j = nums.length - 1; i < j; j--) {
            // 如果当前小一点的数比起另一边对应的相反数还要小，则向前移动
            while (i < j && nums[i] < -nums[j]) {
                i++;
            }
            // 因为已经排序过，所以第一个找到的就是最大值
            if (nums[i] == -nums[j]) {
                return nums[j];
            }
        }

        return -1;
    }
}