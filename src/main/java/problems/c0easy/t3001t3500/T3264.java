package problems.c0easy.t3001t3500;

/**
 * 3264 K 次乘运算后的最终数组 I https://leetcode.cn/problems/final-array-state-after-k-multiplication-operations-i/description/
 * 给你一个整数数组 nums ，一个整数 k  和一个整数 multiplier 。
 * 你需要对 nums 执行 k 次操作，每次操作中：
 * 找到 nums 中的 最小 值 x ，如果存在多个最小值，选择最 前面 的一个。
 * 将 x 替换为 x * multiplier 。
 * 请你返回执行完 k 次乘运算之后，最终的 nums 数组。
 *
 * 示例：
 * 输入1：nums = [2,1,3,5,6], k = 5, multiplier = 2
 * 输出1：[8,4,6,5,6]
 *
 * 输入2：nums = [1,2], k = 3, multiplier = 4
 * 输出2：[16,8]
 */
public class T3264 {
    /**
     * 官方解法：根据题意模拟
     */
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        // 执行 k 次操作
        for (int i = 0; i < k; i++) {
            int m = 0;
            // 找到最小值的索引
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[m]) {
                    m = j;
                }
            }
            // 修改其值
            nums[m] *= multiplier;
        }
        return nums;
    }
}
