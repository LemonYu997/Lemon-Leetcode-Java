package problems.c0easy.t3501t4000;

/**
 * 3674 数组元素相等的最小操作次数 https://leetcode.cn/problems/minimum-operations-to-equalize-array/description/
 * 给你一个长度为 n 的整数数组 nums。
 * 在一次操作中，可以选择任意子数组 nums[l...r] （0 <= l <= r < n），
 * 并将该子数组中的每个元素 替换 为所有元素的 按位与（bitwise AND）结果。
 * 返回使数组 nums 中所有元素相等所需的最小操作次数。
 * 子数组 是数组中连续的、非空的元素序列。
 *
 * 示例：
 * 输入1：nums = [1,2]
 * 输出1：1
 *
 * 输入2：nums = [5,5,5]
 * 输出2：0
 */
public class T3674 {
    /**
     * 社区解法：脑筋急转弯
     */
    public int minOperations(int[] nums) {
        for (int num : nums) {
            // 如果原数组有不相等的，只需要操作整个数组一次就可以保证相等
            if (num != nums[0]) {
                return 1;
            }
        }
        // 原数组相等的时候直接返回0
        return 0;
    }
}
