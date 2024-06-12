package problems.c0easy.t1001t1500;

/**
 * 1413 逐步求和得到正数的最小值 https://leetcode.cn/problems/minimum-value-to-get-positive-step-by-step-sum/description/
 * 给你一个整数数组 nums 。你可以选定任意的 正数 startValue 作为初始值。
 * 你需要从左到右遍历 nums 数组，并将 startValue 依次累加上 nums 数组中的值。
 * 请你在确保累加和始终大于等于 1 的前提下，选出一个最小的 正数 作为 startValue 。
 *
 * 输入1：nums = [-3,2,-3,4,2]
 * 输出1：5
 *
 * 输入2：nums = [1,2]
 * 输出2：1
 *
 * 输入3：nums = [1,-2,-3]
 * 输出3：5
 */
public class T1413 {
    /**
     * 官方解法：贪心。要满足所有 sum + startValue >= 1 即可
     * 那么相当于只需要累加和的最小值 sumMin + startValue >= 1
     * 即最小为 1 - sumMin
     */
    public int minStartValue(int[] nums) {
        int sum = 0;
        int sumMin = 0;
        for (int num : nums) {
            sum += num;
            sumMin = Math.min(sumMin, sum);
        }
        return 1 - sumMin;
    }
}
