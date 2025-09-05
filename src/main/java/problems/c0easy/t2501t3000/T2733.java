package problems.c0easy.t2501t3000;

import java.util.Arrays;

/**
 * 2733 既不是最小值也不是最大值 https://leetcode.cn/problems/neither-minimum-nor-maximum/description/
 * 给你一个整数数组 nums ，数组由 不同正整数 组成，请你找出并返回数组中 任一 既不是 最小值 也不是 最大值 的数字，
 * 如果不存在这样的数字，返回 -1 。
 *
 * 返回所选整数。
 *
 * 示例：
 * 输入1：nums = [3,2,1,4]
 * 输出1：2
 *
 * 输入2：nums = [1,2]
 * 输出2：-1
 *
 * 输入3：nums = [2,1,3]
 * 输出3：2
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * nums 中的所有数字互不相同
 */
public class T2733 {
    /**
     * 自己实现：根据题意模拟
     */
    public int findNonMinOrMax(int[] nums) {
        // 先找到最大值和最小值，再取一个非最大值和最小值的数
        int max = -1;
        int min = 101;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != max && nums[i] != min) {
                return nums[i];
            }
        }

        return -1;
    }

    /**
     * 社区解法：根据题目设计指定优化
     */
    public int findNonMinOrMax1(int[] nums) {
        // 因为题目各个数字都不相同，因此只需要对前三位排序即可
        if (nums.length < 3) {
            return -1;
        }
        Arrays.sort(nums, 0, 3);
        // 取中间那位即可
        return nums[1];
    }
}