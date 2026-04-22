package problems.c0easy.t3001t3500;

/**
 * 3427 变长子数组求和 https://leetcode.cn/problems/sum-of-variable-length-subarrays/description/
 * 给你一个长度为 n 的整数数组 nums 。对于 每个 下标 i（0 <= i < n），定义对应的子数组 nums[start ... i]
 * （start = max(0, i - nums[i])）。
 * 返回为数组中每个下标定义的子数组中所有元素的总和。
 * 子数组 是数组中的一个连续、非空 的元素序列。
 *
 * 示例：
 * 输入1：nums = [2,3,1]
 * 输出1：11
 *
 * 输入2：nums = [3,1,1,2]
 * 输出2：13
 */
public class T3427 {
    /**
     * 社区解法：暴力解法
     */
    public int subarraySum(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = Math.max(i - nums[i], 0); j <= i; j++) {
                ans += nums[j];
            }
        }
        return ans;
    }

    /**
     * 社区解法：前缀和
     */
    public int subarraySum2(int[] nums) {
        int n = nums.length;
        int[] s = new int[n + 1];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + nums[i];
            ans += s[i + 1] - s[Math.max(i - nums[i], 0)];
        }
        return ans;
    }
}
