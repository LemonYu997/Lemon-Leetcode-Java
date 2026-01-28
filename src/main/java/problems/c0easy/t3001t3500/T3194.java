package problems.c0easy.t3001t3500;

import java.util.Arrays;

/**
 * 3194 最小元素和最大元素的最小平均值 https://leetcode.cn/problems/minimum-average-of-smallest-and-largest-elements/description/
 * 你有一个初始为空的浮点数数组 averages。另给你一个包含 n 个整数的数组 nums，其中 n 为偶数。
 * 你需要重复以下步骤 n / 2 次：
 * 从 nums 中移除 最小 的元素 minElement 和 最大 的元素 maxElement。
 * 将 (minElement + maxElement) / 2 加入到 averages 中。
 * 返回 averages 中的 最小 元素。
 *
 * 示例：
 * 输入1：nums = [7,8,3,4,15,13,4,1]
 * 输出1：5.5
 *
 * 输入2：nums = [1,9,8,3,10,5]
 * 输出2：5.5
 */
public class T3194 {
    /**
     * 官方解法：数学运算
     */
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        double res = Double.MAX_VALUE;
        for (int i = 0; i < n / 2; i++) {
            res = Math.min(res, (nums[i] + nums[n - 1 - i]) / 2.0);
        }
        return res;
    }
}
