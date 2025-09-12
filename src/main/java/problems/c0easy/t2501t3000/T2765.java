package problems.c0easy.t2501t3000;

/**
 * 2765 最长交替子数组 https://leetcode.cn/problems/longest-alternating-subarray/description/
 * 给你一个下标从 0 开始的整数数组 nums 。如果 nums 中长度为 m 的子数组 s 满足以下条件，我们称它是一个 交替子数组 ：
 * m 大于 1 。
 * s1 = s0 + 1 。
 * 下标从 0 开始的子数组 s 与数组 [s0, s1, s0, s1,...,s(m-1) % 2] 一样。
 * 也就是说，s1 - s0 = 1 ，s2 - s1 = -1 ，s3 - s2 = 1 ，s4 - s3 = -1 ，以此类推，直到 s[m - 1] - s[m - 2] = (-1)m 。
 * 请你返回 nums 中所有 交替 子数组中，最长的长度，如果不存在交替子数组，请你返回 -1 。
 * 子数组是一个数组中一段连续 非空 的元素序列。
 *
 * 示例：
 * 输入1：nums = [2,3,4,3,4]
 * 输出1：4
 *
 * 输入2：nums = [4,5,6]
 * 输出2：2
 */
public class T2765 {
    /**
     * 自己实现：根据题意模拟
     */
    public int alternatingSubarray(int[] nums) {
        int ans = 1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            int tempLen = 1;
            for (int j = i + 1; j < n; j++) {
                // 判断差值是否为 1，-1交替，满足条件则继续
                if ((flag && nums[j] - nums[j - 1] == 1) || (!flag && nums[j] - nums[j - 1] == -1)) {
                    tempLen++;
                    // 如果是最后一位，则更新
                    if (j == n - 1) {
                        ans = Math.max(ans, tempLen);
                    }
                } else {
                    // 不满足条件时更新结果
                    ans = Math.max(ans, tempLen);
                    break;
                }
                flag = !flag;
            }
        }

        // 如果只有 1 个数，是不满足子数组条件的
        return ans == 1 ? -1 : ans;
    }

    /**
     * 官方解法：单层循环
     */
    public int alternatingSubarray1(int[] nums) {
        int ans = -1;
        int n = nums.length;
        int first = 0;
        for (int i = 1; i < n; i++) {
            int len = i - first + 1;
            if (nums[i] - nums[first] == (len - 1) % 2) {
                ans = Math.max(ans, len);
            } else {
                if (nums[i] - nums[i - 1] == 1) {
                    first = i - 1;
                    ans = Math.max(ans, 2);
                } else {
                    first = i;
                }
            }
        }
        return ans;
    }
}