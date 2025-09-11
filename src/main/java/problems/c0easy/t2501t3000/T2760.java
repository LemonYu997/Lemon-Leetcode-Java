package problems.c0easy.t2501t3000;

/**
 * 2760 最长奇偶子数组 https://leetcode.cn/problems/longest-even-odd-subarray-with-threshold/description/
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 threshold 。
 * 请你从 nums 的子数组中找出以下标 l 开头、下标 r 结尾 (0 <= l <= r < nums.length) 且满足以下条件的 最长子数组 ：
 * nums[l] % 2 == 0
 * 对于范围 [l, r - 1] 内的所有下标 i ，nums[i] % 2 != nums[i + 1] % 2
 * 对于范围 [l, r] 内的所有下标 i ，nums[i] <= threshold
 * 以整数形式返回满足题目要求的最长子数组的长度。
 * 注意：子数组 是数组中的一个连续非空元素序列。
 *
 * 示例：
 * 输入1：nums = [3,2,5,4], threshold = 5
 * 输出1：3
 *
 * 输入2：nums = [1,2], threshold = 2
 * 输出2：1
 *
 * 输入3：nums = [2,3,4,5], threshold = 4
 * 输出3：3
 */
public class T2760 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,5,4};
        int i = longestAlternatingSubarray(nums, 5);
        System.out.println(i);
    }

    /**
     * 自己实现：根据题意模拟
     */
    public static int longestAlternatingSubarray(int[] nums, int threshold) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            // i 为当前子字符串起始位，不满足条件时直接跳过
            if (nums[i] > threshold || nums[i] % 2 != 0) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                // 判断是否符合条件，不符合时则当前子字符串结束
                if (nums[j] > threshold || nums[j] % 2 == nums[j - 1] % 2) {
                    // 记录最大长度
                    ans = Math.max(ans, j - i);
                    break;
                }
                // 如果 j 为最后一位，且仍满足题目条件，则当前 i~j 即为最长子字符串
                if (j == n - 1) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
            // 如果 i 为最后一位，且满足条件，则长度为 1
            if (i == n - 1) {
                ans =Math.max(ans, 1);
            }
        }

        return ans;
    }

    public int longestAlternatingSubarray1(int[] nums, int threshold) {
        int ans = 0;
        int dp = 0;
        for (int l = nums.length - 1; l >= 0; l--) {
            if (nums[l] > threshold) {
                dp = 0;
            } else if (l == nums.length - 1 || nums[l] % 2 != nums[l + 1] % 2) {
                dp++;
            } else {
                dp = 1;
            }
            if (nums[l] % 2 == 0) {
                ans = Math.max(ans, dp);
            }
        }
        return ans;
    }
}
