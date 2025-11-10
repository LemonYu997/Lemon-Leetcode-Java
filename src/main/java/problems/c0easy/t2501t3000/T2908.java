package problems.c0easy.t2501t3000;

/**
 * 2908 元素和最小的山形三元组 I https://leetcode.cn/problems/minimum-sum-of-mountain-triplets-i/description/
 * 给你一个下标从 0 开始的整数数组 nums 。
 * 如果下标三元组 (i, j, k) 满足下述全部条件，则认为它是一个 山形三元组 ：
 * i < j < k
 * nums[i] < nums[j] 且 nums[k] < nums[j]
 * 请你找出 nums 中 元素和最小 的山形三元组，并返回其 元素和 。如果不存在满足条件的三元组，返回 -1 。
 *
 * 示例：
 * 输入1：nums = [8,6,1,5,3]
 * 输出1：9
 *
 * 输入2：nums = [5,4,8,7,10,2]
 * 输出2：13
 *
 * 输入3：nums = [6,5,4,3,4,5]
 * 输出3：-1
 */
public class T2908 {
    /**
     * 自己实现：根据题意遍历即可
     */
    public int minimumSum(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[j] > nums[i] && nums[j] > nums[k]) {
                        ans = Math.min(ans, nums[i] + nums[j] + nums[k]);
                    }
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    /**
     * 官方解法：数组
     */
    public int minimumSum1(int[] nums) {
        int n = nums.length;
        int res = 1000;
        int mn = 1000;
        int[] left = new int[n];
        for (int i = 1; i < n; i++) {
            left[i] = mn = Math.min(nums[i -1], mn);
        }
        int right = nums[n - 1];
        for (int i = n - 2; i > 0; i--) {
            if (left[i] < nums[i] && nums[i] > right) {
                res = Math.min(res, left[i] + nums[i] + right);
            }
            right = Math.min(right, nums[i]);
        }

        return res < 1000 ? res : -1;
    }
}
