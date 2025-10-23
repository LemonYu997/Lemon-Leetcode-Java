package problems.c0easy.t2501t3000;

/**
 * 2873 有序三元组中的最大值 I https://leetcode.cn/problems/maximum-value-of-an-ordered-triplet-i/description/
 * 给你一个下标从 0 开始的整数数组 nums 。
 * 请你从所有满足 i < j < k 的下标三元组 (i, j, k) 中，找出并返回下标三元组的最大值。
 * 如果所有满足条件的三元组的值都是负数，则返回 0 。
 * 下标三元组 (i, j, k) 的值等于 (nums[i] - nums[j]) * nums[k] 。
 *
 * 示例：
 * 输入1：nums = [12,6,1,2,7]
 * 输出1：77
 *
 * 输入2：nums = [1,10,3,4,19]
 * 输出2：133
 *
 * 输入3：nums = [1,2,3]
 * 输出3：0
 */
public class T2873 {
    /**
     * 自己实现：根据题意遍历即可
     */
    public long maximumTripletValue(int[] nums) {
        long ans = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // 如果 nums[j] > nums[i] 可以直接跳过
                if (nums[j] < nums[i]) {
                    for (int k = j + 1; k < n; k++) {
                        ans = Math.max(ans, (long)(nums[i] - nums[j]) * nums[k]);
                    }
                }
            }
        }

        return ans;
    }

    /**
     * 优化解法：固定 k，找到 k 之前差值最大的两个数即可
     */
    public long maximumTripletValue1(int[] nums) {
        int n = nums.length;
        long ans = 0;
        long imax = 0;
        long dmax = 0;
        for (int k = 2; k < n; k++) {
            // i值 取过去数值里边最大的
            imax = Math.max(imax, (long) nums[k - 2]);
            // 差值取过去最大的差值
            dmax = Math.max(dmax, imax - nums[k - 1]);
            // 计算当前 k 值是否能获得最大值
            ans = Math.max(ans, dmax * nums[k]);
        }
        return ans;
    }
}
