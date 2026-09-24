package problems.c0easy.t4001t4500;

/**
 * 4010 数对的最大强度 https://leetcode.cn/problems/maximize-pair-strength-using-gcd/description/
 * 给你一个整数数组 nums。
 * 选择 恰好一对 不同下标 i 和 j。该数对的 强度 定义为：
 * (nums[i] * nums[j]) / gcd(nums[i], nums[j])2
 * 返回所有可能数对中的 最大 强度。
 * gcd(a, b) 表示 a 和 b 的 最大公约数 。
 *
 * 示例：
 * 输入1：nums = [2,3,5]
 * 输出1：15
 *
 * 输入2：nums = [4,6,8]
 * 输出2：12
 *
 * 输入3：nums = [3,3]
 * 输出3：1
 */
public class T4010 {
    /**
     * 社区解法：模拟
     */
    public long maxPairStrength(int[] nums) {
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                long g = gcd(nums[i], nums[j]);
                ans = Math.max(ans, (long) nums[i] * nums[j] / (g * g));
            }
        }
        return ans;
    }

    private int gcd(int a, int b) {
        while (a != 0) {
            int tmp = a;
            a = b % a;
            b = tmp;
        }
        return b;
    }
}
