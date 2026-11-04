package problems.c0easy.t4001t4500;

/**
 * 4088 峰值与谷值的差 https://leetcode.cn/problems/difference-between-peaks-and-valleys/description/
 * 给你一个长度为 n 的整数数组 nums。
 * 如果满足以下 所有 条件，则下标 i 被称为 峰值 ：
 * 0 < i < n - 1
 * nums[i] > nums[i - 1]
 * nums[i] > nums[i + 1]
 * 如果满足以下 所有 条件，则下标 i 被称为 谷值 ：
 * 0 < i < n - 1
 * nums[i] < nums[i - 1]
 * nums[i] < nums[i + 1]
 * 返回一个整数，表示所有峰值之和与所有谷值之和的 差值 。
 *
 * 示例：
 * 输入1：nums = [1,5,2,4,1,3,0]
 * 输出1：9
 *
 * 输入2：nums = [-5,-6,-1,-2,5,3,2]
 * 输出2：12
 *
 * 输入3：nums = [6,5,2,5,5,3,6]
 * 输出3：-5
 */
public class T4088 {
    public int peakValleyDifference(int[] nums) {
        int ans = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            int x = nums[i - 1], y = nums[i], z = nums[i + 1];
            if (x < y && y > z) {
                ans += y;
            } else if (x > y && y < z) {
                ans -= y;
            }
        }
        return ans;
    }
}
