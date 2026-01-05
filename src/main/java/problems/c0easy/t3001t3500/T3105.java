package problems.c0easy.t3001t3500;

/**
 * 3105 最长的严格递增或递减子数组 https://leetcode.cn/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/description/
 * 给你一个整数数组 nums 。
 * 返回数组 nums 中 严格递增 或 严格递减 的最长非空子数组的长度。
 *
 * 示例：
 * 输入1：nums = [1,4,3,3,2]
 * 输出1：2
 *
 * 输入2：nums = [3,3,3,3]
 * 输出2：1
 *
 * 输入3：nums = [3,2,1]
 * 输出3：3
 */
public class T3105 {
    /**
     * 社区解法：分别实现
     */
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int ans1 = 1;
        int ans2 = 1;
        int ans = 1;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                ans1++;
                ans2 = 1;
            } else if (nums[i] < nums[i + 1]) {
                ans2++;
                ans1 = 1;
            } else {
                ans1 = 1;
                ans2 = 1;
            }
            ans = Math.max(ans, Math.max(ans1, ans2));
        }
        return ans;
    }
}
