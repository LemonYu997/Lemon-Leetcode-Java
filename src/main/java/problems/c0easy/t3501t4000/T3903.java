package problems.c0easy.t3501t4000;

/**
 * 3903 最小稳定下标 I https://leetcode.cn/problems/smallest-stable-index-i/description/
 * 给你一个长度为 n 的整数数组 nums 和一个整数 k。
 * 对于每个下标 i，定义它的 不稳定值 为 max(nums[0..i]) - min(nums[i..n - 1])。
 * 换句话说：
 * max(nums[0..i]) 表示从下标 0 到下标 i 的元素中的 最大值 。
 * min(nums[i..n - 1]) 表示从下标 i 到下标 n - 1 的元素中的 最小值 。
 * 如果某个下标 i 的不稳定值 小于等于 k，则称该下标为 稳定下标 。
 * 返回 最小 的稳定下标。如果不存在这样的下标，则返回 -1。
 *
 * 示例：
 * 输入1：nums = [5,0,1,4], k = 3
 * 输出1：3
 *
 * 输入2：nums = [3,2,1], k = 1
 * 输出2：-1
 *
 * 输入3：nums = [0], k = 0
 * 输出3：0
 */
public class T3903 {
    /**
     * 自己实现：前后缀分解
     */
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        // 后缀最小值
        int[] sufMin = new int[n];
        sufMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sufMin[i] = Math.min(sufMin[i + 1], nums[i]);
        }

        // 前缀最大值
        int preMax = 0;
        for (int i = 0; i < n; i++) {
            preMax = Math.max(preMax, nums[i]);
            if (preMax - sufMin[i] <= k) {
                return i;
            }
        }

        return -1;
    }
}
