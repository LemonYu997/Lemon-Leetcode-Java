package problems.c0easy.t1501t2000;

import java.util.Arrays;

/**
 * 1991 找到数组的中间位置 https://leetcode.cn/problems/find-the-middle-index-in-array/description/
 * 给你一个下标从 0 开始的整数数组 nums ，
 * 请你找到 最左边 的中间位置 middleIndex （也就是所有可能中间位置下标最小的一个）。
 * 中间位置 middleIndex 是满足 nums[0] + nums[1] + ... + nums[middleIndex-1]
 * == nums[middleIndex+1] + nums[middleIndex+2] + ... + nums[nums.length-1] 的数组下标。
 * 如果 middleIndex == 0 ，左边部分的和定义为 0 。
 * 类似的，如果 middleIndex == nums.length - 1 ，右边部分的和定义为 0 。
 * 请你返回满足上述条件 最左边 的 middleIndex ，如果不存在这样的中间位置，请你返回 -1 。
 *
 * 示例：
 * 输入1：nums = [2,3,-1,8,4]
 * 输出1:3
 *
 * 输入2：nums = [1,-1,4]
 * 输出2:2
 *
 * 输入3：nums = [2,5]
 * 输出3：-1
 *
 * 输入4：nums = [1]
 * 输出4:0
 */
public class T1991 {
    /**
     * 自己实现：暴力求解
     */
    public int findMiddleIndex(int[] nums) {
        int n = nums.length;

        // 每一位都当做中间点进行测试
        for (int i = 0; i < n; i++) {
            int left = 0;
            for (int j = 0; j < i; j++) {
                left += nums[j];
            }

            int right = 0;
            for (int j = i + 1; j < n; j++) {
                right += nums[j];
            }

            if (left == right) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 优化解法：前缀和
     * 先计算数组的总和作为右侧值，再不断减去每一位的值，直到找到一致点
     */
    public int findMiddleIndex1(int[] nums) {
        // 数组总和
        int right = 0;
        for (int num : nums) {
            right += num;
        }

        // 以每一位作为中间点
        int n = nums.length;
        int left = 0;
        for (int i = 0; i < n; i++) {
            // 注意当前中间点是不计入左右侧总值计算的，所以右边也要减去当前值
            right -= nums[i];
            if (left == right) {
                return i;
            }

            // 如果左右不平衡，中间点就往前进一步，左侧将该值加上
            left += nums[i];
        }

        return -1;
    }
}
