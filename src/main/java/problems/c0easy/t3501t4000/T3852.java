package problems.c0easy.t3501t4000;

/**
 * 3852 不同频率的最小数对 https://leetcode.cn/problems/smallest-pair-with-different-frequencies/description/
 * 给你一个整数数组 nums。
 * 从 nums 中找出两个 互不相同 的值 x 和 y，使得：
 * x < y
 * x 和 y 在 nums 中的频率不同。
 * 在所有满足条件的数对中：
 * 选择 x 的值尽可能小的数对。
 * 如果存在多个 x 相同的数对，选择 y 的值尽可能小的那个。
 * 返回一个整数数组 [x, y]。如果不存在有效的数对，返回 [-1, -1]。
 * 一个值 x 的 频率 是指它在数组中出现的次数。
 *
 * 示例：
 * 输入1：nums = [1,1,2,2,3,4]
 * 输出1：[1,3]
 *
 * 输入2：nums = [1,5]
 * 输出2：[-1,-1]
 *
 * 输入3：nums = [7]
 * 输出3：[-1,-1]
 *
 * 提示：
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
public class T3852 {
    /**
     * 自己实现：统计不同数字出现的次数即可
     */
    public int[] minDistinctFreqPair(int[] nums) {
        int[] cnt = new int[101];

        for (int num : nums) {
            cnt[num]++;
        }

        int min = -1;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > 0) {
                // 找到最小的数
                if (min == -1) {
                    min = i;
                }
                if (cnt[i] != cnt[min]) {
                    return new int[]{min, i};
                }
            }
        }

        return new int[]{-1, -1};
    }
}
