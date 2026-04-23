package problems.c0easy.t3001t3500;

/**
 * 3432 统计元素和差值为偶数的分区方案 https://leetcode.cn/problems/count-partitions-with-even-sum-difference/description/
 * 给你一个长度为 n 的整数数组 nums 。
 * 分区 是指将数组按照下标 i （0 <= i < n - 1）划分成两个 非空 子数组，其中：
 * 左子数组包含区间 [0, i] 内的所有下标。
 * 右子数组包含区间 [i + 1, n - 1] 内的所有下标。
 * 对左子数组和右子数组先求元素 和 再做 差 ，统计并返回差值为 偶数 的 分区 方案数。
 *
 * 示例：
 * 输入1：nums = [10,10,3,7,6]
 * 输出1：4
 *
 * 输入2：nums = [1,2,2]
 * 输出2：0
 *
 * 输入3：nums = [2,4,6,8]
 * 输出3：3
 */
public class T3432 {
    /**
     * 自己实现：根据题意模拟
     */
    public int countPartitions(int[] nums) {
        int ans = 0;
        int sumL = 0;
        int sumR = 0;
        // 先求全和
        for (int num : nums) {
            sumR += num;
        }

        // 以每一位为分割点，算左右两数组和之差
        for (int i = 1; i < nums.length; i++) {
            sumL += nums[i - 1];
            sumR -= nums[i - 1];
            if (Math.abs(sumL - sumR) % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 官方解法：数学运算
     * 只要总和为偶数，那么左右差值方案就有 n - 1个
     */
    public int countPartitions1(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        return totalSum % 2 == 0 ? nums.length - 1 : 0;
    }
}