package problems.c0easy.t1501t2000;

import java.util.Arrays;

/**
 * 1646 获取生成数组中的最大值 https://leetcode.cn/problems/get-maximum-in-generated-array/description/
 * 给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：
 *  nums[0] = 0
 *  nums[1] = 1
 *  当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
 *  当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
 * 返回生成数组 nums 中的 最大 值。
 *
 * 示例：
 * 输入1：n = 7
 * 输出1：3
 *
 * 输入2：n = 2
 * 输出2：1
 *
 * 输入3：n = 3
 * 输出3：2
 */
public class T1646 {
    /**
     * 自己实现：根据题意模拟
     */
    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int max = 1;
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;

        for (int i = 2; i <= n; i++) {
            // 偶数时 nums[2 * i] = nums[i]
            if (i % 2 == 0) {
                nums[i] = nums[i / 2];
            }
            // 奇数时 nums[2 * i + 1] = nums[i] + nums[i + 1]
            if (i % 2 == 1) {
                nums[i] = nums[i / 2] + nums[i / 2 + 1];
            }
            max = Math.max(max, nums[i]);
        }

        return max;
    }

    /**
     * 官方解法：优化上述写法
     */
    public int getMaximumGenerated1(int n) {
        if (n == 0) {
            return 0;
        }
        // nums[0] 默认为 0
        int[] nums = new int[n + 1];
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 如果是偶数不会加后边的
            nums[i] = nums[i / 2] + i % 2 * nums[i / 2 + 1];
        }

        return Arrays.stream(nums).max().getAsInt();
    }
}
