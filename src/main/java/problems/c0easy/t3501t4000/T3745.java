package problems.c0easy.t3501t4000;

import java.util.Arrays;

/**
 * 3745 三元素表达式的最大值 https://leetcode.cn/problems/maximize-expression-of-three-elements/description/
 * 给你一个整数数组 nums。
 * 从 nums 中选择三个元素 a、b 和 c，它们的下标需 互不相同 ，使表达式 a + b - c 的值最大化。
 * 返回该表达式可能的 最大值 。
 *
 * 示例：
 * 输入1：nums = [1,4,2,5]
 * 输出1：8
 *
 * 输入2：nums = [-2,0,5,-2,4]
 * 输出2：11
 */
public class T3745 {
    /**
     * 自己实现：先排序，找到最大的两个数和最小的一个数即可
     */
    public int maximizeExpressionOfThree(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        return nums[n - 1] + nums[n - 2] - nums[0];
    }

    /**
     * 自己实现：不排序，减少损耗，遍历的过程中找到最大的两个数和最小的一个数即可
     */
    public int maximizeExpressionOfThree1(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (temp > max1) {
                max2 = max1;
                max1 = temp;
            } else if (temp > max2) {
                max2 = temp;
            }
            if (temp < min) {
                min = temp;
            }
        }

        return max1 + max2 - min;
    }
}
