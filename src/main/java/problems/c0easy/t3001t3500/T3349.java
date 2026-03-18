package problems.c0easy.t3001t3500;

import java.util.List;

/**
 * 3349 检测相邻递增子数组 I https://leetcode.cn/problems/adjacent-increasing-subarrays-detection-i/description/
 * 给你一个由 n 个整数组成的数组 nums 和一个整数 k，请你确定是否存在 两个 相邻 且长度为 k 的 严格递增 子数组。
 * 具体来说，需要检查是否存在从下标 a 和 b (a < b) 开始的 两个 子数组，并满足下述全部条件：
 * 这两个子数组 nums[a..a + k - 1] 和 nums[b..b + k - 1] 都是 严格递增 的。
 * 这两个子数组必须是 相邻的，即 b = a + k。
 * 如果可以找到这样的 两个 子数组，请返回 true；否则返回 false。
 * 子数组 是数组中的一个连续 非空 的元素序列。
 *
 * 示例：
 * 输入1：nums = [2,5,7,8,9,2,3,4,3,1], k = 3
 * 输出1：true
 *
 * 输入2：nums = [1,2,3,4,4,4,4,5,6,7], k = 5
 * 输出2：false
 */
public class T3349 {
    /**
     * 官方解法：一次遍历
     */
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        for (int i = 0, j, pre = 0, cur; i < n; i++) {
            j = i;
            while (i + 1 < n && nums.get(i + 1) > nums.get(i)) {
                i++;
            }
            cur = i - j + 1;
            if (cur >= k * 2 || (pre >= k && cur >=k)) {
                return true;
            }
            pre = cur;
        }
        return false;
    }
}
