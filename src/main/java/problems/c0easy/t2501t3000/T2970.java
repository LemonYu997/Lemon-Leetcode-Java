package problems.c0easy.t2501t3000;

/**
 * 2970 统计移除递增子数组的数目 I https://leetcode.cn/problems/count-the-number-of-incremovable-subarrays-i/description/
 * 给你一个下标从 0 开始的 正 整数数组 nums 。
 * 如果 nums 的一个子数组满足：移除这个子数组后剩余元素 严格递增 ，
 * 那么我们称这个子数组为 移除递增 子数组。比方说，[5, 3, 4, 6, 7] 中的 [3, 4] 是一个移除递增子数组，
 * 因为移除该子数组后，[5, 3, 4, 6, 7] 变为 [5, 6, 7] ，是严格递增的。
 * 请你返回 nums 中 移除递增 子数组的总数目。
 * 注意 ，剩余元素为空的数组也视为是递增的。
 * 子数组 指的是一个数组中一段非空且连续的元素序列。
 *
 * 示例：
 * 输入1：nums = [1,2,3,4]
 * 输出1：10
 *
 * 输入2：nums = [6,5,7,8]
 * 输出2：7
 *
 * 输入3：nums = [8,7,6,6]
 * 输出3：3
 */
public class T2970 {
    /**
     * 自己实现：
     */
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isIncreasing(nums, i, j)) {
                    res++;
                }
            }
        }
        return res;
    }

    public boolean isIncreasing(int[] nums, int l, int r) {
        for (int i = 1; i < nums.length; i++) {
            if (i >= l && i <= r + 1) {
                continue;
            }
            if (nums[i] <= nums[i - 1]) {
                return false;
            }
        }
        if (l - 1 >= 0 && r + 1 < nums.length && nums[r + 1] <= nums[l - 1]) {
            return false;
        }
        return true;
    }
}
