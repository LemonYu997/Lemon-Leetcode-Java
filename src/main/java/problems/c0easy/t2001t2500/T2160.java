package problems.c0easy.t2001t2500;

import java.util.Arrays;

/**
 * 2160 拆分数位后四位数字的最小和 https://leetcode.cn/problems/minimum-sum-of-four-digit-number-after-splitting-digits/description/
 * 给你一个四位 正 整数 num 。请你使用 num 中的 数位 ，将 num 拆成两个新的整数 new1 和 new2 。
 * new1 和 new2 中可以有 前导 0 ，且 num 中 所有 数位都必须使用。
 *
 * 比方说，给你 num = 2932 ，你拥有的数位包括：两个 2 ，一个 9 和一个 3 。
 * 一些可能的 [new1, new2] 数对为 [22, 93]，[23, 92]，[223, 9] 和 [2, 329] 。
 * 请你返回可以得到的 new1 和 new2 的 最小 和。
 *
 * 示例：
 * 输入1：num = 2932
 * 输出1：52
 *
 * 输入2：num = 4009
 * 输出2：13
 */
public class T2160 {
    /**
     * 自己实现：两个数都从最小的数开始
     * 所以目标值 = min1 * 10 + min2 * 10 + 另外两个数
     */
    public int minimumSum(int num) {
        // 记录每一位
        int[] digits = new int[4];
        String s = Integer.toString(num);
        for (int i = 0; i < s.length(); i++) {
            digits[i] = s.charAt(i) - '0';
        }

        // 从小到大排序
        Arrays.sort(digits);

        return digits[0] * 10 + digits[1] * 10 + digits[2] + digits[3];
    }

    /**
     * 优化解法：获取每一位时更简单
     */
    public int minimumSum1(int num) {
        // 转数组
        int[] nums = new int[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = num % 10;
            num /= 10;
        }
        Arrays.sort(nums);

        return 10 * (nums[0] + nums[1]) + nums[2] + nums[3];
    }
}