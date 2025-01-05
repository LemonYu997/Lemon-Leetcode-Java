package problems.c0easy.t1501t2000;

import java.util.Arrays;

/**
 * 1984 学生分数的最小差值 https://leetcode.cn/problems/minimum-difference-between-highest-and-lowest-of-k-scores/description/
 * 给你一个 下标从 0 开始 的整数数组 nums ，
 * 其中 nums[i] 表示第 i 名学生的分数。另给你一个整数 k 。
 * 从数组中选出任意 k 名学生的分数，使这 k 个分数间 最高分 和 最低分 的 差值 达到 最小化 。
 * 返回可能的 最小差值 。
 *
 * 示例：
 * 输入1：nums = [90], k = 1
 * 输出1：0
 *
 * 输入2：nums = [9,4,1,7], k = 2
 * 输出2:2
 */
public class T1984 {
    /**
     * 自己实现：顺序排序后，找到连续的 k 个数，计算其最大差值，并与结果比较
     */
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        int ans = Integer.MAX_VALUE;

        // 找到连续的 k 个数
        for (int i = 0; i + k - 1 < n; i++) {
            // 从当前位置起，找到第 k 个数，计算差值
            ans = Math.min(ans, nums[i + k - 1] - nums[i]);
        }

        return ans;
    }
}
