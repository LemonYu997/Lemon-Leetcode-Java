package problems.c0easy.t2501t3000;

import java.util.Arrays;

/**
 * 2815 数组中的最大数对和 https://leetcode.cn/problems/max-pair-sum-in-an-array/description/
 * 给你一个下标从 0 开始的整数数组 nums 。请你从 nums 中找出和 最大 的一对数，且这两个数数位上最大的数字相等。
 * 返回最大和，如果不存在满足题意的数字对，返回 -1 。
 *
 * 示例：
 * 输入1：nums = [51,71,17,24,42]
 * 输出1：88
 *
 * 输入2：nums = [1,2,3,4]
 * 输出2：-1
 */
public class T2815 {
    /**
     * 自己实现：根据题意模拟
     */
    public int maxSum(int[] nums) {
        int ans = -1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int a = nums[i];
            int maxA = 0;
            while (a > 0) {
                maxA = Math.max(maxA, a % 10);
                a /= 10;
            }
            for (int j = i + 1; j < n; j++) {
                // 判断两个数数位上最大数字是否相等
                int b = nums[j];
                int maxB = 0;
                while (b > 0) {
                    maxB = Math.max(maxB, b % 10);
                    b /= 10;
                }

                if (maxA == maxB) {
                    ans = Math.max(ans, nums[i] + nums[j]);
                }
            }
        }

        return ans;
    }

    /**
     * 社区解法：一次遍历
     */
    public int maxSum1(int[] nums) {
        int ans = -1;
        // 已遍历数据中最大位所对应的最大值
        int[] maxVal = new int[10];
        // 初始不存在最大值
        Arrays.fill(maxVal, Integer.MIN_VALUE);
        for (int num : nums) {
            // 当前数字对应的最大位数值
            int maxD = 0;
            for (int x = num; x > 0; x /= 10) {
                maxD = Math.max(maxD, x % 10);
            }
            // maxVal[maxD] 表示已遍历数据中的当前数字所有位中的最大值
            // 如果存在相同的最大位值，在此时 num + maxVal[maxD] 肯定为正数
            // 如果不存在，因为其初始值为 Integer.MIN_VALUE，此时 num + maxVal[maxD] 一定比 ans 小
            ans = Math.max(ans, num + maxVal[maxD]);
            // 更新 maxVal[maxD]
            maxVal[maxD] = Math.max(maxVal[maxD], num);
        }
        return ans;
    }
}
