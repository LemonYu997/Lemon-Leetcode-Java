package problems.c0easy.t2001t2500;

import java.util.Arrays;

/**
 * 2389 和有限的最长子序列 https://leetcode.cn/problems/longest-subsequence-with-limited-sum/description/
 * 给你一个长度为 n 的整数数组 nums ，和一个长度为 m 的整数数组 queries 。
 * 返回一个长度为 m 的数组 answer ，其中 answer[i] 是 nums 中
 * 元素之和小于等于 queries[i] 的 子序列 的 最大 长度  。
 * 子序列 是由一个数组删除某些元素（也可以不删除）但不改变剩余元素顺序得到的一个数组。
 *
 * 示例：
 * 输入1：nums = [4,5,2,1], queries = [3,10,21]
 * 输出1：[2,3,4]
 *
 * 输入2：nums = [2,3,4,5], queries = [1]
 * 输出2：[0]
 */
public class T2389 {
    /**
     * 官方解法：二分查找
     */
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int m = queries.length;
        Arrays.sort(nums);
        // 排序后记录前缀和（贪心思想）
        int[] f = new int[n + 1];
        for (int i = 0; i < n; i++) {
            f[i + 1] = f[i] + nums[i];
        }
        int[] answer = new int[m];
        for (int i = 0; i < m; i++) {
            // 找到前缀和中离目标值最近位置的索引
            answer[i] = binarySearch(f, queries[i]) - 1;
        }
        return answer;
    }

    private int binarySearch(int[] f, int target) {
        int low = 1, high = f.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (f[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
