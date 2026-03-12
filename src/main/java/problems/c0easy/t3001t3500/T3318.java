package problems.c0easy.t3001t3500;

/**
 * 3318 计算子数组的 x-sum I https://leetcode.cn/problems/find-x-sum-of-all-k-long-subarrays-i/description/
 * 给你一个由 n 个整数组成的数组 nums，以及两个整数 k 和 x。
 * 数组的 x-sum 计算按照以下步骤进行：
 * 统计数组中所有元素的出现次数。
 * 仅保留出现频率最高的前 x 种元素。如果两种元素的出现次数相同，则数值 较大 的元素被认为出现次数更多。
 * 计算结果数组的和。
 * 注意，如果数组中的不同元素少于 x 个，则其 x-sum 是数组的元素总和。
 * 返回一个长度为 n - k + 1 的整数数组 answer，其中 answer[i] 是 子数组 nums[i..i + k - 1] 的 x-sum。
 * 子数组 是数组内的一个连续 非空 的元素序列。
 *
 * 示例：
 * 输入1：nums = [1,1,2,2,3,4,2,3], k = 6, x = 2
 * 输出1：[6,10,12]
 *
 * 输入2：nums = [3,8,7,8,7,5], k = 2, x = 2
 * 输出2：[11,15,15,15,12]
 */
public class T3318 {
    /**
     *  社区解法：滑动窗口
     */
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int m = n - k + 1;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = xsum(nums, i, k, x);
        }
        return ans;
    }

    private int xsum(int[] nums, int i, int k, int x) {
        int[] freq = new int[51];
        for (int j = i; j < i + k; j++) {
            freq[nums[j]]++;
        }

        int ans = 0;
        while (x-- > 0) {
            int alpha = 0;
            for (int j = 0; j < freq.length; j++) {
                if (freq[alpha] < freq[j] || (freq[alpha] == freq[j] && alpha < j)) {
                    alpha = j;
                }
            }
            ans += alpha * freq[alpha];
            freq[alpha] = 0;
        }
        return ans;
    }
}
