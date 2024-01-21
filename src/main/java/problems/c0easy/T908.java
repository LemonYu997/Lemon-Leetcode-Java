package problems.c0easy;

import java.util.Arrays;

/**
 * 908 最小差值 I https://leetcode.cn/problems/smallest-range-i/
 * 给定一个整数数组 nums，和一个整数 k
 * 可以选择 0 <= i < nums.length 的任何索引 i 。
 * 将 nums[i] 改为 nums[i] + x ，其中 x 是一个范围为 [-k, k] 的整数。对于每个索引 i ，最多只能应用一次此操作。
 * nums 的分数是 nums 中最大元素和最小元素的差值
 * 对 nums 中的每个索引最多引用一次上述操作后，返回 nums 的最低分数
 *
 * 示例：
 * 输入1：nums = [1], k = 0
 * 输出1：0
 *
 * 输入2：nums = [0,10], k = 2
 * 输出2：6
 *
 * 输入3：nums = [1,3,6], k = 3
 * 输出3：0
 */
public class T908 {
    /**
     * 自己实现：
     * 如果最大元素和最小元素的差值小于等于 2k，那么可以将整个数组变为同一个数，结果为0
     * 如果最大元素和最小元素的差值大于 2k，那么结果是 最大元素 - 最小元素 - 2k
     * 综上：结果为 Max(最大元素 - 最小元素 - 2k, 0)
     */
    public int smallestRangeI(int[] nums, int k) {
        if (nums.length == 1) {
            return 0;
        }
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length - 1];

        return Math.max(max - min - 2 * k, 0);
    }

    /**
     * 官方解法：使用 Stream
     */
    public int smallestRangeI1(int[] nums, int k) {
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        return Math.max(max - min - 2 * k, 0);
    }
}
