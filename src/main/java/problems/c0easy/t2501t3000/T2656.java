package problems.c0easy.t2501t3000;

import java.util.Arrays;

/**
 * 2656 K 个元素的最大和 https://leetcode.cn/problems/maximum-sum-with-exactly-k-elements/description/
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。你需要执行以下操作 恰好 k 次，最大化你的得分：
 * 从 nums 中选择一个元素 m 。
 * 将选中的元素 m 从数组中删除。
 * 将新元素 m + 1 添加到数组中。
 * 你的得分增加 m 。
 * 请你返回执行以上操作恰好 k 次后的最大得分。
 *
 * 示例：
 * 输入1：nums = [1,2,3,4,5], k = 3
 * 输出1：18
 *
 * 输入2：nums = [5,5,5], k = 2
 * 输出2：11
 */
public class T2656 {
    /**
     * 自己实现：选择 k 次 最大的数 n ，并且每次 + 1即可
     */
    public int maximizeSum(int[] nums, int k) {
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        int ans = 0;

        for (int i = 0; i < k; i++) {
            ans += max + i;
        }

        return ans;
    }

    /**
     * 官方解法：优化写法
     */
    public int maximizeSum1(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        return (2 * max + k - 1) * k / 2;
    }

    /**
     * 社区解法：不排序，减少消耗
     */
    public int maximizeSum2(int[] nums, int k) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return (2 * max + k - 1) * k / 2;
    }
}